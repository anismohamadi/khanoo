package com.kurdestan.khanoo.region;

import com.kurdestan.khanoo.common.SearchCriteria;
import com.kurdestan.khanoo.common.exception.NotFoundException;
import com.kurdestan.khanoo.city.City;
import com.kurdestan.khanoo.city.ICityService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegionService implements IRegionService {


    private final RegionRepository repository;
    private final ICityService service;

    @Override
    public Region save(Region region) {
        Long cityId = region.getCity().getId();
        City city = service.getById(cityId);
        region.setCity(city);
        return repository.save(region);
    }


    @Override
    public Region getById(Long id) {
        Optional<Region> optionalRegion = repository.findById(id);
        if (!optionalRegion.isPresent()) {
            throw new NotFoundException("Not Found Region");
        }
        return optionalRegion.get();
    }

    @Override
    public List<Region> getAll() {
        return (List<Region>) repository.findAll();
    }

    @Override
    public List<Region> getAllByCity(Long cityId) {
        City city=service.getById(cityId);
        List<Region> regions=repository.findAllByCity(city);
        return  regions;
    }

    @Override
    public Page<Region> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<Region> search(List<SearchCriteria> searchCriteria) {
        RegionSpecification regionSpecification = new RegionSpecification();
        searchCriteria.forEach(criteria -> regionSpecification.add(criteria));
        return repository.findAll(regionSpecification);
    }

}
