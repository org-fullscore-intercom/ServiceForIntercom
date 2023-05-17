package com.amazing.intercom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String uploadAvatar(MultipartFile file){
        try {
            if (file.isEmpty()){
                return "文件为空";
            }
            //获取文件名
            String fileName=file.getOriginalFilename();
            System.out.println("上传的文件名："+fileName);
            //获取文件后缀名
            String suffixName=fileName.substring(fileName.lastIndexOf("."));
            System.out.println("文件后缀名："+suffixName);
            //设置文件存储路径
//            String filePath="../../../../resources/static/avatar/";
            String filePath2="C:\\Users\\Toreme\\Desktop\\intercom\\src\\main\\resources\\static\\avatar\\";
            String path=filePath2+fileName;
            File dest=new File(path);
            //检测是否存在该目录
            if (!dest.getParentFile().exists()){
                boolean flag=dest.getParentFile().mkdirs();
            }
            //写入文件
            file.transferTo(dest);
            return "上传成功!";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
    @GetMapping("/download_avatar")
    @ResponseBody
    public String downloadAvatar(HttpServletRequest request, HttpServletResponse response){
        String fileName=request.getParameter("fileName");
        System.out.println("下载文件:"+fileName);
        if (fileName!=null){
            String filePath2="C:\\Users\\Toreme\\Desktop\\intercom\\src\\main\\resources\\static\\avatar\\";
            File file =new File(filePath2+fileName);
            if (file.exists()){
                response.setContentType("application/force-download");
                response.addHeader("Content-Disposition","attachment;fileName="+fileName);
                byte[] buffer=new byte[1024];
                FileInputStream fis =null;
                BufferedInputStream bis = null;
                try{
                    fis=new FileInputStream(file);
                    response.setContentLength(fis.available());
                    bis=new BufferedInputStream(fis);
                    OutputStream os=response.getOutputStream();
                    int i = bis.read(buffer);
                    while(i!=-1){
                        os.write(buffer,0,i);
                        i=bis.read(buffer);
                    }
                    os.flush();
                    os.close();
                    return "下载成功";
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (bis!=null){
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis!=null){
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }
    @PostMapping("/upload_sound")
    @ResponseBody
    public String uploadSound(MultipartFile file){
        try {
            if (file.isEmpty()){
                return "文件为空";
            }
            //获取文件名
            String fileName=System.currentTimeMillis()+".wav";
            System.out.println("将上传的文件名："+fileName);
            //设置文件存储路径
            String filePath="C:\\Users\\Toreme\\Desktop\\intercom\\src\\main\\resources\\static\\sounds\\";
            String path=filePath+fileName;
            File dest=new File(path);
            //检测是否存在该目录
            if (!dest.getParentFile().exists()){
                boolean flag=dest.getParentFile().mkdirs();
            }
            //写入文件
            file.transferTo(dest);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/download_sound")
    @ResponseBody
    public String downloadSound(HttpServletRequest request, HttpServletResponse response){
        String fileName=request.getParameter("fileName");
        System.out.println("下载sound文件:"+fileName);
        if (fileName!=null){
            String filePath="C:\\Users\\Toreme\\Desktop\\intercom\\src\\main\\resources\\static\\sounds\\";
            File file =new File(filePath+fileName);
            if (file.exists()){
                response.setContentType("application/force-download");
                response.addHeader("Content-Disposition","attachment;fileName="+fileName);
                byte[] buffer=new byte[1024];
                FileInputStream fis =null;
                BufferedInputStream bis = null;
                try{
                    fis=new FileInputStream(file);
                    response.setContentLength(fis.available());
                    bis=new BufferedInputStream(fis);
                    OutputStream os=response.getOutputStream();
                    int i = bis.read(buffer);
                    while(i!=-1){
                        os.write(buffer,0,i);
                        i=bis.read(buffer);
                    }
                    os.flush();
                    os.close();
                    return "下载成功";
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (bis!=null){
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis!=null){
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }
}
