package com.virtus.Data;

import java.util.ArrayList;

public class Set {


    ArrayList<TYPE> Types;
    ArrayList<String> ColumnNames;
    ArrayList<IColumn> Columns;
    
    private int numRows;
    private int numCols;
    
    public boolean addColumn(String pColName, TYPE pType) {
        
        try {
            switch(pType) {
                
                case Numeric:
                    Columns.add(new NumericColumn());
                    Types.add(TYPE.Numeric);
                    break;

                case Binary:
                    Columns.add(new BinaryColumn());
                    Types.add(TYPE.Binary);
                    break;

                default:
                    Columns.add(new DiscreteColumn());
                    Types.add(TYPE.Discrete);
                    break;
            }
            
            ColumnNames.add(pColName);
            numCols++;
            
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
    public Row getRow(int pIndex) {
        Row row = new Row();
        
        for(IColumn col : Columns) {
            row.add(col.getAt(pIndex), col.getType());
        }
        
        return row;
    }
}
