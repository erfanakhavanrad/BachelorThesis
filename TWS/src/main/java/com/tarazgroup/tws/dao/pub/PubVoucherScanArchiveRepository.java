package com.tarazgroup.tws.dao.pub;


import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.AttachmentModel;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubVoucherScanArchive;
import com.tarazgroup.tws.model.zip.MemZipDec;
import com.tarazgroup.tws.model.zip.MemZipEnc;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @authors A.Farahani, Erfan Akhavan
 * @date 12/13/21
 */

// TODO: 12/13/21 doesn't have page filter

public interface PubVoucherScanArchiveRepository extends TCrudRepository<PubVoucherScanArchive>, CrudRepository<PubVoucherScanArchive, BigDecimal> {
    default List<PubVoucherScanArchive> pubShowVoucherScanArchive(PubVoucherScanArchive pubVoucherScanArchive) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubVoucherScanArchive._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubVoucherScanArchive._yearFilter()));
        tParameters.add(new TParameter<>("UserPubessFilter", null));
        tParameters.add(new TParameter<>("IsShowBaseArchive", null));
        tParameters.add(new TParameter<>("PageFilter", pubVoucherScanArchive._pageFilter()));
        tParameters.add(new TParameter<>("VoucherHeaderID", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("ImageID", null));
        return showSP("PubShowVoucherScanArchive", tParameters, true);
    }

    default PubVoucherScanArchive pubShowVoucherScanArchiveByID(BigDecimal imageID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.ImageID = " + imageID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserPubessFilter", null));
        tParameters.add(new TParameter<>("IsShowBaseArchive", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        tParameters.add(new TParameter<>("VoucherHeaderID", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("ImageID", null));
        return showSP("PubShowVoucherScanArchive", tParameters, true).get(0);
    }

    default PubVoucherScanArchive pubShowVoucherScanArchiveByIDFile(BigDecimal imageID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.ImageID = " + imageID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserPubessFilter", null));
        tParameters.add(new TParameter<>("IsShowBaseArchive", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        tParameters.add(new TParameter<>("VoucherHeaderID", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("ImageID", null));
        return showSP("PubShowVoucherScanArchive", tParameters, true).get(0);
    }

    default PubVoucherScanArchive pubInsVoucherAttachmentByteArray(BigDecimal voucherHeaderID, AttachmentModel attachmentModel) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("VoucherTypeID", attachmentModel.getVoucherTypeID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ImageScan", attachmentModel.getPhotoByteArray()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("OtherFiles", null));
        tParameters.add(new TParameter<>("ImageID", null));
        tParameters.add(new TParameter<>("SaveType", null));
        tParameters.add(new TParameter<>("CategoryID", null));
        tParameters.add(new TParameter<>("TafsiliID", null));
        tParameters.add(new TParameter<>("Center1ID", null));
        tParameters.add(new TParameter<>("Center2ID", null));
        tParameters.add(new TParameter<>("Center3ID", null));
        tParameters.add(new TParameter<>("ArchiveDesc", null));
        tParameters.add(new TParameter<>("ReferNumber", null));
        tParameters.add(new TParameter<>("ReferDate", null));
        BigDecimal newID = insSP("PubInsVoucherScanArchive", tParameters);
        return pubShowVoucherScanArchiveByID(newID);
    }


    default PubVoucherScanArchive pubInsVoucherAttachmentString(BigDecimal voucherHeaderID, AttachmentModel attachmentModel) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("VoucherTypeID", attachmentModel.getVoucherTypeID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ImageScan", attachmentModel.getPhotoString()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("OtherFiles", null));
        tParameters.add(new TParameter<>("ImageID", null));
        tParameters.add(new TParameter<>("SaveType", null));
        tParameters.add(new TParameter<>("CategoryID", null));
        tParameters.add(new TParameter<>("TafsiliID", null));
        tParameters.add(new TParameter<>("Center1ID", null));
        tParameters.add(new TParameter<>("Center2ID", null));
        tParameters.add(new TParameter<>("Center3ID", null));
        tParameters.add(new TParameter<>("ArchiveDesc", null));
        tParameters.add(new TParameter<>("ReferNumber", null));
        tParameters.add(new TParameter<>("ReferDate", null));
        BigDecimal newID = insSP("PubInsVoucherScanArchive", tParameters);
        return pubShowVoucherScanArchiveByID(newID);
    }

    default PubVoucherScanArchive pubInsVoucherAttachment(BigDecimal voucherHeaderID, AttachmentModel attachmentModel) throws SQLException {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        String password = "T@R@Z.TARAZ";
        String zippedFile = "ImageFromMobile";
        final byte[] encryptZipByte = MemZipEnc.getEncryptZipByte(attachmentModel.getPhotoByteArray(), password, zippedFile);

        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("VoucherTypeID", attachmentModel.getVoucherTypeID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ImageScan", attachmentModel.getPhotoByteArray()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("OtherFiles", encryptZipByte));
        tParameters.add(new TParameter<>("ImageID", null));
        // TRUE in other files, FALSE in ImageScan, Null saves in neither of em
        tParameters.add(new TParameter<>("SaveType", true));
        tParameters.add(new TParameter<>("CategoryID", null));
        tParameters.add(new TParameter<>("TafsiliID", null));
        tParameters.add(new TParameter<>("Center1ID", null));
        tParameters.add(new TParameter<>("Center2ID", null));
        tParameters.add(new TParameter<>("Center3ID", null));
        tParameters.add(new TParameter<>("ArchiveDesc", null));
        tParameters.add(new TParameter<>("ReferNumber", null));
        tParameters.add(new TParameter<>("ReferDate", null));
        tParameters.add(new TParameter<>("IsWeb", true));

        pubDelVoucherScanArchiveWeb(voucherHeaderID, attachmentModel.getVoucherTypeID());


        BigDecimal newID = insSP("PubInsVoucherScanArchive", tParameters);
        return pubShowVoucherScanArchiveByID(newID);
    }


    default PubVoucherScanArchive pubShowVoucherScanArchiveByVoucherHeaderID(BigDecimal voucherHeaderID) throws IOException {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.voucherHeaderID = " + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserPubessFilter", null));
        tParameters.add(new TParameter<>("IsShowBaseArchive", null));
        tParameters.add(new TParameter<>("VoucherHeaderID", null));
        tParameters.add(new TParameter<>("VoucherTypeID", null));
        tParameters.add(new TParameter<>("ImageID", null));

        PubVoucherScanArchive pubVoucherScanArchive = showSP("PubShowVoucherScanArchive", tParameters, true).get(0);

        String password = "T@R@Z.TARAZ";
        byte[] decryptedZipByte;
        decryptedZipByte = MemZipDec.unzipFiles(pubVoucherScanArchive.getOtherFiles(), password);

        pubVoucherScanArchive.setOtherFiles(decryptedZipByte);

        return pubVoucherScanArchive;
    }


    default void pubDelVoucherScanArchive(BigDecimal voucherHeaderID, BigDecimal voucherTypeID, Integer delType, BigDecimal imageID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("DelType", delType));
        tParameters.add(new TParameter<>("ImageID", imageID));
        delSP("PubDelVoucherScanArchive", tParameters);
    }

    default void pubDelVoucherScanArchiveWeb(BigDecimal voucherHeaderID, BigDecimal voucherTypeID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        tParameters.add(new TParameter<>("IsWeb", true));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("PubDelVoucherScanArchive_Web", tParameters);
    }

}
