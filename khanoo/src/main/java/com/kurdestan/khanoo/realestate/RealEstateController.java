package com.kurdestan.khanoo.realestate;

import com.kurdestan.khanoo.common.SearchCriteria;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realEstate")
@AllArgsConstructor
public class RealEstateController {
    private final RealEstateService service;
    private final RealEstateMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody RealEstateDTO realEstateDTO) {
        RealEstate realEstate = mapper.toRealEstate(realEstateDTO);
        service.save(realEstate);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody RealEstateDTO realEstateDTO){
        RealEstate realEstate=mapper.toRealEstate(realEstateDTO);
        service.save(realEstate);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{id}")
    public  ResponseEntity getById(@PathVariable Long id){
        RealEstate realEstate=service.getById(id);
        RealEstateDTO realEstateDTO=mapper.toRealEstateDTO(realEstate);
        return ResponseEntity.ok(realEstateDTO);
    }


    @GetMapping("/v1")
    public  ResponseEntity<List<RealEstateDTO>> getAll(){
        List<RealEstate> realEstateList=service.getAll();
        List<RealEstateDTO> realEstateDTOS=mapper.toRealEstateDTOs(realEstateList);
        return ResponseEntity.ok(realEstateDTOS);
    }


    @GetMapping(value = "findNearest/{lat}/{lng}/{distance}")
    public ResponseEntity<List<RealEstateDTO>> findNearest(@PathVariable("lat") double lat, @PathVariable("lng") double lng, @PathVariable("distance") double distance) {
        Point<G2D> candidPoint= Geometries.mkPoint(new G2D(lng, lat), CoordinateReferenceSystems.WGS84);

        List<RealEstate> realEstateList = service.findNearest(candidPoint, distance);
        List<RealEstateDTO> assetDTOS = mapper.toRealEstateDTOs(realEstateList);
        return ResponseEntity.ok(assetDTOS);
    }


    @PostMapping(value = "/v1/search")
    public ResponseEntity<List<RealEstateDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<RealEstate> realEstates= service.search(searchCriteria);
        List<RealEstateDTO> realEstateDTOS = mapper.toRealEstateDTOs(realEstates);
        return ResponseEntity.ok(realEstateDTOS);
    }
}