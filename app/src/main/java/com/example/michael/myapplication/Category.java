package com.example.michael.myapplication;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 5/10/15.
 */
public class Category {

    public String string;
    public final List<String> children = new ArrayList<String>();

    public Category(String string) {
        this.string = string;
    }

}
