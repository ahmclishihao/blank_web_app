package com.lshao.demo.contoller;

import com.lshao.demo.domain.DbUser;
import com.lshao.demo.dto.ReturnBean;
import com.lshao.demo.service.DbUserService;
import com.lshao.demo.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器 -- 用户管理
 * @author lish [254174981@qq.com]
 * @date 17-12-3
 */
@Controller
@RequestMapping("/user")
public class DbUserController {

    private static final Logger logger = LoggerFactory.getLogger(DbUserController.class);

    @Autowired
    private DbUserService dbUserService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class,new StringTrimmerEditor(true));
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
    public Object getUser(@PathVariable("id") Integer id){
        DbUser byId = dbUserService.getById(id);

        if(byId != null){
            return ReturnBean.ok(byId);
        }else{
            return ReturnBean.ok(null).message("未查询到用户");
        }
    }

    @RequestMapping("/test")
    @ResponseBody
    public Object getTest(DbUser test){

        ValidateUtil.newInstance()
                .check("id",() -> test.getId()!=null,"id不能为空")
                .notBlank("name",test.getName(),"姓名不能为空")
                .notBlank("username",test.getUsername(),"用户名不能为空")
                .notBlank("password","123","密码不能为空")
                .validate();

        return test;
    }

}
