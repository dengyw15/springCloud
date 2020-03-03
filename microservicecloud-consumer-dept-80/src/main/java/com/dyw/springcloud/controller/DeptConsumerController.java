package com.dyw.springcloud.controller;

import com.dyw.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.net.www.protocol.file.FileURLConnection;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@RestController
@RequestMapping("consumer/dept")
public class DeptConsumerController {

    public static final String URL_PREFIX = "http://localhost:8001/";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("get/{id}")
    public Dept getDeptById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(URL_PREFIX + "dept/get/" + id, Dept.class);
    }
}
