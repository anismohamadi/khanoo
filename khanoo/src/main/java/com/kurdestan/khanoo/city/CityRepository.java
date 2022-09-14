package com.kurdestan.khanoo.city;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface CityRepository extends PagingAndSortingRepository<City, Long>, JpaSpecificationExecutor<City> {

    Page<City> findAll(Pageable pageable);
    Page<City> findAll(Specification<City> specification, Pageable pageable);
    List<City> findAll(Specification<City> specification);

}
