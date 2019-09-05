package com.gujun.springboot01.beans;

import com.gujun.springboot01.beanCondition.CarCondition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component(value = "car")   //value属性即id
@Conditional(CarCondition.class)
public class Car {

    @Value(value = "Benz")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
