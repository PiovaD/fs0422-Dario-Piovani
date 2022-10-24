package com.dariopiovani.m5w1d1.m5w1d1.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:application.properties"})
public class B {
    @Value("${b.v1}")
    private String v1;

    public String toString() {
        return "B(v1=" + this.v1 + ")";
    }
}
