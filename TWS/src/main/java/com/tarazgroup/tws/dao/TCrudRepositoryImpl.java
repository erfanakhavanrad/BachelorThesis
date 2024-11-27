package com.tarazgroup.tws.dao;

import com.crystaldecisions.sdk.occa.report.application.ParameterFieldController;
import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.exportoptions.ReportExportFormat;
import com.crystaldecisions.sdk.occa.report.lib.ReportSDKException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.tarazgroup.tws.model.crm.CrmFormFieldValueTypeAk;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.excel.TExcel;
import com.tarazgroup.tws.util.exception.*;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.TParams;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.security.JWTTokenUtil;
import com.tarazgroup.tws.util.tabletype.TSerial;
import com.tarazgroup.tws.util.tabletype.acc.AccVDTblType;
//import com.tarazgroup.tws.util.tabletype.crm.CrmFormFieldValueType;
import com.tarazgroup.tws.util.tabletype.inv.InvGroupFormulaTblType;
import com.tarazgroup.tws.util.tabletype.inv.InvVDTblType;
import com.tarazgroup.tws.util.tabletype.pub.PubUserBATblType;
import com.tarazgroup.tws.util.tabletype.sale.SaleVDTblType;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.exception.SQLGrammarException;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.jdbc.Work;
import org.hibernate.procedure.ProcedureCallMemento;
import org.hibernate.procedure.internal.ProcedureCallImpl;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.core.io.InputStreamResource;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.transaction.Transactional;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("DuplicatedCode")
@Service
public class TCrudRepositoryImpl<T extends TParams> implements TCrudRepository<T> {

    private final HttpServletRequest request;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public TCrudRepositoryImpl(HttpServletRequest request) {
        this.request = request;
    }


    @Override
    @Transactional
    public T insSPI(T t) {
        LogLogins logLogins = fetchUserDetail();
        Field pkField = getPKField(t);
        String tableName = getTableName(t);
        BigDecimal newID = (BigDecimal) entityManager.createNativeQuery("DECLARE @NewID DECIMAL;DECLARE @ServerID DECIMAL;SELECT @ServerID = ISNULL(U.DefaultServerID,1)  FROM PubUsers U WHERE UserID = " + logLogins.getPubUser().getUserID() + ";SELECT @NewID = ISNULL(Max([" + pkField.getAnnotation(javax.persistence.Column.class).name() + "]),10000000 * @ServerID)+ 1 FROM [" + tableName + "];SELECT @NewID;").getSingleResult();
        setPKValue(t, pkField, newID);
        entityManager.persist(t);
        return t;
    }

    @Override
    public LogLogins fetchUserDetail() {
        if (request.getHeader("Authorization") == null)
            throw new InternalAuthenticationServiceException("Authorization Header Is Empty");
        String authentication = request.getHeader("Authorization");
        Double loginIDFromToken = new JWTTokenUtil().getLoginIDFromToken(authentication.substring(7));

        Query query = entityManager.createQuery("select o from LogLogins o where " + "o.loginId = :loginID ").setParameter("loginID", new BigDecimal(loginIDFromToken.intValue()));
        List<LogLogins> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            throw new TUnAuthorizedException();
        }
        return resultList.get(0);
    }

    private StoredProcedureParameter[] _storedProcedureParameter(Class<T> clazz, String storedProcedureName) {
        for (Annotation annotation : clazz.getDeclaredAnnotations()) {
            if (annotation.annotationType() == javax.persistence.NamedStoredProcedureQuery.class) {
                javax.persistence.NamedStoredProcedureQuery namedStoredProcedureQuery = (javax.persistence.NamedStoredProcedureQuery) annotation;
                return namedStoredProcedureQuery.parameters();
            } else if (annotation.annotationType() == javax.persistence.NamedStoredProcedureQueries.class) {
                javax.persistence.NamedStoredProcedureQueries namedStoredProcedureQueries = (javax.persistence.NamedStoredProcedureQueries) annotation;
                NamedStoredProcedureQuery[] namedStoredProcedureQueries1 = namedStoredProcedureQueries.value();
                for (javax.persistence.NamedStoredProcedureQuery namedStoredProcedureQuery : namedStoredProcedureQueries1) {
                    if (namedStoredProcedureQuery.procedureName().equals(storedProcedureName)) {
                        return namedStoredProcedureQuery.parameters();
                    }
                }
            }
        }
        return null;
    }

    private List<TParameter<?>> _setTParametersTypeAndMode(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParameters) {
        List<TParameter<?>> tParameters1 = new ArrayList<>();
        StoredProcedureParameter[] storedProcedureParameters = _storedProcedureParameter(clazz, storedProcedureName);
        for (StoredProcedureParameter storedProcedureParameter : storedProcedureParameters) {
            switch (storedProcedureParameter.mode()) {
                case IN:
                    TParameter tParameterIn = tParameters.stream().filter(tp -> tp.getName().toLowerCase().equals(storedProcedureParameter.name().toLowerCase())).findAny().orElse(null);
                    tParameterIn.setParameterMode(ParameterMode.IN);
                    tParameterIn.setType1(storedProcedureParameter.type());
                    tParameters1.add(tParameterIn);

                    break;

                default:
                    TParameter tParameterOut = new TParameter(storedProcedureParameter.name(), null);
                    tParameterOut.setParameterMode(ParameterMode.OUT);
                    tParameterOut.setType1(storedProcedureParameter.type());
                    tParameters1.add(tParameterOut);
                    break;
            }
        }
        return tParameters1;
    }

    private String _createSPQueryTSerial(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams, boolean hasResultErrMsgNewID) {
        StringBuilder sqlQuery = new StringBuilder();
        List<TParameter<?>> tParameters = _setTParametersTypeAndMode(clazz, storedProcedureName, tParams);

        // Declare Out Params and Table Type Params
        for (TParameter tParameter : tParameters) {
            switch (tParameter.getParameterMode()) {
                case OUT:
                    sqlQuery.append("DECLARE @").append(tParameter.getName());
                    if (tParameter.getType1().equals(java.math.BigDecimal.class)) {
                        sqlQuery.append(" DECIMAL(38,4)").append("\n");
                    } else if (tParameter.getType1().equals(java.lang.String.class)) {
                        sqlQuery.append(" NVARCHAR(MAX)").append("\n");
                    } else if (tParameter.getType1().equals(java.util.Date.class)) {
                        sqlQuery.append(" DATETIME").append("\n");
                    } else if (tParameter.getType1().equals(java.lang.Boolean.class)) {
                        sqlQuery.append(" BIT").append("\n");
                    } else if (tParameter.getType1().equals(java.sql.Timestamp.class)) {
                        sqlQuery.append(" TIMESTAMP").append("\n");
                    }
                    break;

                default:
                    if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.TempT2.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TempT2").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.SQLServerDataRecord.SQLServerDataRecordInvGroupFormulaTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TElement").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.TempT3.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TempT3").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.inv.InvVDTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.InvVDTblType").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.sale.SaleVDTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.SaleVDTblType").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.acc.AccVDTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.AccVDTblType").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.TSerial.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TSerial").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.TElement.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TElement").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.inv.InvGroupFormulaTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.InvGroupFormulaTblType").append("\n");
                    }
