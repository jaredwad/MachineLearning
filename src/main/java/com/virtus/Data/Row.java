/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.Data;

import com.virtus.Data.Types.DataItem;
import com.virtus.exception.InvalidTYPEException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jared
 */
public class Row {
    private ArrayList<DataItem> Items;
    private ArrayList<TYPE> Types;
    
    int len;

    public Row() {
        Items = new ArrayList<>();
        Types = new ArrayList<>();
        
        len = 0;
    }
    
    public List<DataItem> Items() {
        return Items;
    }
    
    public Boolean add(DataItem pItem, TYPE pType) {
        try {
            Items.add(pItem);
            Types.add(pType);
            len++;
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    public double distance(Row pRow) throws InvalidTYPEException{
        double distance = 0;

        for(int i = 0; i < len; ++i)
            distance += Items.get(i).distance(pRow.getAt(i));

        return distance;
    }
    
    public DataItem getAt(int pIndex) {
        return Items.get(pIndex);
    }
    
    public TYPE getTypeAt(int pIndex) {
        return Types.get(pIndex);
    }
}
