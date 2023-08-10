package com.city_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "country")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image", nullable = false, length = 2000)
    private String image;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "area", nullable = false)
    private Double area;
    @Column(name = "population", nullable = false)
    private Long population;
    @Column(name = "gdp")
    private Double gdp;
    @Column(name = "description", nullable = false, length = 3000)
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;
}
