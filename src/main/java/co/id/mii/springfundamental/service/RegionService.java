/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.springfundamental.service;

import co.id.mii.springfundamental.model.Region;
import co.id.mii.springfundamental.repository.RegionRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author MSI-JO
 */
@Service
@Slf4j
public class RegionService {

    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAll() {
        log.info(regionRepository.findByNameContains("as").toString());
        return regionRepository.findAll().stream().sorted(Comparator.comparingLong(Region::getId)).collect(Collectors.toList());
    }

    public Region getById(Long id) {
//        if (!regionRepository.findById(id).isPresent()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Region Not Found");
//        }
        
        System.out.println(regionRepository.getById(id).getName());
        
        return regionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Region Not Found"));
   
    }

    public Region create(Region region) {
        if (region.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Region already exist");
        }

        if (regionRepository.findByName(region.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Region name has already exist");
        }
        return regionRepository.save(region);
    }

    public Region update(Long id, Region region) {
        getById(id);
        region.setId(id);
        return regionRepository.save(region);
    }

    public Region delete(Long id) {
        Region region = getById(id);
        regionRepository.deleteById(id);
        return region;
    }
}
