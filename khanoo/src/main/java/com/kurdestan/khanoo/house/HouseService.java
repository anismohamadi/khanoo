package com.kurdestan.khanoo.house;

import com.kurdestan.khanoo.common.SearchCriteria;
import com.kurdestan.khanoo.common.exception.NotFoundException;
import com.kurdestan.khanoo.realestate.IRealEstateService;
import com.kurdestan.khanoo.realestate.RealEstate;
import com.kurdestan.khanoo.region.IRegionService;
import com.kurdestan.khanoo.region.Region;
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
public class HouseService implements  IHouseService{

    private  final HouseRepository repository;
    private  final IRegionService iRegionService;
    private  final IRealEstateService iRealEstateService;


    @Override
    public House save(House house) {
        //باید پدر این houseرو ست بکنیم
        Long realEstateId=house.getRealEstate().getId();
        Long regionId=house.getRegion().getId();
        //اینجا میخواییم از روی ایدی پدر  تمام دیتاهارو بیاریم باید ابجکت کامل پدر رو ست کنیم روی چایلد
        RealEstate realEstate=iRealEstateService.getById(realEstateId);
        Region region =iRegionService.getById(regionId);
        house.setRealEstate(realEstate);
        house.setRegion(region);
        return repository.save(house);
    }


    @Override
    public void  delete(Long id) {
    getById(id);
        repository.deleteById(id);

    }

    @Override
    public House update(House house) {
        House lastSavedHouse=getById(house.getId());
        lastSavedHouse.setTitle(house.getTitle());
        lastSavedHouse.setRegion(house.getRegion());
        lastSavedHouse.setAddress(house.getAddress());
        lastSavedHouse.setHouseType(house.getHouseType());
        lastSavedHouse.setBalcon(house.getBalcon());
        lastSavedHouse.setBuildingDate(house.getBuildingDate());
        lastSavedHouse.setCoolingDevice(house.getCoolingDevice());
        lastSavedHouse.setHeatingDevice(house.getHeatingDevice());
        lastSavedHouse.setLocation(house.getLocation());
        lastSavedHouse.setMetrazh(house.getMetrazh());
        lastSavedHouse.setDetails(house.getDetails());
        lastSavedHouse.setMortgagePrice(house.getMortgagePrice());
        lastSavedHouse.setParking(house.getParking());
        lastSavedHouse.setRentPrice(house.getRentPrice());
        lastSavedHouse.setRooms(house.getRooms());
        lastSavedHouse.setSalePrice(house.getSalePrice());
        lastSavedHouse.setTabaqe(house.getTabaqe());
        lastSavedHouse.setWarehouse(house.getWarehouse());
        lastSavedHouse.setImages(house.getImages());
        lastSavedHouse.setWarehouse(house.getWarehouse());
        lastSavedHouse.setPropertyTypeCommercial(house.getPropertyTypeCommercial());
        lastSavedHouse.setPropertyTypeResidental(house.getPropertyTypeResidental());
        return  repository.save(lastSavedHouse);

    }

    @Override
    public House getById(Long id) {
        Optional<House> optionalHouse=repository.findById(id);
        if (!optionalHouse.isPresent()){
            throw  new NotFoundException("Not Found House");
        }
        return optionalHouse.get();
    }

    @Override
    public List<House> getAll() {

        return (List<House>) repository.findAll();
    }

    @Override
    public List<House> getAllByRealEstate(Long realEstateId) {
        RealEstate realEstate=iRealEstateService.getById(realEstateId);
        List<House> houses=repository.findAllByRealEstate(realEstate);
        return houses;
    }


    @Override
    public List<House> getAllByRegion(Long regionId) {
        Region region=iRegionService.getById(regionId);
        List<House> houses=repository.findAllByRegion(region);
        return houses;
    }

    @Override
    public List<House> getAllByRegion_City(Long regionId) {
        Region region=iRegionService.getById(regionId);
        List<House> houses=repository.findAllByRegion_City(region);
        return  houses;
    }


    @Override
    public Page<House> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }



    @Override
    public List<House> findNearest(Point<G2D> point, double distance) {
         var x= repository. findAllWithDistance(point);
        return repository.findAllWithDistance(point,distance);
    }

    @Override
    public List<House> search(List<SearchCriteria> searchCriteria) {
        HouseSpecification houseSpecification = new HouseSpecification();
        searchCriteria.forEach(criteria -> houseSpecification.add(criteria));
        return repository.findAll(houseSpecification);
    }


}
