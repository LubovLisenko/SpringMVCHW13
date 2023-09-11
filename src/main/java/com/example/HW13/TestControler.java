package com.example.HW13;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Controller
//public class TestControler {
//
//    @RequestMapping(method = RequestMethod.GET, value = "/test")
//    public ModelAndView getHelloWorld(){
//        ModelAndView result = new ModelAndView("test");
//        result.addObject("test", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
//
//        return result;
//
//    }
//}
