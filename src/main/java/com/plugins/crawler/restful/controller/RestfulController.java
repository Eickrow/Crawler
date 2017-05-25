package com.plugins.crawler.restful.controller;

import com.plugins.crawler.restful.service.RestfulService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.plugins.crawler.framework.whois.WhoisConfig.MAIN_REGX;

/**
 * Created by david.yun on 2017/5/24.
 */
@RestController
@RequestMapping("/api/")
public class RestfulController {
    @Autowired
    RestfulService restfulService;

    @ResponseBody
    @RequestMapping(value = "whois")
    public Object whois(HttpServletRequest request) {
        return restfulService.whois(request);
    }
}
