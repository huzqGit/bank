package com.bank.controller.base;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseController {
	private static Logger log = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler
    public String exception(HttpServletRequest request, Exception e) {  
          
        request.setAttribute("exceptionMessage", e.getMessage());  
          
        return "error";  
    }  
    
}