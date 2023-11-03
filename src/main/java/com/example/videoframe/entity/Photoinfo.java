package com.example.videoframe.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="com.example.videoframe.entity.Photoinfo")
@Data
public class Photoinfo {
    @ApiModelProperty(value="id")
    private Integer id;

    @ApiModelProperty(value="videoinfoid")
    private Integer videoinfoid;

    @ApiModelProperty(value="name")
    private String name;

    @ApiModelProperty(value="attachGroupId")
    private String attachGroupId;

    private String url;

}