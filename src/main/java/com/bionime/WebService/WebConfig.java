package com.bionime.WebService;

import java.util.List;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@WebService
public class WebConfig
{
    @Autowired
    private Bus bus;
    @Autowired
    CommonService service;

    @Bean
    public Endpoint endpoint()
    {
        EndpointImpl endpoint = new EndpointImpl(this.bus, this.service);
        endpoint.publish("/CommonService");

        endpoint.getInInterceptors().add(new LoggingInInterceptor());

        endpoint.getOutInterceptors().add(new LoggingOutInterceptor());

        return endpoint;
    }
}
