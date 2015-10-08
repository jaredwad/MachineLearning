/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.Data;

import com.virtus.Data.Types.DataItem;
import com.virtus.exception.InvalidTYPEException;

import java.util.List;

/**
 *
 * @author jared
 */
public abstract class IColumn {
    List<DataItem> items;
    
    public DataItem getAt(int pIndex) {
        return items.get(pIndex);
    }
    public abstract TYPE getType();
    public void add(DataItem pItem) throws InvalidTYPEException{
        if(pItem.getType().equals(getType())) {
            throw new InvalidTYPEException(pItem.getType(), getType());
        }

        items.add(pItem);
    }
    public DataItem removeAt(int pIndex) {
        return items.remove(pIndex);
    }
    
    public int length() {
        return items.size();
    }
    
    public void set(int pIndex, DataItem pItem) {
        items.set(pIndex, pItem);
    }

    public List<DataItem> getItems() { return items; }
}

