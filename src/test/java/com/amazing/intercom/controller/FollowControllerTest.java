package com.amazing.intercom.controller;

import com.amazing.intercom.service.FollowService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    public void add() throws Exception {

        // 构造 GET 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/addFollow")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("u_id", "1")
                        .param("f_u_id","6");


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
                MockMvcRequestBuilders.get("/deleteFollow")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("u_id", "1")
                        .param("f_u_id","5");


        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());
    }
    @Test
    public void follows() throws Exception {
        // 构造 GET 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/follows")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("u_id", "6");


        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());

}
    @Test
    public void fans() throws Exception {
        // 构造 GET 请求
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/fans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("f_u_id", "2");


        // 发送请求并验证返回结果
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(result.getResponse().getStatus()+" -- "+result.getResponse().getContentAsString());

    }
}
