package com.example.laboratory.models;

import java.time.LocalDate;

public class FinishLoan extends Loan{
    private LocalDate finishTime;
    private double price;

    private int days;

    public FinishLoan(Object nameManager, Object namePerson,String nameTypeManager, String nameTypePerson, String nameElement, int stockElements, String codeLoad, LocalDate finishTime,double price, int days){
        super(nameManager, namePerson,nameTypeManager,nameTypePerson,nameElement, stockElements, codeLoad);
        this.finishTime = finishTime;
        this.price = price;
        this.days = days;
    }

    public FinishLoan(String nameManagerString, String namePersonString,String nameTypeManager,String nameTypePerson,String nameElement, int stockElements, String codeLoad,LocalDate finishTime,double price, int days){
        super(nameManagerString,namePersonString,nameTypeManager, nameTypePerson, nameElement, stockElements, codeLoad);
        this.finishTime = finishTime;
        this.price = price;
        this.days = days;
    }

    public LocalDate getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDate finishTime) {
        this.finishTime = finishTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
