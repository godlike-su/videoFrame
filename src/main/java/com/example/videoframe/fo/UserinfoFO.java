package com.example.videoframe.fo;

import com.example.videoframe.webreturn.pagination.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import java.util.Date;

@Tag(name = "用户目录类")
@Data
public class UserinfoFO extends PageParam {
    @Schema()
    private Integer id;

//    @Schema(name="name名称")
    private String name;

//    @Schema(name="createtime创建时间")
    private Date createtime;

//    @Schema(name="updatetime修改时间")
    private Date updatetime;
}