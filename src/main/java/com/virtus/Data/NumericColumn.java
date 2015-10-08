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
public class NumericColumn extends IColumn {
    
    public static double cast(Object pItem) {
        return (double)pItem;
    }

    @Override
    public TYPE getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
