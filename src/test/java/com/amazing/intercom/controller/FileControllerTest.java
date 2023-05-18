package com.amazing.intercom.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FileController.class)
public class FileControllerTest {
    @Autowired
    private FileController fc;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void uploadAvatar() throws Exception {
        // 创建 Mock 文件
        MockMultipartFile file =
                new MockMultipartFile(
                        "file",
                        "test.jpg",
                        MediaType.IMAGE_JPEG_VALUE,
                        "test data".getBytes());

        // 构造 POST 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.fileUpload("/upload_avatar")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .flashAttr("file",file);


        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void downloadAvatar() throws Exception {
        MockHttpServletRequest request=new MockHttpServletRequest();
        request.setMethod("GET");
        request.setRequestURI("/download_avatar");
        request.setParameter("fileName","fav.png");
        MockHttpServletResponse response=new MockHttpServletResponse();
        System.out.println(fc.downloadAvatar(request,response));
        mockMvc.perform(MockMvcRequestBuilders.get("/download_avatar")
                .param("fileName","fav.png")
                .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void uploadSound(){
//        MultipartFile file = (MultipartFile) new File("C:\\Users\\Toreme\\Downloads\\1684315126643.wav");
//        System.out.println(fc.uploadSound(file));
    }
    @Test
    public void downloadSound(){
        MockHttpServletRequest request=new MockHttpServletRequest();
        request.setMethod("GET");
        request.setRequestURI("/download_avatar");
        request.setParameter("fileName","1684315126643.wav");
        MockHttpServletResponse response=new MockHttpServletResponse();
        System.out.println(fc.downloadAvatar(request,response));
    }
}
