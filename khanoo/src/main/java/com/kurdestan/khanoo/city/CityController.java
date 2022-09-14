package com.kurdestan.khanoo.city;

import com.kurdestan.khanoo.common.PagingData;
import com.kurdestan.khanoo.common.SearchCriteria;
import com.kurdestan.khanoo.house.House;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@AllArgsConstructor
public class CityController {

    private final CityService service;
    private final CityMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody CityDTO cityDTO) {
        City city = mapper.toCity(cityDTO);
        service.save(city);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{id}")
    public  ResponseEntity getById(@PathVariable Long id){
        City city=service.getById(id);
        CityDTO cityDTO=mapper.toCityDTO(city);
        return ResponseEntity.ok(cityDTO);
    }

    @GetMapping("/v1")
    public  ResponseEntity<List<CityDTO>> getAll(){
        List<City> cityList=service.getAll();
        List<CityDTO> cityDTOS=mapper.toCityDTOS(cityList);
        return ResponseEntity.ok(cityDTOS);
    }

    @PostMapping(value = "/v1/search")
    public ResponseEntity<List<CityDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<City> cities= service.search(searchCriteria);
        List<CityDTO> cityDTOS = mapper.toCityDTOS(cities);
        return ResponseEntity.ok(cityDTOS);
    }


}
