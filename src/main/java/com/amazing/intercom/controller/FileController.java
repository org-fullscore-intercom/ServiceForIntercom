package com.amazing.intercom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@Controller
public class FileController {
    @PostMapping("/upload_avatar")
    @ResponseBody
    public String uploadAvatar(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "文件为空";
            }
            //获取文件名
//            String fileName=file.getOriginalFilename();
            String fileName = System.currentTimeMillis() + ".png";
            System.out.println("上传的文件名：" + fileName);
            //获取文件后缀名
//            String suffixName=fileName.substring(fileName.lastIndexOf("."));
//            System.out.println("文件后缀名："+suffixName);
            //设置文件存储路径

            String filePath = "C:\\Users\\Toreme\\Desktop\\intercom\\upload\\avatar\\";
//            String filePath="/home/upload/avatar/";
            String path = filePath + fileName;
            File dest = new File(path);
            //检测是否存在该目录
            if (!dest.getParentFile().exists()) {
                boolean flag = dest.getParentFile().mkdirs();
            }
            //写入文件
            file.transferTo(dest);
            String res = "http://192.168.31.29:8080/upload/avatar/";
//            String res="http://47.113.221.177:8000/upload/avatar/";
            System.out.println(res + fileName);
            return res + fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    @PostMapping("/upload_sound")
    @ResponseBody
    public String uploadSound(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "文件为空";
            }
            //获取文件名
            String fileName = System.currentTimeMillis() + ".wav";
            System.out.println("将上传的文件名：" + fileName);
            //设置文件存储路径
            String filePath="C:\\Users\\Toreme\\Desktop\\intercom\\upload\\sound\\";
//            String filePath = "/home/upload/sound/";
            String path = filePath + fileName;
            File dest = new File(path);
            //检测是否存在该目录
            if (!dest.getParentFile().exists()) {
                boolean flag = dest.getParentFile().mkdirs();
            }
            //写入文件
            file.transferTo(dest);
            String res="http://192.168.31.29:8080/upload/sound/";
//            String res = "http://47.113.221.177:8000/upload/sound/";
            return res + fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
