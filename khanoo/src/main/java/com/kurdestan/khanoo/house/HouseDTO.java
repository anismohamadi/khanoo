package com.kurdestan.khanoo.house;

import com.kurdestan.khanoo.common.BaseDTO;
import com.kurdestan.khanoo.realestate.RealEstateDTO;
import com.kurdestan.khanoo.region.RegionDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HouseDTO extends BaseDTO {


    @ApiModelProperty(required = true, hidden = false)
    private String title;

    @ApiModelProperty(required = false, hidden = false)
    private Integer buildingDate;

    @ApiModelProperty(required = true, hidden = false)
    private String address;

    @ApiModelProperty(required = true, hidden = false)
    private Double metrazh;

    @ApiModelProperty(required = true, hidden = false)
    private Integer tabaqe;

    @ApiModelProperty(required = true, hidden = false)
    private Integer rooms;

    @ApiModelProperty(required = true, hidden = false)
    private Type type;

    @ApiModelProperty(required = false, hidden = false)
    private BigDecimal salePrice;

    @ApiModelProperty(required = false, hidden = false)
    private BigDecimal mortgagePrice;

    @ApiModelProperty(required = false, hidden = false)
    private BigDecimal rentPrice;

    @ApiModelProperty(required = true, hidden = false)
    private HouseType houseType;

    @ApiModelProperty(required = false, hidden = false)
    private PropertyTypeCommercial  PropertyTypeCommercial;

    @ApiModelProperty(required = false, hidden = false)
    private PropertyTypeResidental  PropertyTypeResidental;

    @ApiModelProperty(required = false, hidden = false)
    private NorthOrSouth  northOrSouth;

    @ApiModelProperty(required = false, hidden = false)
    private Boolean parking;

    @ApiModelProperty(required = false, hidden = false)
    private Boolean warehouse;

    @ApiModelProperty(required = false, hidden = false)
    private Boolean balcon;

    @ApiModelProperty(required = false, hidden = false)
    private Boolean CoolingDevice;

    @ApiModelProperty(required = false, hidden = false)
    private Boolean HeatingDevice;

    @ApiModelProperty(required = false, hidden = false)
    private String details;

    @ApiModelProperty(required = true,hidden = false)
    private LocationDTO locationDTO;

    @ApiModelProperty(required = true,hidden = false)
    private RegionDTO region ;

    @ApiModelProperty(required = true, hidden = false)
    private RealEstateDTO realEstate;

}
