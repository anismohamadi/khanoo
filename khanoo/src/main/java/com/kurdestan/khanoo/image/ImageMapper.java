package com.kurdestan.khanoo.image;

import com.kurdestan.khanoo.house.HouseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring", uses = {HouseMapper.class})
public interface ImageMapper {
    Image toImage(ImageDTO imageDTO);
    ImageDTO toImageDTO(Image image);
    List<Image> toImages(List<ImageDTO> imageDTOS);
    List<ImageDTO> toImageDTOS(List<Image> images);
}
