package com.example.videoframe.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value="com.example.videoframe.entity.Fileupload")
@Data
public class Fileupload {
    @ApiModelProperty(value="id自增，无业务意义")
    private Integer id;

    @ApiModelProperty(value="attachGroupId文件id")
    private String attachGroupId;

    @ApiModelProperty(value="name原文件名称")
    private String name;

    @ApiModelProperty(value="url保存地址")
    private String url;

    @ApiModelProperty(value="createtime放入时间")
    private Date createtime;

    @ApiModelProperty(value="profilx文件类型")
    private String profilx;

    @ApiModelProperty(value="type 文件类型")
    private String type;
}