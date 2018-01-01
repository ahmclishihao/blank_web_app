package com.lshao.demo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * web app入口
 * @author lish [254174981@qq.com]
 * @date 17-12-3
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"","/","/index"})
    public String indexPage(){

        return "/index";
    }

}
