package com.test.epi.controller;

import com.test.epi.commons.RequestData;
//import lombok.extern.log4j.Log4j;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
//import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Appender;

@Log4j2
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public ModelAndView execute(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap model){
        model.addAttribute("greeting","Welcome to spring web mvc");
        return "index";
    }

    @RequestMapping(value = "/helloJson", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public RequestData helloJson(HttpEntity<String> entity, HttpServletRequest inpreq, HttpServletResponse inpres, @RequestParam Map<String, String> params) throws JsonProcessingException {
        //api
        System.out.println(org.apache.logging.log4j.Logger.class.getResource("/org/ap‌​ache/logging/log4j/Logger.class"));
        //core
        System.out.println(org.apache.logging.log4j.Logger.class.getResource("/org/ap‌​ache/logging/log4j/core/Appender.class"));
        //config
        System.out.println(org.apache.logging.log4j.Logger.class.getResource("/log4j2.xml"));
        log.info("Input => {} / {} % {}",inpreq.getMethod(),inpreq.getServletPath(), params);
        //System.out.println("Input out => " +inpreq.getMethod()+ " " +inpreq.getServletPath()+ " " +params);
        RequestData dn = new RequestData();
        dn.setName(params.get("name"));
        dn.setTeam(params.get("team"));
        dn.setIsOrange(Boolean.parseBoolean(params.get("isOrange")));
        return dn;
    }
}
