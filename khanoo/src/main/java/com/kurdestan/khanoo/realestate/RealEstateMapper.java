package com.kurdestan.khanoo.realestate;

import com.kurdestan.khanoo.realestate.LocationDTO;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface RealEstateMapper {



    @Mappings({
            @Mapping(source = "locationDTO", target = "location", qualifiedByName = "locationDtoToLocation")})
    RealEstate toRealEstate(RealEstateDTO realEstateDTO);

    @Mappings({
            @Mapping(source = "location", target = "locationDTO", qualifiedByName = "locationToLocationDTO")})
    RealEstateDTO toRealEstateDTO(RealEstate realEstate);
    List<RealEstate> toRealEstateList(List<RealEstateDTO> realEstateDTOS);

    List<RealEstateDTO> toRealEstateDTOs(List<RealEstate> realEstateList);




    @Named("locationDtoToLocation")
    default Point<G2D> convertLocationDtoToLocation(LocationDTO locationDTO){
        Point<G2D> candidPoint= Geometries.mkPoint(new G2D(locationDTO.getLng(), locationDTO.getLat()), CoordinateReferenceSystems.WGS84);
        return  candidPoint;
    }

    @Named("locationToLocationDTO")
    default  LocationDTO  convertLocationToLocationDTO(Point<G2D> point){
        G2D g2D=   point.getPosition();
        LocationDTO locationDTO=new LocationDTO();
        locationDTO.setLat(g2D.getLat());
        locationDTO.setLng(g2D.getLon());
        return  locationDTO;
    }


}
