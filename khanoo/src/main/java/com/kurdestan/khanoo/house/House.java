package com.kurdestan.khanoo.house;

import com.kurdestan.khanoo.common.BaseEntity;
import com.kurdestan.khanoo.image.Image;
import com.kurdestan.khanoo.realestate.RealEstate;
import com.kurdestan.khanoo.region.Region;
import com.sun.istack.NotNull;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.List;


@Data
@Entity
@Table(name = "tbl_house")
@Audited

public class House extends BaseEntity {


    @NotNull
    @Column(name = "title")
    private String title;


    @Column(name = "building_date")
    private Integer buildingDate;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "metrazh")
    private Double metrazh;

    @NotNull
    @Column(name = "tabaqe")
    private Integer tabaqe;

    @NotNull
    @Column(name = "rooms")
    private Integer rooms;

    @NotNull
    @Column(name = "type")
    @Enumerated
    private Type type;

    @NotNull
    @Column(name = "house_type")
    @Enumerated
    private HouseType houseType;

    @NotNull
    @Column(name = "north_or_south ")
    @Enumerated
    private NorthOrSouth  northOrSouth;

    @NotNull
    @Column(name = "property_type_commercial ")
    @Enumerated
    private PropertyTypeCommercial  PropertyTypeCommercial;

    @NotNull
    @Column(name = "property_type_residental ")
    @Enumerated
    private PropertyTypeResidental  PropertyTypeResidental;

    @NotNull
    @Column(name = "sale_price")
    private BigDecimal salePrice;


    @NotNull
    @Column(name = "mortgage_price")
    private BigDecimal mortgagePrice;

    @NotNull
    @Column(name = "rent_price")
    private BigDecimal rentPrice;


    @NotNull
    @Column(name = "has_parking")
    private Boolean parking;

    @NotNull
    @Column(name = "has_warehouse")
    private Boolean warehouse;

    @NotNull
    @Column(name = "has_balcony")
    private Boolean balcon;

    @NotNull
    @Column(name = "has_cooling_device")
    private Boolean coolingDevice;

    @NotNull
    @Column(name = "has_heating_device")
    private Boolean heatingDevice;

    @NotNull
    @Column(name = "details")
    private String details;

    @Column(name = "location")
    private Point<G2D> location;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "region_id", unique = true)
    private Region region;

    @ManyToOne
    @JoinColumn(name = "real_estate_id", unique = true)
    private RealEstate realEstate;


}
