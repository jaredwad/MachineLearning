package com.virtus.Data;

import com.virtus.Data.Types.DataItem;
import java.util.ArrayList;
import java.util.List;

public class Set {


    protected ArrayList<TYPE> types;
    protected ArrayList<String> columnNames;
    protected ArrayList<IColumn> columns;
    
    private int numRows;
    private int numCols;
    private int classCol;

    public Set() {

    }

    ///// Properties /////

    public List<TYPE> Types() { return types; }
    
    public List<String> ColNames() {return columnNames; }
    
    public int NumColumns() { return numCols; }
    public int NumRows   () { return numRows; }
    
    ///// Public Functions /////
    
    public boolean addColumn(String pColName, TYPE pType) {
        
        try {
            // TODO figure out how to create a column
//            columns.add(TypeFactory.columnFromType(pType));
            types.add(pType);
            
            columnNames.add(pColName);
            numCols++;
            
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
    public Boolean addRow(Row pRow) {
        for(int i = 0; i < numCols; ++i) {
//            if(columns.get(i).add(pRow.getAt(i)))
//                continue; //Common case first
            return false; //Error adding item
        }
        
        return true;
    }
    
    public Row removeRow(int pIndex) {
        Row row = new Row();
        
        for(IColumn col : columns) {
            DataItem item = col.removeAt(pIndex);
            row.add(item, col.getType());
        }

        numRows--;
        return row;
    }
    
    public Row getRow(int pIndex) {
        Row row = new Row();
        
        for(IColumn col : columns) {
            row.add(col.getAt(pIndex), col.getType());
        }
        
        return row;
    }

    public List<Row> getRows() {
		ArrayList<Row> rows = new ArrayList<>(numRows);

		for(int i = 0; i < numRows; ++i) {
			rows.add(getRow(i));
		}
		return rows;
	}

    public List<IColumn> Columns() { return columns; }
    
    public void setClassCol(int pClassCol) {
        if(pClassCol > classCol)
            throw new IndexOutOfBoundsException(pClassCol + " is larger than the number of columns (" + numCols + ")");
        classCol = pClassCol;
    }
    
    public DataItem getClassification(int pRow) {
        return columns.get(classCol).getAt(pRow);
    }

    public IColumn getClassCol() {
        return columns.get(classCol);
    }

}
