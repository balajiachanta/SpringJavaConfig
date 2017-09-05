package com.bala.rest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GreetController {
    @RequestMapping(path= "/greet",method=RequestMethod.GET)    
    public String greet(){
        
    	return "{\"success\":\"true\"}";
    }
}