//                    else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.crm.CrmFormFieldValueType.class)) {
//                        sqlQuery.append("DECLARE @").append(tParameter.getName());
//                        sqlQuery.append(" dbo.CrmFormFieldValueType").append("\n");
//                    }
                    else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.pub.PubUserBATblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.PubUserBATblType").append("\n");
                    } else if (tParameter.getType1().equals(CrmFormFieldValueTypeAk.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.CrmFormFieldValueTypeAk").append("\n");
                    } else if (tParameter.getType1().equals(TSerial.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TSerial").append("\n");
                    }
                    break;
            }

        }

        for (TParameter tParameter : tParameters) {
            if (tParameter.isTableType() && tParameter.getValue() != null) {
                ArrayList arrayList = (ArrayList) tParameter.getValue();
                if (tParameter.getType1().equals(SaleVDTblType.class)) {
                    for (SaleVDTblType saleVDTblType : (ArrayList<SaleVDTblType>) arrayList) {
                        StringBuilder query = saleVDTblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(AccVDTblType.class)) {
                    for (AccVDTblType accVDTblType : (ArrayList<AccVDTblType>) arrayList) {
                        StringBuilder query = accVDTblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(InvVDTblType.class)) {
                    for (InvVDTblType invVDTblType : (ArrayList<InvVDTblType>) arrayList) {
                        StringBuilder query = invVDTblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(InvGroupFormulaTblType.class)) {
                    for (InvGroupFormulaTblType invGroupFormulaTblType : (ArrayList<InvGroupFormulaTblType>) arrayList) {
                        StringBuilder query = invGroupFormulaTblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                }
//                else if (tParameter.getType1().equals(CrmFormFieldValueType.class)) {
//                    for (CrmFormFieldValueType crmFormFieldValueType : (ArrayList<CrmFormFieldValueType>) arrayList) {
//                        StringBuilder query = crmFormFieldValueType.createQuery(tParameter.getName());
//                        sqlQuery.append(query).append("\n");
//                    }
//                }
                else if (tParameter.getType1().equals(PubUserBATblType.class)) {
                    for (PubUserBATblType pubUserBATblType : (ArrayList<PubUserBATblType>) arrayList) {
                        StringBuilder query = pubUserBATblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(CrmFormFieldValueTypeAk.class)) {
                    for (CrmFormFieldValueTypeAk crmFormFieldValueTypeAk : (ArrayList<CrmFormFieldValueTypeAk>) arrayList) {
                        StringBuilder query = crmFormFieldValueTypeAk.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(TSerial.class)) {
                    for (TSerial tSerial : (ArrayList<TSerial>) arrayList) {
                        StringBuilder query = tSerial.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                }


            }
        }

        sqlQuery.append("EXEC ").append(storedProcedureName).append("\n");
        // EXEC SP
        for (TParameter tParameter : tParameters) {
            switch (tParameter.getParameterMode()) {
                case IN:
                    if (tParameter.isTableType()) {
                        sqlQuery.append("@").append(tParameter.getName()).append(", --").append(tParameter.getName()).append("\n");
                    } else {
                        if (tParameter.getType1().equals(java.math.BigDecimal.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append(tParameter.getValue()).append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.lang.Integer.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append(tParameter.getValue()).append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.lang.String.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append("'").append(tParameter.getValue()).append("'").append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.util.Date.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append("'").append(tParameter.getValue()).append("'").append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.lang.Boolean.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                String val = "";
                                Boolean bol = (Boolean) tParameter.getValue();
                                if (bol.booleanValue()) {
                                    val = "1";
                                } else {
                                    val = "0";
                                }
                                sqlQuery.append(val).append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.sql.Timestamp.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append(tParameter.getValue()).append(", --").append(tParameter.getName()).append("\n");
                            }
                        }
                    }
                    break;
                default:// OUT
                    sqlQuery.append("@").append(tParameter.getName()).append(" OUTPUT").append(", --").append(tParameter.getName()).append("\n");
                    break;
            }
        }
        TParameter tParameterLast = tParameters.get(tParameters.size() - 1);
        sqlQuery.delete(sqlQuery.length() - 1 - (", --" + tParameterLast.getName()).length(), sqlQuery.length());
        sqlQuery.append(" --").append(tParameterLast.getName()).append("\n");
        if (hasResultErrMsgNewID) {
            // SELECT @Result AS Result,@ErrMsg AS ErrMsg,@NewID AS NewID
            sqlQuery.append("SELECT ");
            for (TParameter tParameter : tParameters) {
                switch (tParameter.getParameterMode()) {
                    case OUT:
                        sqlQuery.append("@").append(tParameter.getName()).append(" AS ").append(tParameter.getName()).append(",");
                        break;
                }
            }
            sqlQuery.delete(sqlQuery.length() - 1, sqlQuery.length());
        }
        return sqlQuery.toString();
    }

    private String _createSPQuery(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams, boolean hasResultErrMsgNewID) {
        StringBuilder sqlQuery = new StringBuilder();
        List<TParameter<?>> tParameters = _setTParametersTypeAndMode(clazz, storedProcedureName, tParams);

        // Declare Out Params and Table Type Params
        for (TParameter tParameter : tParameters) {
            switch (tParameter.getParameterMode()) {
                case OUT:
                    sqlQuery.append("DECLARE @").append(tParameter.getName());
                    if (tParameter.getType1().equals(java.math.BigDecimal.class)) {
                        sqlQuery.append(" DECIMAL(38,4)").append("\n");
                    } else if (tParameter.getType1().equals(java.lang.String.class)) {
                        sqlQuery.append(" NVARCHAR(MAX)").append("\n");
                    } else if (tParameter.getType1().equals(java.util.Date.class)) {
                        sqlQuery.append(" DATETIME").append("\n");
                    } else if (tParameter.getType1().equals(java.lang.Boolean.class)) {
                        sqlQuery.append(" BIT").append("\n");
                    } else if (tParameter.getType1().equals(java.sql.Timestamp.class)) {
                        sqlQuery.append(" TIMESTAMP").append("\n");
                    }
                    break;

                default:
                    if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.TempT2.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TempT2").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.SQLServerDataRecord.SQLServerDataRecordInvGroupFormulaTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TElement").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.TempT3.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TempT3").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.inv.InvVDTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.InvVDTblType").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.sale.SaleVDTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.SaleVDTblType").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.acc.AccVDTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.AccVDTblType").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.TSerial.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TSerial").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.TElement.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TElement").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.inv.InvGroupFormulaTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.InvGroupFormulaTblType").append("\n");
                    }
//                    else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.crm.CrmFormFieldValueType.class)) {
//                        sqlQuery.append("DECLARE @").append(tParameter.getName());
//                        sqlQuery.append(" dbo.CrmFormFieldValueType").append("\n");
//                    }
                    else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.pub.PubUserBATblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.PubUserBATblType").append("\n");
                    } else if (tParameter.getType1().equals(CrmFormFieldValueTypeAk.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.CrmFormFieldValueTypeAk").append("\n");
                    }
                    break;
            }

        }

        for (TParameter tParameter : tParameters) {
            if (tParameter.isTableType() && tParameter.getValue() != null) {
                ArrayList arrayList = (ArrayList) tParameter.getValue();
                if (tParameter.getType1().equals(SaleVDTblType.class)) {
                    for (SaleVDTblType saleVDTblType : (ArrayList<SaleVDTblType>) arrayList) {
                        StringBuilder query = saleVDTblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(AccVDTblType.class)) {
                    for (AccVDTblType accVDTblType : (ArrayList<AccVDTblType>) arrayList) {
                        StringBuilder query = accVDTblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(InvVDTblType.class)) {
                    for (InvVDTblType invVDTblType : (ArrayList<InvVDTblType>) arrayList) {
                        StringBuilder query = invVDTblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(InvGroupFormulaTblType.class)) {
                    for (InvGroupFormulaTblType invGroupFormulaTblType : (ArrayList<InvGroupFormulaTblType>) arrayList) {
                        StringBuilder query = invGroupFormulaTblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                }
//                else if (tParameter.getType1().equals(CrmFormFieldValueType.class)) {
//                    for (CrmFormFieldValueType crmFormFieldValueType : (ArrayList<CrmFormFieldValueType>) arrayList) {
//                        StringBuilder query = crmFormFieldValueType.createQuery(tParameter.getName());
//                        sqlQuery.append(query).append("\n");
//                    }
//                }
                else if (tParameter.getType1().equals(PubUserBATblType.class)) {
                    for (PubUserBATblType pubUserBATblType : (ArrayList<PubUserBATblType>) arrayList) {
                        StringBuilder query = pubUserBATblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(CrmFormFieldValueTypeAk.class)) {
                    for (CrmFormFieldValueTypeAk crmFormFieldValueTypeAk : (ArrayList<CrmFormFieldValueTypeAk>) arrayList) {
                        StringBuilder query = crmFormFieldValueTypeAk.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                }

            }
        }

        sqlQuery.append("EXEC ").append(storedProcedureName).append("\n");
        // EXEC SP
        for (TParameter tParameter : tParameters) {
            switch (tParameter.getParameterMode()) {
                case IN:
                    if (tParameter.isTableType()) {
                        sqlQuery.append("@").append(tParameter.getName()).append(", --").append(tParameter.getName()).append("\n");
                    } else {
                        if (tParameter.getType1().equals(java.math.BigDecimal.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append(tParameter.getValue()).append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.lang.Integer.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append(tParameter.getValue()).append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.lang.String.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append("'").append(tParameter.getValue()).append("'").append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.util.Date.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append("'").append(tParameter.getValue()).append("'").append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.lang.Boolean.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                String val = "";
                                Boolean bol = (Boolean) tParameter.getValue();
                                if (bol.booleanValue()) {
                                    val = "1";
                                } else {
                                    val = "0";
                                }
                                sqlQuery.append(val).append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.sql.Timestamp.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append(tParameter.getValue()).append(", --").append(tParameter.getName()).append("\n");
                            }
                        }
                    }
                    break;
                default:// OUT
                    sqlQuery.append("@").append(tParameter.getName()).append(" OUTPUT").append(", --").append(tParameter.getName()).append("\n");
                    break;
            }
        }
        TParameter tParameterLast = tParameters.get(tParameters.size() - 1);
        sqlQuery.delete(sqlQuery.length() - 1 - (", --" + tParameterLast.getName()).length(), sqlQuery.length());
        sqlQuery.append(" --").append(tParameterLast.getName()).append("\n");
        if (hasResultErrMsgNewID) {
            // SELECT @Result AS Result,@ErrMsg AS ErrMsg,@NewID AS NewID
            sqlQuery.append("SELECT ");
            for (TParameter tParameter : tParameters) {
                switch (tParameter.getParameterMode()) {
                    case OUT:
                        sqlQuery.append("@").append(tParameter.getName()).append(" AS ").append(tParameter.getName()).append(",");
                        break;
                }
            }
            sqlQuery.delete(sqlQuery.length() - 1, sqlQuery.length());
        }
        return sqlQuery.toString();
    }

    private String _createSPQuery2(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams, boolean hasResultErrMsgNewID) {
        StringBuilder sqlQuery = new StringBuilder();
        List<TParameter<?>> tParameters = _setTParametersTypeAndMode(clazz, storedProcedureName, tParams);

        // Declare Out Params and Table Type Params
        for (TParameter tParameter : tParameters) {
            switch (tParameter.getParameterMode()) {
                case OUT:
                    sqlQuery.append("DECLARE @").append(tParameter.getName());
                    if (tParameter.getType1().equals(java.math.BigDecimal.class)) {
                        sqlQuery.append(" DECIMAL(38,4)").append("\n");
                    } else if (tParameter.getType1().equals(java.lang.String.class)) {
                        sqlQuery.append(" NVARCHAR(MAX)").append("\n");
                    } else if (tParameter.getType1().equals(java.util.Date.class)) {
                        sqlQuery.append(" DATETIME").append("\n");
                    } else if (tParameter.getType1().equals(java.lang.Boolean.class)) {
                        sqlQuery.append(" BIT").append("\n");
                    } else if (tParameter.getType1().equals(java.sql.Timestamp.class)) {
                        sqlQuery.append(" TIMESTAMP").append("\n");
                    }
                    break;

                default:
                    if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.TempT2.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TempT2").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.SQLServerDataRecord.SQLServerDataRecordInvGroupFormulaTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TElement").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.TempT3.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TempT3").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.inv.InvVDTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.InvVDTblType").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.sale.SaleVDTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.SaleVDTblType").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.acc.AccVDTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.AccVDTblType").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.TSerial.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TSerial").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.TElement.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.TElement").append("\n");
                    } else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.inv.InvGroupFormulaTblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.InvGroupFormulaTblType").append("\n");
                    }
//                    else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.crm.CrmFormFieldValueType.class)) {
//                        sqlQuery.append("DECLARE @").append(tParameter.getName());
//                        sqlQuery.append(" dbo.CrmFormFieldValueType").append("\n");
//                    }
                    else if (tParameter.getType1().equals(com.tarazgroup.tws.util.tabletype.pub.PubUserBATblType.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.PubUserBATblType").append("\n");
                    } else if (tParameter.getType1().equals(CrmFormFieldValueTypeAk.class)) {
                        sqlQuery.append("DECLARE @").append(tParameter.getName());
                        sqlQuery.append(" dbo.CrmFormFieldValueTypeAk").append("\n");
                    }
                    break;
            }

        }

        for (TParameter tParameter : tParameters) {
            if (tParameter.isTableType() && tParameter.getValue() != null) {
                ArrayList arrayList = (ArrayList) tParameter.getValue();
                if (tParameter.getType1().equals(SaleVDTblType.class)) {
                    for (SaleVDTblType saleVDTblType : (ArrayList<SaleVDTblType>) arrayList) {
                        StringBuilder query = saleVDTblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(AccVDTblType.class)) {
                    for (AccVDTblType accVDTblType : (ArrayList<AccVDTblType>) arrayList) {
                        StringBuilder query = accVDTblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(InvVDTblType.class)) {
                    for (InvVDTblType invVDTblType : (ArrayList<InvVDTblType>) arrayList) {
                        StringBuilder query = invVDTblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(InvGroupFormulaTblType.class)) {
                    for (InvGroupFormulaTblType invGroupFormulaTblType : (ArrayList<InvGroupFormulaTblType>) arrayList) {
                        StringBuilder query = invGroupFormulaTblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                }
//                else if (tParameter.getType1().equals(CrmFormFieldValueType.class)) {
//                    for (CrmFormFieldValueType crmFormFieldValueType : (ArrayList<CrmFormFieldValueType>) arrayList) {
//                        StringBuilder query = crmFormFieldValueType.createQuery(tParameter.getName());
//                        sqlQuery.append(query).append("\n");
//                    }
//                }
                else if (tParameter.getType1().equals(PubUserBATblType.class)) {
                    for (PubUserBATblType pubUserBATblType : (ArrayList<PubUserBATblType>) arrayList) {
                        StringBuilder query = pubUserBATblType.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(CrmFormFieldValueTypeAk.class)) {
                    for (CrmFormFieldValueTypeAk crmFormFieldValueTypeAk : (ArrayList<CrmFormFieldValueTypeAk>) arrayList) {
                        StringBuilder query = crmFormFieldValueTypeAk.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                } else if (tParameter.getType1().equals(TSerial.class)) {
                    for (CrmFormFieldValueTypeAk crmFormFieldValueTypeAk : (ArrayList<CrmFormFieldValueTypeAk>) arrayList) {
                        StringBuilder query = crmFormFieldValueTypeAk.createQuery(tParameter.getName());
                        sqlQuery.append(query).append("\n");
                    }
                }

            }
        }

        sqlQuery.append("EXEC ").append(storedProcedureName).append("\n");
        // EXEC SP
        for (TParameter tParameter : tParameters) {
            switch (tParameter.getParameterMode()) {
                case IN:
                    if (tParameter.isTableType()) {
                        sqlQuery.append("@").append(tParameter.getName()).append(", --").append(tParameter.getName()).append("\n");
                    } else {
                        if (tParameter.getType1().equals(java.math.BigDecimal.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append(tParameter.getValue()).append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.lang.Integer.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append(tParameter.getValue()).append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.lang.String.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append("'").append(tParameter.getValue()).append("'").append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.util.Date.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append("'").append(tParameter.getValue()).append("'").append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.lang.Boolean.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                String val = "";
                                Boolean bol = (Boolean) tParameter.getValue();
                                if (bol.booleanValue()) {
                                    val = "1";
                                } else {
                                    val = "0";
                                }
                                sqlQuery.append(val).append(", --").append(tParameter.getName()).append("\n");
                            }
                        } else if (tParameter.getType1().equals(java.sql.Timestamp.class)) {
                            if (tParameter.getValue() == null) {
                                sqlQuery.append("NULL").append(", --").append(tParameter.getName()).append("\n");
                            } else {
                                sqlQuery.append(tParameter.getValue()).append(", --").append(tParameter.getName()).append("\n");
                            }
                        }
                    }
                    break;
                default:// OUT
                    sqlQuery.append("@").append(tParameter.getName()).append(" OUTPUT").append(", --").append(tParameter.getName()).append("\n");
                    break;
            }
        }
        TParameter tParameterLast = tParameters.get(tParameters.size() - 1);
        sqlQuery.delete(sqlQuery.length() - 1 - (", --" + tParameterLast.getName()).length(), sqlQuery.length());
        sqlQuery.append(" --").append(tParameterLast.getName()).append("\n");
        if (hasResultErrMsgNewID) {
            // SELECT @Result AS Result,@ErrMsg AS ErrMsg,@NewID AS NewID
            sqlQuery.append("SELECT ");
            for (TParameter tParameter : tParameters) {
                switch (tParameter.getParameterMode()) {
                    case OUT:
                        sqlQuery.append("@").append(tParameter.getName()).append(" AS ").append(tParameter.getName()).append(",");
                        break;
                }
            }
            sqlQuery.delete(sqlQuery.length() - 1, sqlQuery.length());
        }
        return sqlQuery.toString();
    }


    private List<Map<String, Object>> _nativeQueryResultList(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams, boolean hasResultErrMsgNewID) {
        String sqlString = _createSPQuery(clazz, storedProcedureName, tParams, hasResultErrMsgNewID);
        Query query = entityManager.createNativeQuery(sqlString);
        NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List rows = nativeQuery.getResultList();
        return rows;
    }

    private List<Map<String, Object>> _nativeQueryResultListTserial(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams, boolean hasResultErrMsgNewID) {
        String sqlString = _createSPQueryTSerial(clazz, storedProcedureName, tParams, hasResultErrMsgNewID);
        Query query = entityManager.createNativeQuery(sqlString);
        NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List rows = nativeQuery.getResultList();
        return rows;
    }

    private List<Map<String, Object>> _nativeQueryResultList2(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams, boolean hasResultErrMsgNewID) {
        String sqlString = _createSPQuery2(clazz, storedProcedureName, tParams, hasResultErrMsgNewID);
        Query query = entityManager.createNativeQuery(sqlString);
        NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List rows = nativeQuery.getResultList();
        return rows;
    }

    /***********************************************************************************************************************************************/
    private List<Map<String, Object>> _nativeQueryResultListForMultiResultSet(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams, boolean hasResultErrMsgNewID) {
        String sqlString = _createSPQuery(clazz, storedProcedureName, tParams, hasResultErrMsgNewID);
        Query query = entityManager.createNativeQuery(sqlString);
//        Query query = entityManager.createNativeQuery(myString2);
        NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
//        NativeQueryImpl nativeQuery = (NativeQueryImpl) execSPNativeQueryTestAK(query);
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List rows = nativeQuery.getResultList();
        return rows;
    }

    /***********************************************************************************************************************************************/

    @Override
    public List<?> execSPNativeQueryTestAK(String query) {
        List<List<HashMap<String, Object>>> resultArray = new ArrayList<>();
        System.out.println("Query is " + query);
        Session session = entityManager.unwrap(Session.class);
        HashMap<String, Object> objectMap = new HashMap<>();
        session.doWork(new Work() {

            @Override
            public void execute(Connection connection) throws SQLException {
                Boolean results = false;
                try {

//                    PreparedStatement stmt = connection.prepareStatement(query);
//                    boolean results = stmt.execute(query);
                    Statement stmt = connection.createStatement();

                    stmt.execute(query);
                    // Use Connection to create a Statement object
                    ResultSet resultSet = stmt.executeQuery(query);
                    if (resultSet.wasNull()) {
                        System.out.println("Was null");
                    } else {
                        System.out.println("Wasn't null");
                        results = true;
                    }
                    int rsCount = 0;

                    ResultSet resultSetData;
                    ResultSetMetaData resultSetMetaData;

                    do {
                        if (results) {

//                            for (int i = 0; i < resultSet.getFetchSize(); i++) {
//                                System.out.println("Page size is "+ resultSet.getFetchSize());
//                                resultSet.getString(i);
//                                resultSet.getObject(i);
//                                System.out.println("resultSetMetaData.getColumnLabel(i) " + resultSet.getColumnLabel(i));
//                                System.out.println("resultSetData.getObject(i).toString() " + resultSet.getObject(i).toString());
//                            }
//                            ResultSet rs = stmt.getResultSet();
//                            ResultSetMetaData resultSetMetaData = rs.getMetaData();

                            resultSetData = stmt.getResultSet();
                            resultSetMetaData = resultSetData.getMetaData();

                            rsCount++;
                            List<HashMap<String, Object>> resultSetJsonArray = new ArrayList<>();
                            while (resultSetData.next()) {

                                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                                    objectMap.put(resultSetMetaData.getColumnLabel(i), resultSetData.getObject(i));

//                                    if (Objects.equals(resultSetMetaData.getColumnName(i), "Result")){
//                                    columnNames.add(resultSetMetaData.getColumnName(i));
//                                    }
                                }

                                resultSetJsonArray.add(objectMap);
//                                System.out.println("resultSetMetaData.getColumnCount() " + resultSetMetaData.getColumnCount());
                            }
//                            iterateResultSet.put(resultSetMetaData.getTableName(resultSetMetaData.getColumnCount()) + "", resultSetJsonArray);
                            resultArray.add(resultSetJsonArray);
//                            System.out.println("resultSetJsonArray.toString() " + resultSetJsonArray.toString());
                        }
                        results = stmt.getMoreResults();
                    } while (results);


                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        getKeys(objectMap);
        return resultArray;
    }

    @Override
//    List<Map<String, Object>> mixed(String queryString) {
    public List mixed(String queryString) {

//        String sqlString = _createSPQuery(clazz, storedProcedureName, tParams, hasResultErrMsgNewID);
//        Query query = entityManager.createNativeQuery(sqlString);


        Query query = entityManager.createNativeQuery(queryString);
        NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
//        NativeQueryImpl nativeQuery = (NativeQueryImpl) execSPNativeQueryTestAK(query);
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List rows = nativeQuery.getResultList();


//        List<List<HashMap<String, Object>>> resultArray = new ArrayList<>();

        List resultArray = new ArrayList<>();


        ArrayList<String> columnNames = new ArrayList<>();
        ArrayList<String> columnLabels = new ArrayList<>();
//        List<List<String, Object>> resultArray = new ArrayList<>();
        Session session = entityManager.unwrap(Session.class);
        HashMap<String, Object> objectMap = new HashMap<>();
        session.doWork(new Work() {

            @Override
            public void execute(Connection connection) throws SQLException {

                try {
                    PreparedStatement stmt = connection.prepareStatement(queryString);
                    boolean results = stmt.execute();
                    int rsCount = 0;
                    do {
                        if (results) {
                            ResultSet rs = stmt.getResultSet();
                            ResultSetMetaData resultSetMetaData = rs.getMetaData();

                            rsCount++;
                            List<HashMap<String, Object>> resultSetJsonArray = new ArrayList<>();
                            while (rs.next()) {

                                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                                    objectMap.put(resultSetMetaData.getColumnLabel(i), rs.getObject(i));

//                                    if (Objects.equals(resultSetMetaData.getColumnName(i), "Result")){
//                                    columnNames.add(resultSetMetaData.getColumnName(i));
//                                    }
                                }

                                resultSetJsonArray.add(objectMap);
//                                System.out.println("resultSetMetaData.getColumnCount() " + resultSetMetaData.getColumnCount());
                            }
//                            iterateResultSet.put(resultSetMetaData.getTableName(resultSetMetaData.getColumnCount()) + "", resultSetJsonArray);
                            resultArray.add(resultSetJsonArray);
//                            System.out.println("resultSetJsonArray.toString() " + resultSetJsonArray.toString());
                        }
                        results = stmt.getMoreResults();
                    } while (results);


                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        getKeys(objectMap);

        return rows;
//        return resultArray;


    }


    @Override
//    List<Map<String, Object>> mixed(String queryString) {
    public List mixed2(String queryString) {
//
//
//        String sqlString = _createSPQuery(clazz, storedProcedureName, tParams, hasResultErrMsgNewID);
////        Query query = entityManager.createNativeQuery(sqlString);
//        Query query = entityManager.createNativeQuery(myString2);
//        NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
////        NativeQueryImpl nativeQuery = (NativeQueryImpl) execSPNativeQueryTestAK(query);
//        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
//        List rows = nativeQuery.getResultList();
//        return rows;
//
//        Map<String, Object> row2 =rows;
////        Map<String, Object> row2 = _nativeQueryResultList(clazz, storedProcedureName, tParams, true).get(0);
//        BigDecimal result = (BigDecimal) row.get("Result");
//        String errMsg = (String) row.get("ErrMsg");
//        if (result.intValue() != 0) {
//            throw new TConflictException(result.intValue(), errMsg);
//        }
//        BigDecimal newID = (BigDecimal) row.get("NewID");
//        BigDecimal formID = (BigDecimal) row.get("FormID");
//        BigDecimal formulaValue1 = (BigDecimal) row.get("FormulaValue1");
//        BigDecimal formulaValue2 = (BigDecimal) row.get("FormulaValue2");
//        BigDecimal formulaValue3 = (BigDecimal) row.get("FormulaValue3");
//        BigDecimal formulaValue4 = (BigDecimal) row.get("FormulaValue4");
//        return new ResultErrMsgNewID(result, errMsg, newID, formID, formulaValue1, formulaValue2, formulaValue3, formulaValue4);
//
//
////        List<List<HashMap<String, Object>>> resultArray = new ArrayList<>();
//
//        List resultArray = new ArrayList<>();
//
//
//        ArrayList<String> columnNames = new ArrayList<>();
//        ArrayList<String> columnLabels = new ArrayList<>();
////        List<List<String, Object>> resultArray = new ArrayList<>();
//        Session session = entityManager.unwrap(Session.class);
//        HashMap<String, Object> objectMap = new HashMap<>();
//        session.doWork(new Work() {
//
//            @Override
//            public void execute(Connection connection) throws SQLException {
//
//                try {
//                    PreparedStatement stmt = connection.prepareStatement(myString2);
//                    boolean results = stmt.execute();
//                    int rsCount = 0;
//                    do {
//                        if (results) {
//                            ResultSet rs = stmt.getResultSet();
//                            ResultSetMetaData resultSetMetaData = rs.getMetaData();
//
//                            rsCount++;
//                            List<HashMap<String, Object>> resultSetJsonArray = new ArrayList<>();
//                            while (rs.next()) {
//
//                                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
//                                    objectMap.put(resultSetMetaData.getColumnLabel(i), rs.getObject(i));
//
////                                    if (Objects.equals(resultSetMetaData.getColumnName(i), "Result")){
////                                    columnNames.add(resultSetMetaData.getColumnName(i));
////                                    }
//                                }
//
//                                resultSetJsonArray.add(objectMap);
////                                System.out.println("resultSetMetaData.getColumnCount() " + resultSetMetaData.getColumnCount());
//                            }
////                            iterateResultSet.put(resultSetMetaData.getTableName(resultSetMetaData.getColumnCount()) + "", resultSetJsonArray);
//                            resultArray.add(resultSetJsonArray);
////                            System.out.println("resultSetJsonArray.toString() " + resultSetJsonArray.toString());
//                        }
//                        results = stmt.getMoreResults();
//                    } while (results);
//
//
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        getKeys(objectMap);

//        return rows;
        return null;
//        return resultArray;


    }


    @Override
//    List<Map<String, Object>> mixed(String queryString) {
    public List mixed3(String queryString) {

        // First Method
//        String sqlString = _createSPQuery(clazz, storedProcedureName, tParams, hasResultErrMsgNewID);
//        Query query = entityManager.createNativeQuery(sqlString);
//        NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
//        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
//        List rows = nativeQuery.getResultList();
//        return rows;


        // Second Method


        return null;
    }


    @Override
    public List<?> execSPNativeQueryTest(String query) {
        List<List<HashMap<String, Object>>> resultArray = new ArrayList<>();
        Session session = entityManager.unwrap(Session.class);
        session.doWork(new Work() {

            @Override
            public void execute(Connection connection) throws SQLException {

                try {
                    PreparedStatement stmt = connection.prepareStatement(query);
                    boolean results = stmt.execute();
                    int rsCount = 0;
                    do {
                        if (results) {
                            ResultSet rs = stmt.getResultSet();
                            ResultSetMetaData resultSetMetaData = rs.getMetaData();

                            rsCount++;
                            List<HashMap<String, Object>> resultSetJsonArray = new ArrayList<>();
                            while (rs.next()) {
                                HashMap<String, Object> objectMap = new HashMap<>();
                                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++)
                                    objectMap.put(resultSetMetaData.getColumnLabel(i), rs.getObject(i));
                                resultSetJsonArray.add(objectMap);
                            }
//                            iterateResultSet.put(resultSetMetaData.getTableName(resultSetMetaData.getColumnCount()) + "", resultSetJsonArray);
                            resultArray.add(resultSetJsonArray);
                        }
                        results = stmt.getMoreResults();
                    } while (results);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        return resultArray;
    }

    @Override
    public ResultErrMsgNewID execSPNativeQueryForVoucher(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams) {
//        Map<String, Object> row = _nativeQueryResultListForMultiResultSet(clazz, storedProcedureName, tParams, true).get(0);
//
//        final List<?> objects = execSPNativeQueryTestAK(myString2);
////        final List<?> objects = execSPNativeQueryTestAK(" SELECT *  FROM AccBank as bank SELECT BankBranchCode  ,BankBranchDesc  FROM AccBankBranch ");
//        //getKeys(objects);
//        System.out.println(objects.size());
//        for (int i = 0; i < objects.size(); i++) {
//            System.out.println(objects.get(i).toString());
//            if (objects.get(i) == "Result")
//                System.out.println("Was " + objects.get(i).toString());
////                System.out.println("objects.get(0).toString()" + objects.get(i).toString());
//            else {
//                System.out.println("Wasn't first " + Arrays.toString(objects.get(i).getClass().getFields()));
//                System.out.println("Wasn't second " + objects.get(i).getClass().getName().toString());
//                System.out.println("Wasn't third " + objects.get(i).getClass().getDeclaredFields().toString());
//            }
//        }
//
//
//        BigDecimal result = (BigDecimal) row.get("Result");
//        String errMsg = (String) row.get("ErrMsg");
//        if (result.intValue() != 0) {
//            throw new TConflictException(result.intValue(), errMsg);
//        }
//        BigDecimal newID = (BigDecimal) row.get("NewID");
//        BigDecimal formID = (BigDecimal) row.get("FormID");
//        BigDecimal formulaValue1 = (BigDecimal) row.get("FormulaValue1");
//        BigDecimal formulaValue2 = (BigDecimal) row.get("FormulaValue2");
//        BigDecimal formulaValue3 = (BigDecimal) row.get("FormulaValue3");
//        BigDecimal formulaValue4 = (BigDecimal) row.get("FormulaValue4");
//        return new ResultErrMsgNewID(result, errMsg, newID, formID, formulaValue1, formulaValue2, formulaValue3, formulaValue4);
        return null;
    }

    private void getKeys(HashMap<String, Object> resultSetJsonArray) {
        for (String key : resultSetJsonArray.keySet()) {
//            System.out.println("key was " + key.toString());
        }
    }

    private static Set<String> getKeysUsingValue(Map<String, Integer> map, Integer value) {

        Set<String> result = new HashSet<>();
        if (map.containsValue(value)) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (Objects.equals(entry.getValue(), value)) {
                    result.add(entry.getKey());
                }
                // we can't compare like this, null will throws exception
              /*(if (entry.getValue().equals(value)) {
                  result.add(entry.getKey());
              }*/
            }
        }
        return result;

    }

    @Override
    public ResultErrMsgNewID execSPNativeQuery(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams) {
        Map<String, Object> row = _nativeQueryResultList(clazz, storedProcedureName, tParams, true).get(0);
        BigDecimal result = (BigDecimal) row.get("Result");
        String errMsg = (String) row.get("ErrMsg");
        if (result.intValue() != 0) {
            throw new TConflictException(result.intValue(), errMsg);
        }
        BigDecimal newID = (BigDecimal) row.get("NewID");
        BigDecimal formID = (BigDecimal) row.get("FormID");
        BigDecimal formulaValue1 = (BigDecimal) row.get("FormulaValue1");
        BigDecimal formulaValue2 = (BigDecimal) row.get("FormulaValue2");
        BigDecimal formulaValue3 = (BigDecimal) row.get("FormulaValue3");
        BigDecimal formulaValue4 = (BigDecimal) row.get("FormulaValue4");
        return new ResultErrMsgNewID(result, errMsg, newID, formID, formulaValue1, formulaValue2, formulaValue3, formulaValue4);
    }


    @Override
    public ResultErrMsgNewID execSPNativeQueryTSerial(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams) {
        Map<String, Object> row = _nativeQueryResultListTserial(clazz, storedProcedureName, tParams, true).get(0);
        BigDecimal result = (BigDecimal) row.get("Result");
        String errMsg = (String) row.get("ErrMsg");
        if (result.intValue() != 0) {
            throw new TConflictException(result.intValue(), errMsg);
        }
        BigDecimal newID = (BigDecimal) row.get("NewID");
        BigDecimal formID = (BigDecimal) row.get("FormID");
        BigDecimal formulaValue1 = (BigDecimal) row.get("FormulaValue1");
        BigDecimal formulaValue2 = (BigDecimal) row.get("FormulaValue2");
        BigDecimal formulaValue3 = (BigDecimal) row.get("FormulaValue3");
        BigDecimal formulaValue4 = (BigDecimal) row.get("FormulaValue4");
        return new ResultErrMsgNewID(result, errMsg, newID, formID, formulaValue1, formulaValue2, formulaValue3, formulaValue4);
    }

    @Override
    public List execSPNativeQuery(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams, ShowSPReturnType showSPReturnType) {
        List<Map<String, Object>> rows = _nativeQueryResultList(clazz, storedProcedureName, tParams, false);
        if (rows.isEmpty()) {
            throw new TNoContentException();
        }
        switch (showSPReturnType) {
            case MAP:
                return rows;
            case NATIVE:
                List<T> list = new ArrayList<>();
                Field[] fields = clazz.getDeclaredFields();
                Method[] methods = clazz.getDeclaredMethods();
                for (Map<String, Object> row : rows) {
                    T t = null;
                    try {
                        t = clazz.newInstance();
                        List<String> keys = new ArrayList(row.keySet());
                        for (String key : keys) {
                            for (Field field : fields) {
                                if (key.toLowerCase().equals(field.getName().toLowerCase())) {
                                    // find method
                                    for (Method method : methods) {
                                        if (method.getName().toLowerCase().equals("set" + field.getName().toLowerCase())) {
                                            method.invoke(t, row.get(key));
                                        }
                                    }
                                }
                            }
                        }
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    list.add(t);
                }
                return list;
        }
        return null;
    }

//    template

//    @Override
//    public BigDecimal insSP3(String storedProcedureName, List<TParameter<?>> tParameters) {
//        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery(storedProcedureName);
//        for (TParameter tparameter : tParameters) {
//            storedProcedureQuery.setParameter(tparameter.getName(), tparameter.getValue());
//        }
//        storedProcedureQuery.execute();
//        BigDecimal result = (BigDecimal) storedProcedureQuery.getOutputParameterValue("Result");
//        if (result.intValue() != 0) {
//            throw new TConflictException(result.intValue(), (String) storedProcedureQuery.getOutputParameterValue("ErrMsg"));
//        }
//        try {
//            storedProcedureQuery.getOutputParameterValue("NewID");
//            return (BigDecimal) storedProcedureQuery.getOutputParameterValue("NewID");
//        } catch (Exception e) {
//            return new BigDecimal(-1);
//        }
//    }

    @Override
    public ArrayList<BigDecimal> execSPNativeQueryAk(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams) {
//        return null;
//        List<> IDs = new ArrayList();
//        _initiateDynamicClass()
//
        ArrayList<BigDecimal> info = new ArrayList<>();

        Map<String, Object> row = _nativeQueryResultList(clazz, storedProcedureName, tParams, true).get(0);
        BigDecimal result = (BigDecimal) row.get("Result");
        String errMsg = (String) row.get("ErrMsg");
        if (result.intValue() != 0) {
            throw new TConflictException(result.intValue(), errMsg);
        }
        try {
            BigDecimal newID = (BigDecimal) row.get("NewID");
            BigDecimal formID = (BigDecimal) row.get("FormID");
            info.add(newID);
            info.add(formID);
            return info;
        } catch (Exception exception) {
            info.add(BigDecimal.valueOf(-1));
            return info;
        }
//        BigDecimal newID = (BigDecimal) row.get("NewID");
//        BigDecimal formID = (BigDecimal) row.get("FormID");
//        BigDecimal formulaValue1 = (BigDecimal) row.get("FormulaValue1");
//        BigDecimal formulaValue2 = (BigDecimal) row.get("FormulaValue2");
//        BigDecimal formulaValue3 = (BigDecimal) row.get("FormulaValue3");
//        BigDecimal formulaValue4 = (BigDecimal) row.get("FormulaValue4");
//        return new ResultErrMsgNewID(result, errMsg, newID, formID, formulaValue1, formulaValue2, formulaValue3, formulaValue4);

    }


    @Override
    public ArrayList<BigDecimal> execSPNativeQueryAk2(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams) {
//        return null;
//        List<> IDs = new ArrayList();
//        _initiateDynamicClass()
//
        ArrayList<BigDecimal> info = new ArrayList<>();

        Map<String, Object> row = _nativeQueryResultList2(clazz, storedProcedureName, tParams, true).get(0);
        BigDecimal result = (BigDecimal) row.get("Result");
        String errMsg = (String) row.get("ErrMsg");
        if (result.intValue() != 0) {
            throw new TConflictException(result.intValue(), errMsg);
        }
        try {
            BigDecimal newID = (BigDecimal) row.get("NewID");
            BigDecimal formID = (BigDecimal) row.get("FormID");
            info.add(newID);
            info.add(formID);
            return info;
        } catch (Exception exception) {
            info.add(BigDecimal.valueOf(-1));
            return info;
        }
//        BigDecimal newID = (BigDecimal) row.get("NewID");
//        BigDecimal formID = (BigDecimal) row.get("FormID");
//        BigDecimal formulaValue1 = (BigDecimal) row.get("FormulaValue1");
//        BigDecimal formulaValue2 = (BigDecimal) row.get("FormulaValue2");
//        BigDecimal formulaValue3 = (BigDecimal) row.get("FormulaValue3");
//        BigDecimal formulaValue4 = (BigDecimal) row.get("FormulaValue4");
//        return new ResultErrMsgNewID(result, errMsg, newID, formID, formulaValue1, formulaValue2, formulaValue3, formulaValue4);

    }

    @Override
    public ResultErrMsgNewID execSPNativeQueryMultiResultSet(Class<T> clazz, String storedProcedureName, List<TParameter<?>> tParams) {
//        Map<String, Object> row = _nativeQueryResultList(clazz, storedProcedureName, tParams, true).get(0);
//        final Map<String, Object> stringObjectMap = _nativeQueryResultListForMultiResultSet(clazz, storedProcedureName, tParams, true).get(0);
        String sqlString = _createSPQuery(clazz, storedProcedureName, tParams, true);
//        String bankQuery = "SELECT *  FROM AccBank as bank SELECT BankBranchCode  ,BankBranchDesc  FROM AccBankBranch";
        final List<?> objects = execSPNativeQueryTestAK(sqlString);
//        final List<?> objects = execSPNativeQueryTestAK(mine);
//        final List<?> objects = execSPNativeQueryTestAK(myString1);
//        final List<?> objects = execSPNativeQueryTestAK(myString2);
//        final List<?> objects = execSPNativeQueryTestAK(bankQuery);

        List<List<HashMap<String, Object>>> resultArray = new ArrayList<>();

//        Map<String, Object> row = execSPNativeQueryTestAK(clazz, storedProcedureName, tParams, true).get(0);
//        final List mixed3 = mixed3("clazz, storedProcedureName, tParams, true");
        BigDecimal result = BigDecimal.valueOf(-11111111);
        String errMsg = "Hardcode from server";

        BigDecimal newID = null;
        BigDecimal formID = null;
        BigDecimal formulaValue1 = null;
        BigDecimal formulaValue2 = null;
        BigDecimal formulaValue3 = null;
        BigDecimal formulaValue4 = null;

//        Map<String, Object> row = null;
        for (int i = 0; i < objects.size(); i++) {
// sout
//
//            System.out.println("declared fields are " + objects.get(i).getClass().getName().toString());
//            System.out.println("declared fields are " + Arrays.toString(objects.get(i).getClass().getFields()));
//            System.out.println("declared fields are " + Arrays.toString(objects.get(i).getClass().));
//            System.out.println("Object number " + i + " is " + objects.get(i).toString());
//            final Object o = objects.get(i);
            try {
                result = (BigDecimal) ((HashMap) ((ArrayList) objects.get(i)).get(0)).get("Result");
                errMsg = (String) ((HashMap) ((ArrayList) objects.get(i)).get(0)).get("ErrMsg");

                newID = (BigDecimal) ((HashMap) ((ArrayList) objects.get(i)).get(0)).get("NewID");
                formID = (BigDecimal) ((HashMap) ((ArrayList) objects.get(i)).get(0)).get("FormID");
                formulaValue1 = (BigDecimal) ((HashMap) ((ArrayList) objects.get(i)).get(0)).get("FormulaValue1");
                formulaValue2 = (BigDecimal) ((HashMap) ((ArrayList) objects.get(i)).get(0)).get("FormulaValue2");
                formulaValue3 = (BigDecimal) ((HashMap) ((ArrayList) objects.get(i)).get(0)).get("FormulaValue3");
                formulaValue4 = (BigDecimal) ((HashMap) ((ArrayList) objects.get(i)).get(0)).get("FormulaValue4");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

//        BigDecimal result = (BigDecimal) row.get("Result");
//        String errMsg = (String) row.get("ErrMsg");
        if (result.intValue() != 0) {
            throw new TConflictException(result.intValue(), errMsg);
        }
//        BigDecimal newID = (BigDecimal) row.get("NewID");
//        BigDecimal formID = (BigDecimal) row.get("FormID");
//        BigDecimal formulaValue1 = (BigDecimal) row.get("FormulaValue1");
//        BigDecimal formulaValue2 = (BigDecimal) row.get("FormulaValue2");
//        BigDecimal formulaValue3 = (BigDecimal) row.get("FormulaValue3");
//        BigDecimal formulaValue4 = (BigDecimal) row.get("FormulaValue4");
        return new ResultErrMsgNewID(result, errMsg, newID, formID, formulaValue1, formulaValue2, formulaValue3, formulaValue4);
    }


    @Override
    @Transactional
    public T updSPI(T t, BigDecimal pkValue) {
        if (entityManager.find(t.getClass(), pkValue) == null) {
            throw new TNotFoundException();
        }
        return entityManager.merge(t);
    }

    @Override
    public List<T> showSP(String storedProcedureName, List<TParameter<?>> tParameters, boolean throwIfNoCOntent) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery(storedProcedureName);
        for (TParameter<?> tParameter : tParameters) {
            storedProcedureQuery.setParameter(tParameter.getName(), tParameter.getValue());
        }
        try {
            List list = storedProcedureQuery.getResultList();
            if (throwIfNoCOntent && list.isEmpty()) {
                throw new TNoContentException();
            }
            return list;
        } catch (SQLGrammarException sqlGrammarException) {
            throw new TSqlException(sqlGrammarException.getMessage());
        } catch (PersistenceException persistenceException) {
            if (persistenceException.getCause() instanceof SQLGrammarException) {
                SQLGrammarException sqlGrammarException = (SQLGrammarException) persistenceException.getCause();
                if (sqlGrammarException.getCause() instanceof SQLServerException) {
                    SQLServerException sqlServerException = (SQLServerException) sqlGrammarException.getCause();
                    throw new TSqlException(sqlServerException.getMessage());
                } else {
                    throw new TSqlException(sqlGrammarException.getMessage());
                }
            } else if (persistenceException.getCause() instanceof GenericJDBCException) {
                GenericJDBCException genericJDBCException = (GenericJDBCException) persistenceException.getCause();
                if (genericJDBCException.getCause() instanceof SQLServerException) {
                    SQLServerException sqlServerException = (SQLServerException) genericJDBCException.getCause();
                    throw new TSqlException(sqlServerException.getMessage());
                } else {
                    throw new TSqlException(genericJDBCException.getMessage());
                }
            } else {
                throw new TSqlException(persistenceException.getMessage());
            }
        } catch (IllegalStateException illegalStateException) {
            throw new TSqlException(illegalStateException.getMessage());
        }
    }

    @Override
    public List<T> showFinalSP(String storedProcedureName, List<TParameter<?>> tParameters, boolean throwIfNoCOntent) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery(storedProcedureName);
        System.out.println("Testing Next Line " +
                entityManager.createNamedStoredProcedureQuery(storedProcedureName));
        entityManager.createNamedStoredProcedureQuery(storedProcedureName);
        System.out.println(entityManager.createNamedStoredProcedureQuery(storedProcedureName));

        System.out.println(entityManager.createNativeQuery(storedProcedureName));
        entityManager.createNativeQuery(storedProcedureName);


        System.out.println(entityManager.createQuery(storedProcedureName));
        entityManager.createQuery(storedProcedureName);

        for (TParameter<?> tParameter : tParameters) {
            storedProcedureQuery.setParameter(tParameter.getName(), tParameter.getValue());
        }
        try {
            List list = storedProcedureQuery.getResultList();
            storedProcedureQuery.getResultList();
//            storedProcedureQuery.getOutputParameterValue();
            storedProcedureQuery.getUpdateCount();
//            storedProcedureQuery.getSingleResult();
            storedProcedureQuery.getFirstResult();
            storedProcedureQuery.getFlushMode();
            storedProcedureQuery.getHints();
//            storedProcedureQuery.getLockMode();
            storedProcedureQuery.getMaxResults();
            storedProcedureQuery.getParameters();
            storedProcedureQuery.getResultStream();
//            storedProcedureQuery.getParameterValue();
//            storedProcedureQuery.getOutputParameterValue();
//            storedProcedureQuery.getClass().;
//            storedProcedureQuery.getResultStream();
//            storedProcedureQuery.getResultStream();
            if (throwIfNoCOntent && list.isEmpty()) {
                throw new TNoContentException();
            }
            return list;
        } catch (SQLGrammarException sqlGrammarException) {
            throw new TSqlException(sqlGrammarException.getMessage());
        } catch (PersistenceException persistenceException) {
            if (persistenceException.getCause() instanceof SQLGrammarException) {
                SQLGrammarException sqlGrammarException = (SQLGrammarException) persistenceException.getCause();
                if (sqlGrammarException.getCause() instanceof SQLServerException) {
                    SQLServerException sqlServerException = (SQLServerException) sqlGrammarException.getCause();
                    throw new TSqlException(sqlServerException.getMessage());
                } else {
                    throw new TSqlException(sqlGrammarException.getMessage());
                }
            } else if (persistenceException.getCause() instanceof GenericJDBCException) {
                GenericJDBCException genericJDBCException = (GenericJDBCException) persistenceException.getCause();
                if (genericJDBCException.getCause() instanceof SQLServerException) {
                    SQLServerException sqlServerException = (SQLServerException) genericJDBCException.getCause();
                    throw new TSqlException(sqlServerException.getMessage());
                } else {
                    throw new TSqlException(genericJDBCException.getMessage());
                }
            } else {
                throw new TSqlException(persistenceException.getMessage());
            }
        } catch (IllegalStateException illegalStateException) {
            throw new TSqlException(illegalStateException.getMessage());
        }
    }


//    public StoredProcedureQuery createNamedStoredProcedureQuery(String name) {
//        this.checkOpen();
//
//        try {
//            ProcedureCallMemento memento = this.getFactory().getNamedQueryRepository().getNamedProcedureCallMemento(name);
//            if (memento == null) {
//                throw new IllegalArgumentException("No @NamedStoredProcedureQuery was found with that name : " + name);
//            } else {
//                return memento.makeProcedureCall(this);
//            }
//        } catch (RuntimeException var3) {
//            throw this.getExceptionConverter().convert(var3);
//        }
//    }
//    private transient SessionFactoryImpl factory;
//
//
//    default void checkOpen() {
//        this.checkOpen(true);
//    }
//
//    public SessionFactoryImplementor getFactory() {
//        return this.factory;
//    }


    @Override
    public T insSP(String storedProcedureName, List<TParameter<?>> tParameters, Class<T> clazz) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery(storedProcedureName);
        for (TParameter tparameter : tParameters) {
            storedProcedureQuery.setParameter(tparameter.getName(), tparameter.getValue());
        }
        storedProcedureQuery.execute();
        BigDecimal result = (BigDecimal) storedProcedureQuery.getOutputParameterValue("Result");
        if (result.intValue() != 0) {
            throw new TConflictException(result.intValue(), (String) storedProcedureQuery.getOutputParameterValue("ErrMsg"));
        }
        return storedProcedureQuery.getOutputParameterValue("NewID") == null ? (T) entityManager.find(clazz, null) : (T) entityManager.find(clazz, storedProcedureQuery.getOutputParameterValue("NewID"));
    }

    @Override
    public BigDecimal insSP(String storedProcedureName, List<TParameter<?>> tParameters) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery(storedProcedureName);
        for (TParameter tparameter : tParameters) {
            storedProcedureQuery.setParameter(tparameter.getName(), tparameter.getValue());
        }
        storedProcedureQuery.execute();
        BigDecimal result = (BigDecimal) storedProcedureQuery.getOutputParameterValue("Result");
        if (result.intValue() != 0) {
            throw new TConflictException(result.intValue(), (String) storedProcedureQuery.getOutputParameterValue("ErrMsg"));
        }
        try {
            storedProcedureQuery.getOutputParameterValue("NewID");
            return (BigDecimal) storedProcedureQuery.getOutputParameterValue("NewID");
        } catch (Exception e) {
            return new BigDecimal(-1);
        }
    }

    @Override
    public void delSP(String storedProcedureName, List<TParameter<?>> tParameters) {
//        if (entityManager.find(clazz, pkValue) == null) {
//            throw new TNotFoundException();
//        }
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery(storedProcedureName);
        for (TParameter tparameter : tParameters) {
            storedProcedureQuery.setParameter(tparameter.getName(), tparameter.getValue());
        }
        storedProcedureQuery.execute();
        // TODO: 6/23/22 here
        BigDecimal result = null;
        String errMsg = "";
        if (((ProcedureCallImpl<?>) storedProcedureQuery).getOutputs().getCurrent().isResultSet()) {
            List<Object> list = null;
            if (storedProcedureQuery.getResultList().get(0).getClass().isArray()) {
                list = Arrays.asList((Object[]) (storedProcedureQuery.getResultList().get(0)));
                result = (BigDecimal) list.get(0);
                errMsg = String.valueOf(list.get(1));
            }
        } else {
            result = (BigDecimal) storedProcedureQuery.getOutputParameterValue("Result");
            errMsg = String.valueOf(storedProcedureQuery.getOutputParameterValue("ErrMsg"));
        }

        if (result.intValue() != 0) {
            throw new TConflictException(result.intValue(), errMsg);
        }
    }


    @Override
    public void delSPNew(String storedProcedureName, List<TParameter<?>> tParameters) {
//        if (entityManager.find(clazz, pkValue) == null) {
//            throw new TNotFoundException();
//        }
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery(storedProcedureName);
        for (TParameter tparameter : tParameters) {
            storedProcedureQuery.setParameter(tparameter.getName(), tparameter.getValue());
        }
        storedProcedureQuery.execute();

        BigDecimal result = null;
        String errMsg = "";

        try {
            if (storedProcedureQuery.getResultList().get(0).getClass().isArray()) System.out.println("IF IS TRUE");

            if (((ProcedureCallImpl<?>) storedProcedureQuery).getOutputs().getCurrent().isResultSet()) {
                List<Object> list = null;
                if (storedProcedureQuery.getResultList().get(0).getClass().isArray()) {
                    list = Arrays.asList((Object[]) (storedProcedureQuery.getResultList().get(0)));
                    result = (BigDecimal) list.get(0);
                    errMsg = String.valueOf(list.get(1));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        result = (BigDecimal) storedProcedureQuery.getOutputParameterValue("Result");
        errMsg = (String) storedProcedureQuery.getOutputParameterValue("ErrMsg");

        if (result.intValue() != 0) {
            throw new TConflictException(result.intValue(), errMsg);
        }
    }


    @Override
    @Transactional
    public T updSP(String storedProcedureName, List<TParameter<?>> tParameters, Class<T> clazz, BigDecimal pkValue) {
        if (entityManager.find(clazz, pkValue) == null) {
            throw new TNotFoundException();
        }
        entityManager.clear();
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery(storedProcedureName);
        for (TParameter tparameter : tParameters) {
            storedProcedureQuery.setParameter(tparameter.getName(), tparameter.getValue());
        }
        storedProcedureQuery.execute();
        BigDecimal result = (BigDecimal) storedProcedureQuery.getOutputParameterValue("Result");
        if (result.intValue() != 0) {
            throw new TConflictException(result.intValue(), (String) storedProcedureQuery.getOutputParameterValue("ErrMsg"));
        }
        return (T) entityManager.find(clazz, pkValue);
    }

    @Override
    @Transactional
    public void updSP(String storedProcedureName, List<TParameter<?>> tParameters) {
        entityManager.clear();
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery(storedProcedureName);
        for (TParameter tparameter : tParameters) {
            storedProcedureQuery.setParameter(tparameter.getName(), tparameter.getValue());
        }
        storedProcedureQuery.execute();
        BigDecimal result = (BigDecimal) storedProcedureQuery.getOutputParameterValue("Result");
        if (result.intValue() != 0) {
            throw new TConflictException(result.intValue(), (String) storedProcedureQuery.getOutputParameterValue("ErrMsg"));
        }
    }

    @Override
    @Transactional
    public void noPKUpdSP(String storedProcedureName, List<TParameter<?>> tParameters) {
        entityManager.clear();
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery(storedProcedureName);
        for (TParameter tparameter : tParameters) {
            storedProcedureQuery.setParameter(tparameter.getName(), tparameter.getValue());
        }
        storedProcedureQuery.execute();
        BigDecimal result = (BigDecimal) storedProcedureQuery.getOutputParameterValue("Result");
        if (result.intValue() != 0) {
            throw new TConflictException(result.intValue(), (String) storedProcedureQuery.getOutputParameterValue("ErrMsg"));
        }
    }

    @Override
    public List<T> findAllByNamedQuery(String namedQuery) {
        Query query = entityManager.createNamedQuery(namedQuery);
        List<T> list = query.getResultList();
        return list;
    }


    @Override
    public String base64Encoder(Meta meta) {
        String metaEncoded = "";
        try {
            metaEncoded = Base64.getEncoder().encodeToString(meta.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return metaEncoded;
    }

    //+++++++++++++++++++++++++++++++ Static Dir ++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public InputStreamResource staticFileToStreamResource(String filePath) {
        InputStreamResource inputStreamResource = null;
        try {
            File file = ResourceUtils.getFile("classpath:static/" + filePath);
            inputStreamResource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            return inputStreamResource;
        }
    }

    //+++++++++++++++++++++++++++++++ Crystal Report ++++++++++++++++++++++++++++++++++++++++
    private ReportClientDocument _reportClientDocument(String rptFileName) {
        //Create ReportClientDocument from rpt file
        ReportClientDocument reportClientDoc = new ReportClientDocument();
        try {
            File rptFile = ResourceUtils.getFile("classpath:static/reports/" + rptFileName + ".rpt");
            reportClientDoc.open(rptFile.getAbsolutePath(), 0);
            return reportClientDoc;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new TCrystalReportFileNotFoundException(e.getMessage());
        } catch (ReportSDKException e) {
            e.printStackTrace();
            return null;
        }
    }

    private InputStream _exportCrystalReportToPDFStream(ReportClientDocument reportClientDocument) {
        //Export Crystal Report to PDF Stream
        InputStream inputStream = null;
        try {
            inputStream = reportClientDocument.getPrintOutputController().export(ReportExportFormat.PDF);
        } catch (ReportSDKException e) {
            e.printStackTrace();
        } finally {
            return inputStream;
        }
    }

    private void _exportPDFStreamToPDFFile(InputStream inputStream) {
        //Export PDF Stream to PDF File
        try {
            File pdfFile = File.createTempFile("rptFileName", ".pdf");
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            OutputStream outStream = new FileOutputStream(pdfFile);
            outStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InputStreamResource exportCrystalReportToPDF(Class<T> clazz, String rptFileName, HashMap<String, Object> parameterFields, List<TParameter<?>> tParameters, ShowSPReturnType showSPReturnType) {
        ReportClientDocument reportClientDocument = _reportClientDocument(rptFileName);
        //گرفتن نام اس پی از فایل آر پی تی
        String storedProcedureNameInRptFile = null;
        try {
            storedProcedureNameInRptFile = reportClientDocument.getDatabaseController().getDatabase().getTables().getTable(0).getName();
        } catch (ReportSDKException e) {
            e.printStackTrace();
        }

        //نام اس پی در فایل کریستال یک نقطه ویرگول بیشتر دارد
        String storedProcedureName = storedProcedureNameInRptFile.split(";")[0];

        // ست کردن دیتا سورس به ریپورت
        try {
            switch (showSPReturnType) {
                case NATIVE:
                    List<T> list = execSPNativeQuery(clazz, storedProcedureName, tParameters, ShowSPReturnType.NATIVE);
                    reportClientDocument.getDatabaseController().setDataSource(list, clazz, storedProcedureNameInRptFile, storedProcedureNameInRptFile);
                    break;

                default://MAP
                    List<Map<String, Object>> rows = execSPNativeQuery(clazz, storedProcedureName, tParameters, ShowSPReturnType.MAP);
                    Class<?> _class = _createDynamicClass(clazz, rows.get(0));
                    ArrayList list1 = new ArrayList();
                    for (Map<String, Object> row : rows) {
                        Object instance = _initiateDynamicClass(row, _class);
                        list1.add(instance);
                    }
                    reportClientDocument.getDatabaseController().setDataSource(list1, _class, storedProcedureNameInRptFile, storedProcedureNameInRptFile);
                    break;

            }
        } catch (ReportSDKException e) {
            throw new TCrystalReportDataSourceException(e.getMessage());
        }

        try {
            // ست کردن پارامتر های ریپورت
            ParameterFieldController parameterFieldController = reportClientDocument.getDataDefController().getParameterFieldController();
            for (Map.Entry<String, Object> parameterField : parameterFields.entrySet()) {
                parameterFieldController.setCurrentValue("", parameterField.getKey(), parameterField.getValue());
            }
        } catch (ReportSDKException | RuntimeException e) {
            e.printStackTrace();
            throw new TCrystalReportFieldNotFoundException(e.getMessage());
        }

        InputStreamResource inputStreamResource = new InputStreamResource(_exportCrystalReportToPDFStream(reportClientDocument));

        //بستن کانکشن ها
        try {
            reportClientDocument.close();
        } catch (ReportSDKException e) {
            e.printStackTrace();
        } finally {
            return inputStreamResource;
        }
    }

    private @NotNull Set<String> _mapKeySet(@NotNull List<Map<String, Object>> rows) {
        // این متد کلید های مپ را از رکورد های دیتابیس واکشی مبکند
        final Map<String, Object> row = rows.get(0);
        return row.keySet();
    }

    private Class<?> _createDynamicClass(Class<T> clazz, Map<String, Object> row) {
        // این متد یک کلاس بین داینامیک با توجه به کلید ها میسازد . هر کلید یک پراپرتی میشود
        // اگر کلیذ شامل کاراکتر پرانتز باز باشد خطا رخ میدهد
        // بخاطر همین کاراکتر ) را از کلید ها پاک میکنیم
        final BeanGenerator beanGenerator = new BeanGenerator();
        final Map<String, Class<?>> properties = new HashMap<>();
        for (Map.Entry<String, Object> entry : row.entrySet()) {
            String propertyName = entry.getKey();
            propertyName = propertyName.replaceAll("\\(", "");
            Object propertyValue = entry.getValue();
            if (propertyValue == null) {
                // وقتی مقدار نال است نمیتوانیم به ماهیت این فیلد پی ببریم
                // در خط زیر ابتدا تایپ را آبجکت قرار میدهیم
                properties.put(propertyName, Object.class);
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    // در این حالت باید داخل خود کلاس مدل دنبال این فیلد بگردیم که اگر این فیلد آنجا تعریف شده بود
                    // بتوانیم نوعش را بدرستی تشخیص دهیم
                    if (field.getName().toLowerCase().equals(propertyName.toLowerCase())) {
                        properties.put(propertyName, field.getType());
                        break;
                    }
                }
            } else {
                if (propertyValue.getClass() == byte[].class) {
                    // اگر فیلدی از نوع []byte باشد ( مثلا عکس ) باید در کلاس داینامیک blob تعریف شود
                    // وگرنه در گزارش کریستال نمایش داده نمیشود
                    properties.put(propertyName, Blob.class);
                } else {
                    properties.put(propertyName, propertyValue.getClass());
                }
            }
        }
        BeanGenerator.addProperties(beanGenerator, properties);
        Class clazz1 = (Class<?>) beanGenerator.createClass();
        return clazz1;
    }

    private Object _initiateDynamicClass(Map<String, Object> row, Class clazz) {
        Object instance = null;
        try {
            instance = clazz.newInstance();
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                String propertyName = entry.getKey();
                propertyName = propertyName.replaceAll("\\(", "");
                Object propertyValue = entry.getValue();
                if (propertyValue != null) {
                    if (propertyValue.getClass() == byte[].class) {
                        // اگر فیلدی از نوع []byte باشد ( مثلا عکس ) باید مقدارش به blob کست شود
                        // وگرنه در گزارش کریستال نمایش داده نمیشود
                        Method setterMethod = clazz.getMethod("set" + propertyName, Blob.class);
                        Blob blob = new SerialBlob((byte[]) propertyValue);
                        setterMethod.invoke(instance, blob);
                    } else {
                        Method setterMethod = clazz.getMethod("set" + propertyName, propertyValue.getClass());
                        setterMethod.invoke(instance, propertyValue);
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SerialException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return instance;
    }

    @Override
    public InputStreamResource exportToExcel(List rows, List<Col> cols, String sheetName) {
        Gson gson = new Gson();
        JsonArray records = JsonParser.parseString(gson.toJson(rows)).getAsJsonArray();
        TExcel tExcel = new TExcel(records, cols, sheetName);
        return tExcel.build();
    }

    @Override
    public T setParams(Class<T> clazz, Map<String, String> params) {
        T t;
        try {
            t = clazz.newInstance();
            // این متد برای بدست آوردن تعداد کل رکورد ها کاربرد دارد
            if (params.get("srIDs") != null) {
                String[] srIDs = params.get("srIDs").split(",");
                t.setSrIDs(srIDs);
            }
            if (params.get("yrIDs") != null) {
                String[] yrIDs = params.get("yrIDs").split(",");
                t.setYrIDs(yrIDs);
            }
            if (params.get("filter") != null) {
                t.setFilter(params.get("filter"));
            }
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
