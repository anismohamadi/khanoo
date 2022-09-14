package com.kurdestan.khanoo.realestate;

import com.kurdestan.khanoo.common.BaseEntity;
import com.kurdestan.khanoo.house.House;
import com.sun.istack.NotNull;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_real_estate")
@Audited
@Data
public class RealEstate extends BaseEntity {

    @NotNull
    @Column(name = "real_estate_name")
    private  String realEstateName;

    @NotNull
    @Column(name = "owner_name")
    private  String ownerName;

    @NotNull
    @Column(name = "phone")
    private  String phone;

    @NotNull
    @Column(name = "address")
    private  String address;

    @Column(name = "location")
    private Point<G2D> location;

    @NotNull
    @Column(name = "logo")
    private  String logo;

    @OneToMany(mappedBy = "realEstate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<House> houses;

}
