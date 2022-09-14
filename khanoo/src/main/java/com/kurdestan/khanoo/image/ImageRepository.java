package com.kurdestan.khanoo.image;

import com.kurdestan.khanoo.house.House;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {
    Image findByHouse(House house);

}
