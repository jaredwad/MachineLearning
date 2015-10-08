/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jared
 */
public class Row {
    private ArrayList<Object> Items;
    private ArrayList<TYPE> Types;
    
    int len;

    public Row() {
        Items = new ArrayList<>();
        Types = new ArrayList<>();
        
        len = 0;
    }
    
    public List<Object> Items() {
        return Items;
    }
    
    public Boolean add(Object pItem, TYPE pType) {
        try {
            Items.add(pItem);
            Types.add(pType);
            len++;
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
    public Object getAt(int pIndex) {
        return Items.get(pIndex);
    }
    
    public TYPE getTypeAt(int pIndex) {
        return Types.get(pIndex);
    }
}
