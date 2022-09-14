package com.kurdestan.khanoo.house;
import com.kurdestan.khanoo.common.SearchCriteria;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.domain.Page;


import java.util.List;

public interface IHouseService {
    House save(House house);
    void delete(Long id);
    House update(House house);
    House getById(Long id);
    List<House> getAll();
    List<House> getAllByRealEstate(Long realEstateId);
    List<House> getAllByRegion(Long  regionId);
    List<House> getAllByRegion_City(Long regionId);
    Page<House> paging(Integer page,Integer size);
    List<House> findNearest(Point<G2D> point, double distance);
    List<House> search(List<SearchCriteria> searchCriteria);


}
