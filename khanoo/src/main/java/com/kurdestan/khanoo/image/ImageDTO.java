package com.kurdestan.khanoo.image;

import com.kurdestan.khanoo.common.BaseDTO;
import com.kurdestan.khanoo.house.HouseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class ImageDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String image;


    @ApiModelProperty(required = true, hidden = false)
    private HouseDTO house;
}
