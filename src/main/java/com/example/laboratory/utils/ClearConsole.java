package com.example.laboratory.utils;

public class ClearConsole {
    public static void main(){
        System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}