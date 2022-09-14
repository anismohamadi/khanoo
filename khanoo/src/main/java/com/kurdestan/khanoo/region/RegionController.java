package com.kurdestan.khanoo.region;

import com.kurdestan.khanoo.common.PagingData;
import com.kurdestan.khanoo.common.SearchCriteria;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
@AllArgsConstructor
public class RegionController {

    private  final IRegionService service;
    private  final  RegionMapper mapper;


    @PostMapping ("/v1")
    public ResponseEntity save(@RequestBody RegionDTO regionDTO) {
        Region region = mapper.toRegion(regionDTO);
        service.save(region);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{id}")
    public  ResponseEntity getById(@PathVariable Long id){
        Region region=service.getById(id);
        RegionDTO regionDTO=mapper.toRegionDTO(region);
        return ResponseEntity.ok(regionDTO);
    }



    @GetMapping("/v1")
    public  ResponseEntity<List<RegionDTO>> getAll(){
        List<Region> regionList=service.getAll();
        List<RegionDTO> regionDTOS=mapper.toRegionDTOs(regionList);
        return ResponseEntity.ok(regionDTOS);
    }

    @GetMapping("/v1/getByCity/{cityId}")
    public  ResponseEntity<List<RegionDTO>> getByCityId(@PathVariable Long cityId){
        List<Region> regionList=service.getAllByCity(cityId);
        List<RegionDTO> regionDTOs=mapper.toRegionDTOs(regionList);
        return ResponseEntity.ok(regionDTOs);
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<Region>> getByCity(@PathVariable Integer page, Integer size){
        Page<Region> regionPage=    service.paging(page,size);
        int totalPage=  regionPage.getTotalPages();
        List<Region> data= regionPage.getContent();
        PagingData<Region> pagingData=new PagingData<>(totalPage,page,data)  ;
        return ResponseEntity.ok(pagingData);
    }


    @PostMapping(value = "/v1/search")
    public ResponseEntity<List<RegionDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<Region> regions= service.search(searchCriteria);
        List<RegionDTO> regionDTOS = mapper.toRegionDTOs(regions);
        return ResponseEntity.ok(regionDTOS);
    }

}
