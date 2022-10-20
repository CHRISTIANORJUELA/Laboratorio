package com.example.laboratory.utils;


import javafx.scene.control.ChoiceBox;

public class UtilisMethods {
    public static boolean filterEmpty1(String a, String b , String c , String d , String e){
        return (!a.isEmpty() && !b.isEmpty()) && (!c.isEmpty() && !d.isEmpty()) && !e.isEmpty();
    }

    public static boolean filterEmpty2(String a, String b , String c , String d , String e, String f){
        return (!a.isEmpty() && !b.isEmpty()) && (!c.isEmpty() && !d.isEmpty()) && (!e.isEmpty() && !f.isEmpty());
    }

    public static String getValueBox(ChoiceBox box){
        try {
            String value = box.getValue().toString();
            return value;
        }catch (NullPointerException e){
            System.out.println("Please select a choice value");
        }
        return "";
    }



}
