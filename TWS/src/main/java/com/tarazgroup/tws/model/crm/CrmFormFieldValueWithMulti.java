package com.tarazgroup.tws.model.crm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.UUID;

/**
 * 9/26/22
 *
 * @author Erfan Akhavan
 */


@Entity
public class CrmFormFieldValueWithMulti {

    @Id
    private UUID _id = UUID.randomUUID();

    @OneToOne
    private FormFieldValueHeader header;

    @OneToMany
    private List<CrmFormFieldValueTypeAk> details;

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public FormFieldValueHeader getHeader() {
        return header;
    }

    public void setHeader(FormFieldValueHeader header) {
        this.header = header;
    }

    public List<CrmFormFieldValueTypeAk> getDetails() {
        return details;
    }

    public void setDetails(List<CrmFormFieldValueTypeAk> details) {
        this.details = details;
    }


}


//    @OneToOne
//    private FormFieldValueHeader formFieldValueHeader;

//    @OneToMany
//    private List<CrmFormFieldValueType> crmFormFieldValueTypeListDetails;


//    @OneToMany
//    private List<CrmFormFieldValueTypeAk> crmFormFieldValueTypeAkList;



//    @StoredProcedureParameter(name = "RecordID", type = BigDecimal.class, mode = ParameterMode.IN),
//    @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
//    @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//    @StoredProcedureParameter(name = "ErrMsg", type = BigDecimal.class, mode = ParameterMode.OUT),
//    @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//    @StoredProcedureParameter(name = "TValue", type = CrmFormFieldValueType.class, mode = ParameterMode.IN),


