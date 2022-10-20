package com.example.laboratory.models;

public class Loan {
  private Object nameManager;
  private Object namePerson;

  private String nameManagerString;

  private String namePersonString;

  private String nameTypeManager;

  private String nameTypePerson;

  private String nameElement;
  private int stockElements;
  private String codeLoad;

    public Loan(Object nameManager, Object namePerson,String nameTypeManager, String nameTypePerson,String nameElement, int stockElements, String codeLoad ) {
        this.nameManager = nameManager;
        this.namePerson = namePerson;
        this.nameTypeManager = nameTypeManager;
        this.nameTypePerson = nameTypePerson;
        this.nameElement = nameElement;
        this.stockElements = stockElements;
        this.codeLoad = codeLoad;
    }

    public Loan(Object nameManager, Object namePerson,String nameElement, int stockElements, String codeLoad){
        this.nameManager = nameManager;
        this.namePerson = namePerson;
        this.nameElement = nameElement;
        this.stockElements = stockElements;
        this.codeLoad = codeLoad;
    }

    public Loan(String nameManagerString, String namePersonString,String nameTypeManager, String nameTypePerson,String nameElement, int stockElements, String codeLoad ){
        this.nameManagerString = nameManagerString;
        this.namePersonString = namePersonString;
        this.nameTypeManager = nameTypeManager;
        this.nameTypePerson = nameTypePerson;
        this.nameElement = nameElement;
        this.stockElements = stockElements;
        this.codeLoad = codeLoad;
    }

    public Object getNameManager() {
        return nameManager;
    }

    public void setNameManager(Object nameManager) {
        this.nameManager = nameManager;
    }

    public Object getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(Object namePerson) {
        this.namePerson = namePerson;
    }


    public String getNameManagerString() {
        return nameManagerString;
    }

    public void setNameManagerString(String nameManagerString) {
        this.nameManagerString = nameManagerString;
    }

    public String getNamePersonString() {
        return namePersonString;
    }

    public void setNamePersonString(String namePersonString) {
        this.namePersonString = namePersonString;
    }

    public String getNameTypeManager() {
        return nameTypeManager;
    }

    public void setNameTypeManager(String nameTypeManager) {
        this.nameTypeManager = nameTypeManager;
    }

    public String getNameTypePerson() {
        return nameTypePerson;
    }

    public void setNameTypePerson(String nameTypePerson) {
        this.nameTypePerson = nameTypePerson;
    }

    public String getNameElement() {
        return nameElement;
    }

    public void setNameElement(String nameElement) {
        this.nameElement = nameElement;
    }

    public int getStockElements() {
        return stockElements;
    }

    public void setStockElements(int stockElements) {
        this.stockElements = stockElements;
    }

    public String getCodeLoad() {
        return codeLoad;
    }

    public void setCodeLoad(String codeLoad) {
        this.codeLoad = codeLoad;
    }
}
