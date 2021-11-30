/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.springfundamental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author MSI-JO
 */
@Entity
@Table(name = "tb_country")
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "country_code" ,unique = true, nullable = false)
    private String code;
    
    @Column(name = "country_name", nullable = false)
    private String name;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Region region;

    public Country(Long id, String code, String name, Region region) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.region = region;
    }

    public Country() {
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    
    
    
}
