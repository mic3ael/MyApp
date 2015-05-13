package com.example.michael.myapplication;

/**
 * Created by michael on 5/10/15.
 */
public class MySingleton {
    private static MySingleton instance;

    public String customVar;

    public static void initInstance() {
        if (instance == null) {
            // Create the instance
            instance = new MySingleton();
        }
    }

    public static MySingleton getInstance() {
        // Return the instance
        return instance;
    }

    private MySingleton() {
        // Constructor hidden because this is a singleton
    }

    public void customSingletonMethod() {
        // Custom method
    }
}