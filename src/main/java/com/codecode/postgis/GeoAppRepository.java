package com.codecode.postgis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GeoAppRepository extends JpaRepository<GeoApp, Long> {
    @Query(value = """
            SELECT * FROM uber 
            WHERE ST_DWithin(
                location,
                ST_MakePoint(:lng, :lat)::geography,
                :radius
            )
            """, nativeQuery = true)
    List<GeoApp> findAllPlaceWithin(@Param("lng") double lng, @Param("lat") double lat, @Param("radius") double radius);

}
