package com.example.videoframe.fo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value="com.example.videoframe.entity.Videoinfo")
@Data
public class VideoinfoFO {
    @ApiModelProperty(value="id")
    private Integer id;

    @ApiModelProperty(value="name视频名称")
    private String name;

    @ApiModelProperty(value="describe描述信息")
    private String descri;

    @ApiModelProperty(value="attachgroupid文件id")
    private String attachgroupid;

    @ApiModelProperty(value="userinfoid")
    private Integer userinfoid;

    @ApiModelProperty(value="createtime创建时间")
    private Date createtime;

    @ApiModelProperty(value="status视频是否已经处理")
    private String status;
}