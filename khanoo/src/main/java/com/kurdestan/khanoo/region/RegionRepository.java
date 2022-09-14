package com.kurdestan.khanoo.region;

import com.kurdestan.khanoo.city.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RegionRepository extends PagingAndSortingRepository<Region, Long>  , JpaSpecificationExecutor<Region> {
    List<Region> findAllByCity(City city);
    Page<Region> findAll(Pageable pageable);
    Page<Region> findAll(Specification<Region> specification, Pageable pageable);
    List<Region> findAll(Specification<Region> specification);
}
