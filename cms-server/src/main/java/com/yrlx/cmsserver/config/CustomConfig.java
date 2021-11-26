package com.yrlx.cmsserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/*
本方法是实现 WebMvcConfigurer 接口，重载configureMessageConverters方法
注意：
1.由于是list，add加入，fastjson放在最后，需要删除jackson对应的转换器
2.在extendMessageConverters中可以打印支持哪些转换器，这个很关键和重要
 */

@Configuration
public class CustomConfig implements WebMvcConfigurer {

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//        Iterator<HttpMessageConverter<?>> iterator = converters.iterator();
//        while (iterator.hasNext()){
//            if (iterator.next() instanceof MappingJackson2HttpMessageConverter){
//                iterator.remove();
//            }
//        }
//
//        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.PrettyFormat,
//                SerializerFeature.WriteNullStringAsEmpty,
//                SerializerFeature.DisableCircularReferenceDetect,
//                SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteNullBooleanAsFalse
//        );
//
//        fastJsonConverter.setFastJsonConfig(fastJsonConfig);
//
//        List<MediaType> supportedMediaTypes = new ArrayList<>();
//        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
//        fastJsonConverter.setSupportedMediaTypes(supportedMediaTypes);
//
//        converters.add(fastJsonConverter);
//    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> messageConverter: converters) {
            System.out.println(messageConverter);
        }
    }
}
