package com.virtus.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.virtus.Data.IColumn;
import com.virtus.Data.TYPE;
import com.virtus.Database.DBUtils;
import com.virtus.Data.Set;

public class Driver {

	public static void main(String[] args) {	
		System.out.println("Starting driver");
		
		Driver d = new Driver();
		
		try {
			d.buildDatabase();



		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildDatabase() throws SQLException {
		DBUtils.ResetDatabase();
		
		DBUtils.CreateDatabases();
		DBUtils.PopulateDatabase();
		DBUtils.DisplayTables();

	}

	public Set buildDataSet() throws SQLException {
		Set s = new Set();



		return s;
	}

	public IColumn getColumnFromDB(String colName, TYPE type) {
		IColumn col = null;



		return col;
	}
}
