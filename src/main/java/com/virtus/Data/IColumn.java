/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.Data;

/**
 *
 * @author jared
 */
public interface IColumn {
    public Object getAt(int pIndex);
    public TYPE getType();
    public Boolean add(Object pItem);
    public Object removeAt(int pIndex);
}
