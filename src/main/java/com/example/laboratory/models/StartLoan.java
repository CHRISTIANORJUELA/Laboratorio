package com.example.laboratory.models;

import java.time.LocalDate;

public class StartLoan extends Loan{
  private LocalDate startTime;


    public StartLoan(Object nameManager, String namePerson,String nameTypeManager, String nameTypePerson,String nameElement, int stockElements, String codeLoad, LocalDate startTime) {
        super(nameManager, namePerson,nameTypeManager,nameTypePerson,nameElement, stockElements, codeLoad);
        this.startTime = startTime;
    }

    public StartLoan(Object nameManager, String namePerson,String nameElement, int stockElements, String codeLoad, LocalDate startTime){
        super(nameManager, namePerson,nameElement, stockElements, codeLoad);
        this.startTime = startTime;
    }

    public StartLoan(String nameManagerString, String namePersonString,String nameTypeManager, String nameTypePerson,String nameElement, int stockElements, String codeLoad, LocalDate startTime ){
        super(nameManagerString,namePersonString,nameTypeManager, nameTypePerson, nameElement, stockElements, codeLoad);
        this.startTime = startTime;
    }


    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }
}
