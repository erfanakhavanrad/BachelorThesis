package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.pub.IdDescDto;
import com.tarazgroup.tws.dto.pub.StoreDto;
import com.tarazgroup.tws.dto.pub.PubVoucherStoreDefaultSettingDto;
import com.tarazgroup.tws.dto.pub.PubVoucherStoreDefaultSettingsDto;
import com.tarazgroup.tws.model.pub.PubVoucherStoreDefaultSettings;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Mar-15, 2022
 ***/
public interface PubVoucherStoreDefaultSettingsRepository extends TCrudRepository<PubVoucherStoreDefaultSettings>, CrudRepository<PubVoucherStoreDefaultSettings, BigDecimal> {
    default List<PubVoucherStoreDefaultSettingsDto> getVoucherTypeStore(PubVoucherStoreDefaultSettings pubVoucherStoreDefaultSettings1) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        List<PubVoucherStoreDefaultSettings> pubVoucherStoreDefaultSettings = showSP("PubVoucherStoreDefaultSettings", tParameters, true);
        List<PubVoucherStoreDefaultSettingsDto> pubVoucherStoreDefaultSettingsDtos = new ArrayList<>();

        PubVoucherStoreDefaultSettings sale1 =  pubVoucherStoreDefaultSettings.get(0);
        PubVoucherStoreDefaultSettings sadereh1 =  pubVoucherStoreDefaultSettings.get(1);
        PubVoucherStoreDefaultSettings varedeh1 =  pubVoucherStoreDefaultSettings.get(2);

        PubVoucherStoreDefaultSettingsDto pubVoucherStoreDefaultSettingsDto =  new PubVoucherStoreDefaultSettingsDto();
        PubVoucherStoreDefaultSettingDto pubVoucherStoreDefaultSettingDto =  new PubVoucherStoreDefaultSettingDto();
        IdDescDto saleIdDescDto = new IdDescDto();
        saleIdDescDto.setId(sale1.getVoucherTypeID());
        saleIdDescDto.setDesc(sale1.getVoucherTypeDesc());
        pubVoucherStoreDefaultSettingDto.setVoucherType(saleIdDescDto);

        IdDescDto saleIdDescDto2 = new IdDescDto();
        saleIdDescDto2.setId(sale1.getStoreID());
        saleIdDescDto2.setDesc(sale1.getStoreName());
        pubVoucherStoreDefaultSettingDto.setInv(saleIdDescDto2);

        IdDescDto saleIdDescDto3 = new IdDescDto();
        saleIdDescDto3.setId(sale1.getRefTypeID());
        saleIdDescDto3.setDesc(sale1.getRefTypeDesc());
        pubVoucherStoreDefaultSettingDto.setRefType(saleIdDescDto3);

        IdDescDto invIdDescDto = new IdDescDto();
        invIdDescDto.setId(sadereh1.getVoucherTypeID());
        invIdDescDto.setDesc(sadereh1.getVoucherTypeDesc());
        PubVoucherStoreDefaultSettingDto sadereh =  new PubVoucherStoreDefaultSettingDto();
        sadereh.setVoucherType(invIdDescDto);

        IdDescDto invIdDescDto2 = new IdDescDto();
        invIdDescDto2.setId(sadereh1.getStoreID());
        invIdDescDto2.setDesc(sadereh1.getStoreName());
        sadereh.setInv(invIdDescDto2);

        IdDescDto invIdDescDto3 = new IdDescDto();
        invIdDescDto3.setId(sadereh1.getRefTypeID());
        invIdDescDto3.setDesc(sadereh1.getRefTypeDesc());
        sadereh.setRefType(invIdDescDto3);

        IdDescDto _invIdDescDto = new IdDescDto();
        _invIdDescDto.setId(varedeh1.getVoucherTypeID());
        _invIdDescDto.setDesc(varedeh1.getVoucherTypeDesc());
        PubVoucherStoreDefaultSettingDto varedeh =  new PubVoucherStoreDefaultSettingDto();
        varedeh.setVoucherType(_invIdDescDto);

        IdDescDto _invIdDescDto2 = new IdDescDto();
        _invIdDescDto2.setId(varedeh1.getStoreID());
        _invIdDescDto2.setDesc(varedeh1.getStoreName());
        varedeh.setInv(_invIdDescDto2);

        IdDescDto _invIdDescDto3 = new IdDescDto();
        _invIdDescDto3.setId(varedeh1.getRefTypeID());
        _invIdDescDto3.setDesc(varedeh1.getRefTypeDesc());
        varedeh.setRefType(_invIdDescDto3);


        StoreDto storeDto = new StoreDto();
        storeDto.setSadereh(sadereh);
        storeDto.setVaredeh(varedeh);

        pubVoucherStoreDefaultSettingsDto.setSale(pubVoucherStoreDefaultSettingDto);
        pubVoucherStoreDefaultSettingsDto.setInv(storeDto);

        pubVoucherStoreDefaultSettingsDtos.add(pubVoucherStoreDefaultSettingsDto);

        return pubVoucherStoreDefaultSettingsDtos;
    }
}
