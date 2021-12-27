/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.springfundamental.repository;

import co.id.mii.springfundamental.model.Region;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MSI-JO
 */
@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    Optional<Region> findByName(String name);
    List<Region> findByNameContains(String name);

}
