/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvGoodsGroup;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.SortField;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface InvGoodsGroupRepository extends CrudRepository<InvGoodsGroup, BigDecimal>, TCrudRepository<InvGoodsGroup> {

    default List<InvGoodsGroup> invShowGoodsGroup(String ip,
                                                  String port,
                                                  InvGoodsGroup invGoodsGroup) {
        List<TParameter<?>> parameters = new ArrayList<>();
        if (invGoodsGroup.getFatherID() == null) {
            if(invGoodsGroup.getFilter()==null){
                invGoodsGroup.setFilter(" FatherID = "+firstGoodsGroupGroupID()+" AND isNotActive = 0");
            }else{
                //
            }
        } else {
            if(invGoodsGroup.getFilter()==null){
                invGoodsGroup.setFilter(" FatherID = "+invGoodsGroup.getFatherID()+" AND isNotActive = 0");
            }else{
                invGoodsGroup.setFilter(invGoodsGroup.getFilter()+" AND FatherID = "+invGoodsGroup.getFatherID()+" AND isNotActive = 0");
            }
        }

        SortField sortField = new SortField();
        sortField.setName("GroupDesc");
        sortField.setDesc(false);
        invGoodsGroup.setSortField(sortField);

        parameters.add(new TParameter<>("Filter", null));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("PageFilter", invGoodsGroup._pageFilter()));
        List<InvGoodsGroup> invGoodsGroups = showSP("InvShowGoodsGroup", parameters, true);

        File fileStaticImagesGoodsGroups;
        try {
            fileStaticImagesGoodsGroups = ResourceUtils.getFile("classpath:static/images/goodsgroups");
            File[] fileGoodsGroupsImageDirs = fileStaticImagesGoodsGroups.listFiles();
            String[] goodsGroupsImageDirNames = fileStaticImagesGoodsGroups.list();
            for (int i = 0; i < fileGoodsGroupsImageDirs.length; i++) {
                String[] goodsGroupsImageFileNames = fileGoodsGroupsImageDirs[i].list();
                Arrays.sort(goodsGroupsImageFileNames);
                List<String> imageUrls = imageUrls(ip, port, goodsGroupsImageDirNames[i], goodsGroupsImageFileNames);
                for (int j = 0; j < invGoodsGroups.size(); j++) {
                    InvGoodsGroup invGoodsGroup1 = invGoodsGroups.get(j);
                    if (invGoodsGroup1.getGroupID().toString().equals(goodsGroupsImageDirNames[i])) {
                        invGoodsGroup1.setImageGroup(imageUrls.get(0));
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return invGoodsGroups;
        }
//        return invGoodsGroups;
    }

    default List<InvGoodsGroup> invShowGoodsGroupWeb(String ip,
                                                     String port,
                                                     InvGoodsGroup invGoodsGroup) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("PageFilter", null));
        List<InvGoodsGroup> invGoodsGroups = showSP("InvShowGoodsGroup", parameters, true);

        File fileStaticImagesGoodsGroups;
        try {
            fileStaticImagesGoodsGroups = ResourceUtils.getFile("classpath:static/images/goodsgroups");
            File[] fileGoodsGroupsImageDirs = fileStaticImagesGoodsGroups.listFiles();
            String[] goodsGroupsImageDirNames = fileStaticImagesGoodsGroups.list();
            for (int i = 0; i < fileGoodsGroupsImageDirs.length; i++) {
                String[] goodsGroupsImageFileNames = fileGoodsGroupsImageDirs[i].list();
                Arrays.sort(goodsGroupsImageFileNames);
                List<String> imageUrls = imageUrls(ip, port, goodsGroupsImageDirNames[i], goodsGroupsImageFileNames);
                for (int j = 0; j < invGoodsGroups.size(); j++) {
                    InvGoodsGroup invGoodsGroup1 = invGoodsGroups.get(j);
                    if (invGoodsGroup1.getGroupID().toString().equals(goodsGroupsImageDirNames[i])) {
                        invGoodsGroup1.setImageGroup(imageUrls.get(0));
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return invGoodsGroups;
        }
//        return invGoodsGroups;
    }

    default List<String> imageUrls(String ip, String port, String directoryName, String[] goodsGroupsImageFileNames) {
        List<String> imageUrls = new ArrayList<>();
        for (int i = 0; i < goodsGroupsImageFileNames.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://");
            stringBuilder.append(ip);
            stringBuilder.append(":");
            stringBuilder.append(port);
            stringBuilder.append("/tws/images/goodsgroups/");
            stringBuilder.append(directoryName);
            stringBuilder.append("/");
            stringBuilder.append(goodsGroupsImageFileNames[i]);
            imageUrls.add(stringBuilder.toString());
        }
        return imageUrls;
    }

    default BigDecimal firstGoodsGroupGroupID() {// گروپ آی دی اولین رکورد . جد همه رکورد ها
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", " AND main.FatherID IS NULL"));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("PageFilter", null));
        List<InvGoodsGroup> invGoodsGroups = showSP("InvShowGoodsGroup", parameters, true);
        return invGoodsGroups.get(0).getGroupID();
    }

    default InvGoodsGroup invShowGoodsGroupByID(BigDecimal groupID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", " AND main.GroupID = " + groupID));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvShowGoodsGroup", parameters, true).get(0);
    }

    default InvGoodsGroup invInsGoodsGroup
            (InvGoodsGroup invGoodsGroup) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("GroupCode", invGoodsGroup.getGroupCode()));
        parameters.add(new TParameter<>("GroupDesc", invGoodsGroup.getGroupDesc()));
        parameters.add(new TParameter<>("ModifierID", logins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("CreatorID", logins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        parameters.add(new TParameter<>("TafsiliTypeID", invGoodsGroup.getTafsiliTypeID()));
        parameters.add(new TParameter<>("PricingMethod", invGoodsGroup.getPricingMethod()));
        parameters.add(new TParameter<>("FatherID", invGoodsGroup.getFatherID()));
        parameters.add(new TParameter<>("GroupLevel", invGoodsGroup.getGroupLevel()));
        parameters.add(new TParameter<>("GroupLatinDesc", invGoodsGroup.getGroupLatinDesc()));
        parameters.add(new TParameter<>("IsNotActive", invGoodsGroup.getIsNotActive()));
        parameters.add(new TParameter<>("IsOnlineSale", invGoodsGroup.getIsOnlineSale()));
        BigDecimal newID = insSP("InvInsGoodsGroup", parameters);
        return invShowGoodsGroupByID(newID);
    }

    default void invDelGoodsGroup(BigDecimal groupID) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("GroupID", groupID));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        delSP("InvDelGoodsGroup", parameters);
    }

    default InvGoodsGroup invUpdGoodsGroup(BigDecimal groupID, InvGoodsGroup invGoodsGroup) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("GroupID", groupID));
        parameters.add(new TParameter<>("GroupCode", invGoodsGroup.getGroupCode()));
        parameters.add(new TParameter<>("GroupDesc", invGoodsGroup.getGroupDesc()));
        parameters.add(new TParameter<>("ModifierID", logins.getPubUser().getModifierID()));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        parameters.add(new TParameter<>("TafsiliTypeID", invGoodsGroup.getTafsiliTypeID()));
        parameters.add(new TParameter<>("PricingMethod", invGoodsGroup.getPricingMethod()));
        parameters.add(new TParameter<>("FatherID", invGoodsGroup.getFatherID()));
        parameters.add(new TParameter<>("iGroupID", invGoodsGroup.getGroupLevel()));
        parameters.add(new TParameter<>("GroupLatinDesc", invGoodsGroup.getGroupLatinDesc()));
        parameters.add(new TParameter<>("IsNotActive", invGoodsGroup.getIsNotActive()));
        parameters.add(new TParameter<>("IsOnlineSale", invGoodsGroup.getIsOnlineSale()));
        updSP("InvUpdGoodsGroup", parameters);
        return invShowGoodsGroupByID(groupID);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"groupID", "groupID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"groupCode", "کد گروه", Type.STRING, 90, true, true,  false));
        cols.add(new Col(null,"groupDesc", "شرح گروه", Type.STRING, 90, true, true,  false));
        cols.add(new Col(null,"groupLatinDesc", "شرح لاتین گروه", Type.STRING, 90, true, true,  false));
        cols.add(new Col(null,"tafsiliTypeDesc", "تفضیلی/گروه تفضیلی", Type.STRING, 90, true, true,  false));
        cols.add(new Col(null,"tafsiliCode", "کد تفضیلی", Type.STRING, 90, true, true,  false));
        cols.add(new Col(null,"pricingMethod", "نحوه قیمت گذاری", Type.INTEGER, 90, true, true,  false));
        cols.add(new Col(null,"isNotActive", "غیرفعال", Type.BOOLEAN, 90, true, true,  false));
        cols.add(new Col(null,"isOnlineSale", "نمایش در فروشگاه انلاین", Type.BOOLEAN, 90, true, true,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"tafsiliID", "tafsiliID", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"pricingDesc", "pricingDesc", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"fatherID", "fatherID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"fatherGroupCode", "fatherGroupCode", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"fatherGroupDesc", "fatherGroupDesc", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"groupLevel", "groupLevel", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"imageGroup", "imageGroup", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"level", "level", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"hasChild", "hasChild", Type.BOOLEAN, 0, false, false,  false));
        cols.add(new Col(null,"parentIDs", "parentIDs", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"isLeaf", "isLeaf", Type.BOOLEAN, 0, false, false,  false));
        cols.add(new Col(null,"tafsiliTypeID", "tafsiliTypeID", Type.STRING, 0, false, false,  false));
        return new Meta(cols);

    }
}
