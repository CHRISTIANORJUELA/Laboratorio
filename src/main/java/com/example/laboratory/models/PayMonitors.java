package com.example.laboratory.models;

public class PayMonitors {
    private String nameMonitor;
    private double pay;

    public PayMonitors(String nameMonitor, double pay) {
        this.nameMonitor = nameMonitor;
        this.pay = pay;
    }

    public String getNameMonitor() {
        return nameMonitor;
    }

    public void setNameMonitor(String nameMonitor) {
        this.nameMonitor = nameMonitor;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
}
