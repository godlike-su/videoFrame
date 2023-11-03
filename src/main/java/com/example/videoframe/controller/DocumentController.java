package com.example.videoframe.controller;

import com.example.videoframe.service.DocumentService;
import com.example.videoframe.webreturn.result.BaseResult;
import com.example.videoframe.webreturn.result.MessageResult;
import com.example.videoframe.webreturn.result.ReturnStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author: `sujinwang`
 * @Date: `2022/3/3 14:12`
 * @Version: 1.0
 * @Description:
 */
@RestController
@Tag(name = "文件操作")
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/uploadVideoFile")
    @Operation(summary = "视频文件上传,默认路径")
    public MessageResult uploadVideoFile(MultipartFile file) {
        String attachGroupId = documentService.uploadVideoFile(file);
        return new MessageResult(attachGroupId);
    }

    @PostMapping("/uploadFileType")
    @Operation(summary = "文件上传,设置图片用途")
//    @Parameters({
//            @Parameter(name = "used", description = "文件使用用途 0:头像  1:文章", required = true)
//    })
    public MessageResult uploadFileType(@RequestParam("file") MultipartFile file
            , @RequestParam String used) {
        String attachGroupId = documentService.uploadPhotoFile(file, used);
        return new MessageResult(attachGroupId);
    }

    @GetMapping("/downloadFile")
    @Operation(summary = "文件下载，以文件的形式下载")
    public void downloadFile(@RequestParam("attachGroupId") String attachGroupId
            , HttpServletResponse response) {
        documentService.downloadFile(attachGroupId, response);
    }

    @GetMapping("/downloadFileByImage")
    @Operation(summary = "文件下载，以图片形式显示")
    public void downloadFileByImage(String attachGroupId
            , HttpServletResponse response) {
        documentService.downloadFileByImage(attachGroupId, response);
    }


    @PostMapping("/clearFile")
    @Operation(summary = "删除文件")
    public BaseResult cleardFile() {
//        documentService.cleardFile(fo);
        return new BaseResult(ReturnStatus.STATUS_OK, "删除文件成功");
    }

}
