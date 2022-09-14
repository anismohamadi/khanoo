package com.kurdestan.khanoo.region;

import com.kurdestan.khanoo.common.BaseDTO;
import com.kurdestan.khanoo.city.CityDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

@Data
public class RegionDTO  extends BaseDTO {


    @ApiModelProperty(required = true, hidden = false)
    private String name;


    ////?????????????????????????????????????/
   @ApiModelProperty(required = true, hidden = false)
    private Point<G2D> location;

    @ApiModelProperty(required = true, hidden = false)
    private CityDTO city;


}
