package com.lshao.demo.web;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;

/**
 * jackson的转换器
 * 可起到的作用是：避免非空，统一时间转换，和全string值，并且防hibernate递归解析
 * @author lish [254174981@qq.com]
 * @date 17-12-2
 */
public class StringJacksonMapper extends ObjectMapper {

    public StringJacksonMapper() {
        super();

        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Byte.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Char.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Short.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Integer.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Float.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Double.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Boolean.class, ToStringSerializer.instance);
        simpleModule.addSerializer(BigDecimal.class, ToStringSerializer.instance);
        simpleModule.addSerializer(BigInteger.class, ToStringSerializer.instance);

        this.registerModule(simpleModule);
        this.registerModule(new Hibernate5Module());
    }

}
