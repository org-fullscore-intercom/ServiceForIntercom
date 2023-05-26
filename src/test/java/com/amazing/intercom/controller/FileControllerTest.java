package com.amazing.intercom.controller;

import org.junit.Before;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@WebMvcTest(FileController.class)
@SpringBootTest
public class FileControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    @Before
    public void before(){
        mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }

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
    public void uploadSound() throws Exception {
        // 创建 Mock 文件
        MockMultipartFile file =
                new MockMultipartFile(
                        "file",
                        "test.wav",
                        MediaType.IMAGE_PNG_VALUE,
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
}
