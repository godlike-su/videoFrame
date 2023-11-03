package com.example.videoframe.entity;

import com.example.videoframe.webreturn.pagination.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value="com.example.videoframe.entity.Userinfo")
@Data
public class Userinfo extends PageParam {
    @ApiModelProperty(value="id")
    private Integer id;

    @ApiModelProperty(value="name名称")
    private String name;

    @ApiModelProperty(value="createtime创建时间")
    private Date createtime;

    @ApiModelProperty(value="updatetime修改时间")
    private Date updatetime;
}