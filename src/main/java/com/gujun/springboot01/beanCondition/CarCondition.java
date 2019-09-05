package com.gujun.springboot01.beanCondition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CarCondition implements Condition {
    @Override
    //方法两个参数，第一个可以获得Spring运行环境，第二个获得该Bean的注解信息；
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment=conditionContext.getEnvironment();
        System.out.println(environment.getProperty("hasCar"));
        return environment.containsProperty("hasCar");
    }
}
