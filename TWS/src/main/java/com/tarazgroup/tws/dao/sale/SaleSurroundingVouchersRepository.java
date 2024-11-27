package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.sale.SaleSurroundingVouchersDto;
import com.tarazgroup.tws.model.sale.SaleVoucherHeader;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 2/20/23
 *
 * @author Erfan Akhavan
 */
public interface SaleSurroundingVouchersRepository extends TCrudRepository<SaleSurroundingVouchersDto>, CrudRepository<SaleSurroundingVouchersDto, BigDecimal> {


    default SaleSurroundingVouchersDto saleShowSurroundingVoucherHeadersByID(BigDecimal voucherHeaderIDdddd, BigDecimal[] serverIds, BigDecimal[] yearIds, SaleVoucherHeader saleVoucherHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        String serverIdsStr = "";
        String yearIdsStr = "";
        for (BigDecimal serverId : serverIds) {
            serverIdsStr += serverId.toString() + ",";
        }
        serverIdsStr = serverIdsStr.substring(0, serverIdsStr.length() - 1);
        for (BigDecimal yearId : yearIds) {
            yearIdsStr += yearId.toString() + ",";
        }
        yearIdsStr = yearIdsStr.substring(0, yearIdsStr.length() - 1);
        String serverFilter = " AND main.ServerID IN (" + serverIdsStr + ") AND (main.ServerID IN (Select ServerID from dbo.PubUsersAccessServer Where UserID = 10000000) OR (1 = 1))";
        String yearFilter = " AND main.YearID IN (" + yearIdsStr + ")";
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderIDdddd));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", serverFilter));
        tParameters.add(new TParameter<>("YearFilter", yearFilter));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ShowRemain", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("RefTypeID", null));
        tParameters.add(new TParameter<>("PageFilter", saleVoucherHeader._pageFilter()));

//        for (int i = 0; i < saleShowVoucherHeader.size(); i++) {
//            saleShowVoucherHeader.get(i);
//        }

//        final SaleSurroundingVouchersDto saleSurroundingVouchersDto = pureCode(voucherHeaderID);
//        return showSP("SaleShowSurroundingHeaderIDs", tParameters, true).get(0);
//         showFinalSP("SaleShowSurroundingHeaderIDs", tParameters, true).get(0);
        return showSP("SaleShowSurroundingHeaderIDs", tParameters, true).get(0);
    }

//    default SaleSurroundingVouchersDto pureCode(BigDecimal voucherHeaderID) {
//        String url, user, password, sql, selectAllQuery;
//        url = "jdbc:sqlserver://172.16.200.10;databaseName=Alpha;instanceName=S2019" + ";encrypt=true;trustServerCertificate=true";
//        user = "taraz";
//        password = "ResidentEvil6";
//        SaleSurroundingVouchersDto saleSurroundingVouchersDto = new SaleSurroundingVouchersDto();
//        try {
//            Connection connection = DriverManager.getConnection(url
//                    , user, password);
////            System.out.println("Connected");
//
//            selectAllQuery = "DECLARE @VoucherHeaderIDDynamic Decimal(18,0)\n" +
//                    "SET @VoucherHeaderIDDynamic = 10072510\n" +
//                    "\n" +
//                    "SELECT TOP (1) @VoucherHeaderIDDynamic AS CurrentVoucher, a.NextVoucher, a.PreviousVoucher \n" +
//                    "FROM SaleVoucherHeader D \n" +
//                    "CROSS APPLY \n" +
//                    "   ( \n" +
//                    "SELECT VoucherHeaderID,   \n" +
//                    "        Lag(VoucherHeaderID, 1) OVER(  \n" +
//                    "        ORDER BY VoucherHeaderID ASC\n" +
//                    "\t\t) AS PreviousVoucher\n" +
//                    "\t\t,\n" +
//                    "\n" +
//                    "\t\t\n" +
//                    "\n" +
//                    "\t\t  LEAD(VoucherHeaderID, 1) OVER(  \n" +
//                    "        ORDER BY VoucherHeaderID ASC\n" +
//                    "\t\t) AS NextVoucher\n" +
//                    "\n" +
//                    "\n" +
//                    " FROM SaleVoucherHeader AS svh\n" +
//                    " \n" +
//                    "   ) A \n" +
//                    "\twhere a.VoucherHeaderID =  @VoucherHeaderIDDynamic  ";
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(selectAllQuery);
//            int count = 0;
//
//            while (resultSet.next()) {
//                count++;
//
//                saleSurroundingVouchersDto.setCurrentVoucher(BigDecimal.valueOf(resultSet.getInt("CurrentVoucher")));
//                saleSurroundingVouchersDto.setPreviousVoucher(BigDecimal.valueOf(resultSet.getInt("PreviousVoucher")));
//                saleSurroundingVouchersDto.setNextVoucher(BigDecimal.valueOf(resultSet.getInt("NextVoucher")));
//
//            }
//
//
//            connection.close();
//
//        } catch (SQLException e) {
//            System.out.println("There was an error!");
//            e.printStackTrace();
//        }
//
//        return saleSurroundingVouchersDto;
//    }


}
