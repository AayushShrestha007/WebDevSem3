package com.ayush.onlyshoes.global;

import com.ayush.onlyshoes.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    public static List<Product> cart;
    static{
        cart= new ArrayList<Product>();
    }
}
