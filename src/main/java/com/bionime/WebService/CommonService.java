package com.bionime.WebService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name="CommonService", targetNamespace="http://WebService.bionime.com/")
public abstract interface CommonService
{
    @WebMethod
    @WebResult(name="String")
    public abstract String HelloWorld(@WebParam(name="HelloName") String paramString);

    @WebMethod
    @WebResult(name="String")
    public abstract String HelloName(@WebParam(name="Name") String paramString);
}
