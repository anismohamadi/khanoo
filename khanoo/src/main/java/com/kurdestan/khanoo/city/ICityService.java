package com.kurdestan.khanoo.city;

import com.kurdestan.khanoo.common.SearchCriteria;
import org.springframework.data.domain.Page;


import java.util.List;

public interface ICityService {
    City save(City city);
    City getById(Long id);
    List<City> getAll();
    Page<City> paging(Integer page, Integer size);
    List<City> search(List<SearchCriteria> searchCriteria);

}
