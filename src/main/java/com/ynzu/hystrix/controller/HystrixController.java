package com.ynzu.hystrix.controller;

import com.ynzu.hystrix.service.HystrixService;
import com.ynzu.hystrix.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HystrixController {

    private final HystrixService hystrixService;

    @Autowired
    public HystrixController(HystrixService hystrixService) {
        this.hystrixService = hystrixService;
    }

    @RequestMapping(value = "/")
    public ProductVo getProduct() throws Exception {
        return hystrixService.getProduct();
    }


}
