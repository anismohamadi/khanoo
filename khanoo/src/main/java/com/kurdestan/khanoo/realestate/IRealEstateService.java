package com.kurdestan.khanoo.realestate;


import com.kurdestan.khanoo.common.SearchCriteria;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IRealEstateService {
    RealEstate save(RealEstate realEstate);
    RealEstate update(RealEstate realEstate);
    void delete(Long id);
    RealEstate getById(Long id);
    List<RealEstate> getAll();
    Page<RealEstate> paging(Integer page, Integer size);
    List<RealEstate> findNearest(Point<G2D> point, double distance);
    List<RealEstate> search(List<SearchCriteria> searchCriteria);
}
