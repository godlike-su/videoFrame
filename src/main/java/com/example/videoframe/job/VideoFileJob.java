package com.example.videoframe.job;

import com.example.videoframe.service.PhotoInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: `sujinwang`
 * @Date: `2023/11/2 15:41`
 * @Version: 1.0
 * @Description:
 */
@Component
@Slf4j
@EnableScheduling
public class VideoFileJob {

    @Autowired
    private PhotoInfoService photoInfoService;

    @Scheduled(fixedDelay = 60000)
    //@Scheduled(cron="0/5****")
    public void executeJob() {
        log.info("VideoFileJob视频分解定时任务启动!");
        photoInfoService.splitVideo();
    }

}
