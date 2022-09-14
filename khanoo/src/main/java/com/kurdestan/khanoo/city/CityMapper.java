package com.kurdestan.khanoo.city;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City toCity(CityDTO cityDTO);
    CityDTO toCityDTO(City city);
    List<City> toCities(List<CityDTO> cityDTOS);
    List<CityDTO> toCityDTOS(List<City> cities);
}
