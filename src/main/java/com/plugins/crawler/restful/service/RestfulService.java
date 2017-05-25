package com.plugins.crawler.restful.service;

import com.plugins.crawler.framework.whois.ParsedWhoisResponse;
import com.plugins.crawler.framework.whois.WhoisResponse;
import com.plugins.crawler.utils.StringUtils;
import org.apache.commons.net.whois.WhoisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.plugins.crawler.framework.whois.WhoisConfig.MAIN_REGX;

/**
 * Created by david.yun on 2017/5/24.
 */
@Service
public class RestfulService {

    public final int PREFIX_CODE = 100;
    private final DateTimeFormatter TimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Autowired
    MessageSource messageSource;

    @Resource(name = "whois")
    Map<String, String> WHOIS;

    /**
     * 一key对多value逗号分隔
     */
    public Map<String, Object> convertRequestParameter(HttpServletRequest request) {
        HashMap<String, Object> param = new HashMap<>();
        Map<String, String[]> requestParam = request.getParameterMap();
        requestParam.keySet().forEach(key -> {
            String value = Arrays.asList(requestParam.get(key)).stream().collect(Collectors.joining(","));
            param.put(key.trim(), value);
        });
        return param;
    }

    public Map<String, Object> generateCodeMap(HttpServletRequest request, String code) {
        return generateCodeMap(request, code, null);
    }

    public Map<String, Object> generateCodeMap(HttpServletRequest request, String code, Object data) {
        Map<String, Object> codeMap = new HashMap<>();
        codeMap.put("code", code);
        codeMap.put("uri", request.getRequestURI());
        codeMap.put("message", messageSource.getMessage(code, null, RequestContextUtils.getLocale(request)));
        codeMap.put("time", LocalDateTime.now().format(TimeFormat));
        codeMap.put("data", data);
        return codeMap;
    }

    public Object whois(HttpServletRequest request) {
        Map<String, Object> params = convertRequestParameter(request);
        String domain = StringUtils.nvl(params.get("domain"));
        if ("".equals(domain))
            return generateCodeMap(request, PREFIX_CODE + "001");
        String domain_main = null;
        Pattern pattern = Pattern.compile(MAIN_REGX);
        Matcher matcher = pattern.matcher(domain);
        while (matcher.find()) {
            domain_main = matcher.group();
            break;
        }
        if ("".equals(StringUtils.nvl(domain_main)))
            return generateCodeMap(request, PREFIX_CODE + "002");
        Map<String, Object> dataMap = new HashMap<>();
        String finalDomain_main = domain_main;
        WHOIS.keySet().parallelStream().forEach(key -> {
            if (domain.endsWith(key)) {
                WhoisClient whois = new WhoisClient();
                try {
                    whois.connect(WHOIS.get(key));
                    String whoisData = whois.query(finalDomain_main);
                    dataMap.put("whois", ParsedWhoisResponse.parse(whoisData));
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        whois.disconnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return generateCodeMap(request, "0", dataMap);
    }

//    private Map<String, Object> parseWhois(String whois) {
//        Map<String, Object> whoisMap = new HashMap<>();
//        List<String> lines = Arrays.asList(whois.split("\r\n"));
//        WhoisResponse whoisResponse = new WhoisResponse();
//        lines.stream().forEach(line -> {
//            try {
//                ParsedWhoisResponse.parseContact(line, whoisResponse);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        });
//        whoisMap.put("test", whoisResponse);
//        return whoisMap;
//    }


}
