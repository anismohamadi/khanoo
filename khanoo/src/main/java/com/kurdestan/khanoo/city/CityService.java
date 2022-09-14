package com.kurdestan.khanoo.city;

import com.kurdestan.khanoo.common.SearchCriteria;
import com.kurdestan.khanoo.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService implements ICityService {

    private final CityRepository repository;


    @Override
    public City save(City city) {

        return repository.save(city);
    }

    @Override
    public City getById(Long id) {
        Optional<City> optionalCity=repository.findById(id);
        if (!optionalCity.isPresent()){
            throw  new NotFoundException("Not Found City");
        }
        return optionalCity.get();
    }

    @Override
    public List<City> getAll() {
        return (List<City>) repository.findAll();
    }


    @Override
    public Page<City> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<City> search(List<SearchCriteria> searchCriteria) {
        CitySpecification citySpecification= new CitySpecification();
        searchCriteria.forEach(criteria -> citySpecification.add(criteria));
        return repository.findAll(citySpecification);
    }


}
