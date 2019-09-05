package com.gujun.springboot01.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.gujun.springboot01.beans.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration  //代表这是一个Java配置类，Spring容器会根据它来生成IoC容器来装配Bean;
//有两个配置项：
//1.basePackages，配置一个Java包的数组，Spring会根据其来扫描对应的包和子包；
//2.basePackageClasses，可以配置多个类，Spring会根据这些类所在的包及其子包来扫描；
@ComponentScan(basePackages = {"com.gujun.springboot01.beans"})
@PropertySource(value = {"classpath:user.properties","classpath:game.properties","classpath:car.properties"},ignoreResourceNotFound=true)  //读取属性文件
public class SpringConfig  extends WebMvcConfigurationSupport {

    /*
        fastjson 配置一：
        可以
     */
//    @Bean     //@Bean代表将该方法返回的POJO装配到IoC容器；name属性为Bean的id值，若没设置默认为方法名；
//    public HttpMessageConverters fastJsonHttpMessageConverters(){
//        FastJsonHttpMessageConverter messageConverter=new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig=new FastJsonConfig();
//        //添加fastjson的配置信息
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        messageConverter.setFastJsonConfig(fastJsonConfig);
//        HttpMessageConverter<?> converter=messageConverter;
//        return new HttpMessageConverters(converter);
//    }


    @Bean(name = "game")
    public Game game(@Value("${gameName}") String gameName){
        Game game=new Game();
        game.setName(gameName);
        return game;
    }

    //条件装配Bean:
    //为此Spring提供了@Condition，需要配合Condition接口；

    //在这里继承配置fastjson也行；
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //1、定义一个convert转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2、添加fastjson的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //3、在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //4、将convert添加到converters中
        converters.add(fastConverter);
        //5、追加默认转换器
        super.addDefaultHttpMessageConverters(converters);
    }
}
