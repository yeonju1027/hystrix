package com.ynzu.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ynzu.hystrix.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class HystrixService {

    //1.3초안에 메소드가 끝나지 않을 경우 sampleProduct 메소드 실행, 2.10초 동안 10번 호출 중 30% 실패할 경우 10초동안 sampleProduct 메소드를 실행
    @HystrixCommand(commandKey = "product", fallbackMethod = "sampleProduct", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"), //해당 시간 동안 메서드가 끝나지 않으면 circuit open
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"), //circuit open 조건 - 해당 시간 동안
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30"), //circuit open 조건 - 해당 에러 퍼센트만큼 실패시 오픈
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //circuit open 조건 - 최소 판단 하기 위해 해당 요청 건수만큼 들어와야 한다.
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000") //circuit open 지속 될 시간
    })
    public ProductVo getProduct() throws Exception {

        //1.3초안에 메소드가 끝나지 않을 경우 sampleProduct 메소드 실행,
        /*try{
            Thread.sleep(5000);
        }catch (Exception e){
            log.error("Exception!!");
        }*/

        //2.10초 동안 10번 호출 중 30% 실패할 경우 10초동안 sampleProduct 메소드를 실행
        /*int num = (int)(Math.random() * 100);
        log.debug("num : "+num);
        if(num%2 != 0){
            throw new Exception("Exception!!");
        }*/

        ProductVo productVo = new ProductVo();
        productVo.setProductId("p1");
        productVo.setProductName("p1Name");
        return productVo;
    }

    public ProductVo sampleProduct(){
        ProductVo productVo = new ProductVo();
        productVo.setProductId("s1");
        productVo.setProductName("s1Name");
        return productVo;
    }

}
