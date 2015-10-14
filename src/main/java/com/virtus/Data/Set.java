package com.virtus.Data;

import com.virtus.Data.Types.DataItem;
import com.virtus.exception.InvalidColumnException;
import com.virtus.exception.InvalidTYPEException;

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
		types       = new ArrayList<>();
		columnNames = new ArrayList<>();
		columns     = new ArrayList<>();

		numRows  = 0;
		numCols  = 0;
		classCol = 0;
    }

    ///// Properties /////

    public List<TYPE> Types() { return types; }
    
    public List<String> ColNames() {return columnNames; }
    
    public int NumColumns() { return numCols; }
    public int NumRows   () { return numRows; }
    
    ///// Public Functions /////

    public boolean addColumn(IColumn col) throws InvalidColumnException {
		if(col.length() != numRows) {

			if(numRows == 0) {
				numRows = col.length();
			} else {
				throw new InvalidColumnException(col.length(), numRows);
			}
		}

		columns.add(col);
		columnNames.add(col.getName());
		types.add(col.getType());

		numCols++;

		return true;
	}

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
    
    public Boolean addRow(Row pRow) throws InvalidTYPEException {
        for(int i = 0; i < numCols; ++i) {
			DataItem item = pRow.getAt(i);
			columns.get(i).add(item);
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
        if(pClassCol > numCols)
            throw new IndexOutOfBoundsException(pClassCol + " is larger than the number of columns (" + numCols + ")");
        classCol = pClassCol;
    }
    
    public DataItem getClassification(int pRow) {
        return columns.get(classCol).getAt(pRow);
    }

    public IColumn getClassCol() {
        return columns.get(classCol);
    }


	@Override
	public String toString() {
		String s = "";

		for(String colName : columnNames) {
			s += String.format("%-20s", colName);
		}

		s += "\n";

		for(int i = 0; i < numRows; ++i) {
			s += (getRow(i).toString() + "\n");
		}

		return s;
	}
}
