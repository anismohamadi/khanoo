package com.kurdestan.khanoo.region;

import com.kurdestan.khanoo.common.BaseEntity;
import com.kurdestan.khanoo.city.City;
import com.kurdestan.khanoo.house.House;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_region")
@Audited
public class Region extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    ////?????????????????????????????????????
    @Column(name = "location")
    private Point<G2D> location;

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<House> houses;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;





}
