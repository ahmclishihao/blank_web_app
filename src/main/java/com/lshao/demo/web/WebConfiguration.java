package com.lshao.demo.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * 使用java bean进行更多配置
 *
 * @author lish [254174981@qq.com]
 * @date 17-12-3
 */
@Configuration
public class WebConfiguration {

    @Bean
    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter(StringJacksonMapper stringJacksonMapper){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(stringJacksonMapper);
        return converter;
    }

    @Bean
    public StringJacksonMapper getStringJacksonMapper(){
        return new StringJacksonMapper();
    }

}
