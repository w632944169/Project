package com.bionime.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebServiceController
{
    @RequestMapping(value="/find",method =  {RequestMethod. POST ,RequestMethod. GET })
    @ResponseBody
    public String WebService()
    {
        return "测试完成";
    }
}
