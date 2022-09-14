package com.kurdestan.khanoo.realestate;

import com.kurdestan.khanoo.common.BaseDTO;
import com.kurdestan.khanoo.realestate.LocationDTO;
import com.kurdestan.khanoo.region.RegionDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class RealEstateDTO extends BaseDTO {


    @ApiModelProperty(required = true, hidden = false)
    private String realEstateName;

    @ApiModelProperty(required = true, hidden = false)
    private String ownerName;

    @ApiModelProperty(required = true, hidden = false)
    private String phone;

    @ApiModelProperty(required = true, hidden = false)
    private String address;

    @ApiModelProperty(required = true, hidden = false)
    private LocationDTO locationDTO;

    @ApiModelProperty(required = true, hidden = false)
    private String logo;



}
