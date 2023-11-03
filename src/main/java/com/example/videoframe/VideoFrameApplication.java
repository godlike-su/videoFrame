package com.example.videoframe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.videoframe.mapper")
public class VideoFrameApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoFrameApplication.class, args);
    }

}
