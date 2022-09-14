package com.kurdestan.khanoo.city;

import com.kurdestan.khanoo.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CityDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String name;
}
