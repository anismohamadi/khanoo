package com.kurdestan.khanoo.image;

import java.util.List;

public interface IImageService {
    Image save(Image image);
    void delete(Long id);
    Image getById(Long id);
    List<Image> getAll();
    Image getByHouseId(Long houseId);

}
