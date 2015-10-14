/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.Data;

import com.virtus.Data.Types.DataItem;

/**
 *
 * @author jared
 */
public class BinaryColumn extends IColumn {
    
    public static Boolean cast(Object pItem) {
        return (Boolean)pItem;
    }

    @Override
    public TYPE getType() {
        return TYPE.Binary;
    }
}
