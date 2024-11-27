package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubGeoLocationType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

public interface PubGeoLocationTypeRepository extends TCrudRepository<PubGeoLocationType>, CrudRepository<PubGeoLocationType, BigDecimal> {
    @Query(value = "SELECT * FROM PubGeoLocationType  WHERE GeoLocationTypeDesc LIKE %:geoLocationTypeDesc%", nativeQuery = true)
    List<PubGeoLocationType> findByGeoLocationTypeDesc(@Param("geoLocationTypeDesc") String geoLocationTypeDesc);

    default PubGeoLocationType insertSPI(PubGeoLocationType pubGeoLocationType) {

        return insSPI(pubGeoLocationType);
    }

    default PubGeoLocationType updateSPI(PubGeoLocationType pubGeoLocationType) {
        return updSPI(pubGeoLocationType, pubGeoLocationType.getGeoLocationTypeID());
    }

}
