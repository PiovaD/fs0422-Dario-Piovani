package com.dariopiovani.m5w1d1.m5w1d1.components;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    @Autowired
    private B b;
    @Autowired
    private C d;

    public String toString() {
        return "A(b=" + this.b + ", c=" + this.d + ")";
    }
}
