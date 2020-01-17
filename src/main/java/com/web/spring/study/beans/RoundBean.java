package com.web.spring.study.beans;


public class RoundBean {
    private double Radius;

    public double getRadius() {
        return Radius;
    }

    public void setRadius(double Radius) {
        this.Radius = Radius;
    }
    
    public double getRundArea(){
        return Radius*Radius*3.14;
    }
    
    
}
