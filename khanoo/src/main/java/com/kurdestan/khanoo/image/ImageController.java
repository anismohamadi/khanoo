package com.kurdestan.khanoo.image;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/image")
@AllArgsConstructor
public class ImageController {

    private  final  ImageService service;
    private  final  ImageMapper mapper;

    @PostMapping(value = "/v1")
    public ResponseEntity<Void> save(@RequestBody ImageDTO imageDTO){
        Image image=mapper.toImage(imageDTO);
        service.save(image);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<ImageDTO> getById(@PathVariable Long id){
        Image image= service.getById(id);
        ImageDTO imageDTO=mapper.toImageDTO(image);
        return  ResponseEntity.ok(imageDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return  ResponseEntity.ok().build();
    }

    @GetMapping(value = "/v1")
    public ResponseEntity<List<ImageDTO>> getAll()
    {
        List<Image> images = service.getAll();
        List<ImageDTO> imageDTOS = mapper.toImageDTOS(images);
        return ResponseEntity.ok(imageDTOS);

    }

    @GetMapping("/v1/getbyhous/{houseId}")
    public ResponseEntity<ImageDTO> getByHouseId(@PathVariable Long houseId ){

        Image image=    service.getByHouseId(houseId);
        ImageDTO imageDTO=mapper.toImageDTO(image);
        return ResponseEntity.ok(imageDTO);
    }


}
