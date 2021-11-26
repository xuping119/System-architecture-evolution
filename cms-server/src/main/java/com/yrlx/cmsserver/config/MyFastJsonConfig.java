package com.yrlx.cmsserver.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/*
本方法是注入 bean 的方式，
注意：
在WebMvcConfigurer接口的extendMessageConverters中可以打印支持哪些转换器，这个很关键和重要
本方案最后保留了jackson，但是fastjson排在最前面，优先匹配（list结构）
 */

@Configuration
public class MyFastJsonConfig {

    @Bean
    public HttpMessageConverters customConverters(){
        List<HttpMessageConverters> converters = new ArrayList<>();

        // 1、需要先定义一个convert转换消息的对象；
        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
        // 2、添加fastjson的配置信息，比如 是否要格式化返回json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect
        );
        // 3、在convert中添加配置信息.
        fastJsonConverter.setFastJsonConfig(fastJsonConfig);
       // 4、将convert添加到converters当中.
       HttpMessageConverter<?> converter = fastJsonConverter;

        return new HttpMessageConverters(converter);
    }
}
