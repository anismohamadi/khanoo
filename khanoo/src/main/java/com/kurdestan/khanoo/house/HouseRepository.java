package com.kurdestan.khanoo.house;

import com.kurdestan.khanoo.realestate.RealEstate;
import com.kurdestan.khanoo.region.Region;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.Point;
import org.postgresql.core.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseRepository extends PagingAndSortingRepository<House, Long>, JpaSpecificationExecutor<House> {
 List<House> findAllByRegion(Region region);
 List<House> findAllByRegion_City(Region region);
 List<House> findAllByRealEstate(RealEstate realEstate);
 Page<House> findAll(Pageable pageable);
 Page<House> findAll(Specification<House> specification, Pageable pageable);
 List<House> findAll(Specification<House> specification);





 @Query("SELECT vl, distance(vl.location, ?1) as distance from House vl order by distance")
 List<Tuple> findAllWithDistance(Point<G2D> refPnt);


 @Query("SELECT vl from House vl where  distance(vl.location, ?1) < ?2")
 List<House> findAllWithDistance(Point<G2D> refPnt, double dist);


 @Query("SELECT vl, distance(vl.location, ?1) as distance from House vl  order by distance" )
 List<Tuple> findNearest(Point<G2D> refPnt, Pageable page);


 @Query("SELECT v1 FROM House AS v1 WHERE  within(v1.location, :filter)=TRUE ")
 List<House> findWithin(@Param("filter") Geometry filter);

}


