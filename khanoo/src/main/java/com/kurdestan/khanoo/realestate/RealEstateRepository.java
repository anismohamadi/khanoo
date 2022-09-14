package com.kurdestan.khanoo.realestate;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.List;

public interface RealEstateRepository extends PagingAndSortingRepository<RealEstate, Long> , JpaSpecificationExecutor<RealEstate> {

    Page<RealEstate> findAll(Pageable pageable);
    Page<RealEstate> findAll(Specification<RealEstate> specification, Pageable pageable);
    List<RealEstate> findAll(Specification<RealEstate> specification);



    @Query("SELECT vl, distance(vl.location, ?1) as distance from RealEstate vl order by distance")
    List<Tuple> findAllWithDistance(Point<G2D> refPnt);


    @Query("SELECT vl from RealEstate vl where  distance(vl.location, ?1) < ?2")
    List<RealEstate> findAllWithDistance(Point<G2D> refPnt, double dist);


    @Query("SELECT vl, distance(vl.location, ?1) as distance from RealEstate vl  order by distance" )
    List<Tuple> findNearest(Point<G2D> refPnt, Pageable page);


    @Query("SELECT v1 FROM RealEstate AS v1 WHERE  within(v1.location, :filter)=TRUE ")
    List<RealEstate> findWithin(@Param("filter") Geometry filter);
}
