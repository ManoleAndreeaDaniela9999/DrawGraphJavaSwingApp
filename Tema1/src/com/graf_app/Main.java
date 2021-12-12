package com.graf_app;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting...");
        MainMenu mainMenu = MainMenu.initGrafMainMenu();
        if( mainMenu!= null){
            System.out.println("Menu successfully initialized...");
        }

    }
}
