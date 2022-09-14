package com.kurdestan.khanoo.image;

import com.kurdestan.khanoo.common.exception.NotFoundException;
import com.kurdestan.khanoo.house.House;
import com.kurdestan.khanoo.house.HouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageService implements IImageService {

    private final ImageRepository repository;
    private final HouseService service;

    @Override
    public Image save(Image image) {
        Long houseId=image.getHouse().getId();
        House house=service.getById(houseId);
        image.setHouse(house);
        return repository.save(image);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Image getById(Long id) {
        Optional<Image> optionalImage=repository.findById(id);
        if (!optionalImage.isPresent()){
            throw  new NotFoundException("Not Found Image");
        }
        return null;
    }

    @Override
    public List<Image> getAll() {
        return (List<Image>) repository.findAll();
    }

    @Override
    public Image getByHouseId(Long houseId) {
       House house=service.getById(houseId);
       return  repository.findByHouse(house);
    }


}
