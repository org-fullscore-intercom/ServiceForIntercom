package com.amazing.intercom.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    @Before
    public void before(){
        mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    public void login() throws Exception {
        // 构造 Get 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("account","yzn")
                        .param("password", "123456");

        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());

    }
    @Test
    public void add() throws Exception {
        // 构造 GET 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/addUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("name","tttest")
                        .param("account", "tttest")
                        .param("password","123123")
                        .param("avatar","http://192.168.31.29:8080/upload/avatar/fav.png");

        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());

    }
    @Test
    public void get() throws Exception {
        // 构造 GET 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/getUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "1");


        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());

    }
    @Test
    public void modify() throws Exception {
        // 构造 POST 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/modifyUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id","2")
                        .param("name","zhangsan")
                        .param("account", "zhangsan")
                        .param("password","123123")
                        .param("avatar","http://192.168.31.29:8080/upload/avatar/fav.png");


        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());

    }
    @Test
    public void delete() throws Exception {
        // 构造 GET 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/deleteUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "5");


        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());

    }

}
