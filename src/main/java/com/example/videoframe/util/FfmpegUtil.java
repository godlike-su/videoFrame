package com.example.videoframe.util;

//import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: `sujinwang`
 * @Date: `2023/10/29 18:56`
 * @Version: 1.0
 * @Description:
 */
public class FfmpegUtil {

    /**
     * 简易视频处理 -- （cmd(windows): ffmpeg.exe -i test1.mp4 newVideo.avi）
     *
     * @param ffmpegPath      ffmpeg.exe文件路径，可在rest或者admin中进行配置，使用配置文件进行读取
     * @param videoInputPath  视频文件路径（输入）
     * @param videoOutputPath 转换完成的文件路径（输出）
     * @throws IOException
     */
    public static void videoConvert(String ffmpegPath, String videoInputPath, String videoOutputPath) throws IOException {
        // 构建命令
//        List<String> command = Lists.newArrayList();
        List<String> command = new ArrayList<>();
        command.add(ffmpegPath);
        command.add("-i");
        command.add(videoInputPath);
        command.add(videoOutputPath);
        // 执行操作
        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = builder.start();
        InputStream errorStream = process.getErrorStream();
        InputStreamReader isr = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
        }
        if (br != null) {
            br.close();
        }
        if (isr != null) {
            isr.close();
        }
        if (errorStream != null) {
            errorStream.close();
        }
    }

    /**
     * 获取第一秒第一帧的缩略图 -- （cmd(windows): ffmpeg.exe -ss 00:00:01 -y -i test1.mp4 -vframes 1 new.jpg）
     *
     * @param ffmpegPath      ffmpeg.exe文件路径，可在rest或者admin中进行配置，使用配置文件进行读取
     * @param videoInputPath  视频文件路径（输入）
     * @param coverOutputPath 缩略图输出路径
     * @throws IOException
     */
    public static void getVideoCover(String ffmpegPath, String videoInputPath, String coverOutputPath) throws IOException {
        // 构建命令
//        List<String> command = Lists.newArrayList();
        List<String> command = new ArrayList<>();
        command.add(ffmpegPath);
        command.add("-ss");
        command.add("00:00:01");
        command.add("-y");
        command.add("-i");
        command.add(videoInputPath);
        command.add("-vframes");
        command.add("1");
        command.add(coverOutputPath);
        // 执行操作
        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = builder.start();
        InputStream errorStream = process.getErrorStream();
        InputStreamReader isr = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
        }
        if (br != null) {
            br.close();
        }
        if (isr != null) {
            isr.close();
        }
        if (errorStream != null) {
            errorStream.close();
        }
    }

    public static void getVideoCover2(String ffmpegPath, String videoInputPath, String coverOutputPath
            , String accuracy) throws IOException {
        // 构建命令
        // fmpeg -i 247_1698172122.mp4 -r 3 -f image2 image-%3d.jpeg
        List<String> command = new ArrayList<>();
        command.add(ffmpegPath);
        command.add("-i");
        command.add(videoInputPath);
        command.add("-r");
        command.add(accuracy);
        command.add("-f");
        command.add("image2");
        command.add(coverOutputPath);
        // 执行操作
        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = builder.start();
        InputStream errorStream = process.getErrorStream();
        InputStreamReader isr = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
        }
        if (br != null) {
            br.close();
        }
        if (isr != null) {
            isr.close();
        }
        if (errorStream != null) {
            errorStream.close();
        }
    }

}
