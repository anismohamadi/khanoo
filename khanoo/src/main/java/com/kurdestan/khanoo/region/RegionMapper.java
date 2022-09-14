package com.kurdestan.khanoo.region;

import com.kurdestan.khanoo.city.City;
import com.kurdestan.khanoo.city.CityMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CityMapper.class})
public interface RegionMapper {
    Region toRegion(RegionDTO regionDTO);
    RegionDTO toRegionDTO(Region region);
    List<Region> toRegions(List<RegionDTO> regionDTOS);
    List<RegionDTO> toRegionDTOs(List<Region> regions );

}
