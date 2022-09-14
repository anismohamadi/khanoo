package com.kurdestan.khanoo.region;

import com.kurdestan.khanoo.common.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IRegionService {
    Region save(Region region);
    Region getById(Long id);
    List<Region> getAll();
    List<Region> getAllByCity(Long cityId);
    Page<Region> paging(Integer page, Integer size);
    List<Region> search(List<SearchCriteria> searchCriteria);


}
