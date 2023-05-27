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
public class RoomRecordControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Before
    public void before(){
        mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    public void history() throws Exception {
        // 构造 Get 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/history")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("r_id", "4");

        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());


    }
    @Test
    public void historyN() throws Exception {
        // 构造 Get 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/historyMans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("r_id", "4");
        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());
    }
    @Test
    public void onlineUs() throws Exception {
        // 构造 Get 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/onlineUsers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("r_id", "4");
        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());

    }
    @Test
    public void onlineN() throws Exception {
        // 构造 Get 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/onlineMans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("r_id", "4");
        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());

    }
    @Test
    public void add() throws Exception {
        // 构造 Get 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/addRoomRecord")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("u_id", "5")
                        .param("r_id","4")
                        .param("state","1");
        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());

    }
    @Test
    public void delete() throws Exception {
        // 构造 Get 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/deleteRoomRecord")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "10");
        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());

    }
    @Test
    public void come() throws Exception {
        // 构造 Get 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/inRoom")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("u_id","4")
                        .param("r_id", "4");
        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());

    }
    @Test
    public void leave() throws Exception {
        // 构造 Get 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/outRoom")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("u_id","4")
                        .param("r_id", "4");
        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());
    }
}
