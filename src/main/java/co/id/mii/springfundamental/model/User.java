/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.springfundamental.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author MSI-JO
 */
@Entity
@Table(name = "tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    @Column(name = "id")
    private Long id;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Employee employee;
    
    @Column(unique = true, nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    private Boolean isAccountLocked;
    
}
