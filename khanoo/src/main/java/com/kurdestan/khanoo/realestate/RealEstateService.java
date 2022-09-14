package com.kurdestan.khanoo.realestate;

import com.kurdestan.khanoo.common.SearchCriteria;
import com.kurdestan.khanoo.common.exception.NotFoundException;


import lombok.AllArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RealEstateService implements IRealEstateService {

    private final RealEstateRepository repository;

    @Override
    public RealEstate save(RealEstate realEstate) {

        return repository.save(realEstate);
    }

    @Override
    public RealEstate update(RealEstate realEstate) {
        RealEstate lastSavedRealEstate=getById(realEstate.getId());
        lastSavedRealEstate.setOwnerName(realEstate.getOwnerName());
        lastSavedRealEstate.setPhone(realEstate.getPhone());
        lastSavedRealEstate.setLocation(realEstate.getLocation());
        lastSavedRealEstate.setAddress(realEstate.getAddress());
        lastSavedRealEstate.setRealEstateName(realEstate.getRealEstateName());
        return repository.save(lastSavedRealEstate);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }


    @Override
    public RealEstate getById(Long id) {
        Optional<RealEstate> optionalRealEstate = repository.findById(id);
        if (!optionalRealEstate.isPresent()) {
            throw new NotFoundException("Not Found RealEstate");
        }
        return optionalRealEstate.get();
    }


    @Override
    public List<RealEstate> findNearest(Point<G2D> point, double distance) {
        var x= repository. findAllWithDistance(point);
        return repository.findAllWithDistance(point,distance);
    }

    @Override
    public List<RealEstate> getAll() {
        return (List<RealEstate>) repository.findAll();
    }

    @Override
    public Page<RealEstate> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }


    @Override
    public List<RealEstate> search(List<SearchCriteria> searchCriteria) {
        RealEstateSpecification realEstateSpecification = new RealEstateSpecification();
        searchCriteria.forEach(criteria -> realEstateSpecification.add(criteria));
        return repository.findAll(realEstateSpecification);
    }


}
