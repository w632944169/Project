package com.bionime.WebService;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

@WebService(serviceName="CommonServiceImpl", targetNamespace="http://WebService.bionime.com/", endpointInterface="com.bionime.WebService.CommonService")
@Component
public class CommonServiceImpl
        implements CommonService
{
    public String HelloWorld(String name)
    {
        return "Hello World!!! --->" + name;
    }

    public String HelloName(String name)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date date = new Date();
        String dateStr = simpleDateFormat.format(date);
//        DemoService Demo=new DemoServiceImpl();
//        Demo.sayHello("你是谁");
        System.out.println(dateStr);
        return "当前系统时间是" + dateStr;
    }
}
