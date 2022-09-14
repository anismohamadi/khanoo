package com.kurdestan.khanoo.house;

import com.kurdestan.khanoo.common.PagingData;
import com.kurdestan.khanoo.common.SearchCriteria;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house/")
@AllArgsConstructor
public class HouseController {

    private  final IHouseService service;
    private final HouseMapper mapper;

    @PostMapping ("/v1")
    public ResponseEntity save(@RequestBody HouseDTO houseDTO) {
        House house = mapper.toHouse(houseDTO);
        service.save(house);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody HouseDTO houseDTO){
        House house=mapper.toHouse(houseDTO);
        service.save(house);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{id}")
    public  ResponseEntity getById(@PathVariable Long id){
        House house=service.getById(id);
        HouseDTO houseDTO=mapper.toHouseDTO(house);
        return ResponseEntity.ok(houseDTO);
    }


    @Timed("house.getAll")
    @GetMapping("/v1")
    public  ResponseEntity<List<HouseDTO>> getAll(){
        List<House> houseList=service.getAll();
        List<HouseDTO> houseDTOS=mapper.toHouseDTOs(houseList);
        return ResponseEntity.ok(houseDTOS);
    }

    @GetMapping("/v1/getByRegion/{regionId}")
    public  ResponseEntity<List<HouseDTO>> getByRegionId(@PathVariable Long regionId){
        List<House> houses=service.getAllByRegion(regionId);
        List<HouseDTO> houseDTOS=mapper.toHouseDTOs(houses);
        return ResponseEntity.ok(houseDTOS);
    }


    @GetMapping("/v1/getByRegion_City/{regionId}")
    public  ResponseEntity<List<HouseDTO>> getByRegion_City_Id(@PathVariable Long regionId){
        List<House> houses=service.getAllByRegion_City(regionId);
        List<HouseDTO> houseDTOS=mapper.toHouseDTOs(houses);
        return ResponseEntity.ok(houseDTOS);
    }


    @GetMapping("/v1/getByRealEstate/{realEstateId}")
    public  ResponseEntity<List<HouseDTO>> getByRealEstateId(@PathVariable Long realEstateId){
        List<House> houses=service.getAllByRealEstate(realEstateId);
        List<HouseDTO> houseDTOS=mapper.toHouseDTOs(houses);
        return ResponseEntity.ok(houseDTOS);
    }


    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<House>> getByRegion(@PathVariable Integer page,Integer size){
        Page<House> housePage=    service.paging(page,size);
        int totalPage=  housePage.getTotalPages();
        List<House> data= housePage.getContent();
        PagingData<House> pagingData=new PagingData<>(totalPage,page,data)  ;
        return ResponseEntity.ok(pagingData);
    }
    @GetMapping
    public ResponseEntity<PagingData<House>> getByRealEstate(@PathVariable Integer page,Integer size){
        Page<House> housePage=    service.paging(page,size);
        int totalPage=  housePage.getTotalPages();
        List<House> data= housePage.getContent();
        PagingData<House> pagingData=new PagingData<>(totalPage,page,data)  ;
        return ResponseEntity.ok(pagingData);
    }


    @PostMapping(value = "/v1/search")
    public ResponseEntity<List<HouseDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<House> houses= service.search(searchCriteria);
        List<HouseDTO> houseDTOS = mapper.toHouseDTOs(houses);
        return ResponseEntity.ok(houseDTOS);
    }


    @GetMapping(value = "findNearest/{lat}/{lng}/{distance}")
    public ResponseEntity<List<HouseDTO>> findNearest(@PathVariable("lat") double lat,@PathVariable("lng") double lng,@PathVariable("distance") double distance) {
        Point<G2D> candidPoint= Geometries.mkPoint(new G2D(lng, lat), CoordinateReferenceSystems.WGS84);

        List<House> placeList = service.findNearest(candidPoint, distance);
        List<HouseDTO> assetDTOS = mapper.toHouseDTOs(placeList);
        return ResponseEntity.ok(assetDTOS);
    }



}
