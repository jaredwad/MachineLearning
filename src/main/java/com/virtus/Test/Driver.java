package com.virtus.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtus.Data.IColumn;
import com.virtus.Data.TYPE;
import com.virtus.Database.DBUtils;
import com.virtus.Data.Set;
import com.virtus.JLL.Supervised.KNN;
import com.virtus.exception.InvalidColumnException;
import com.virtus.exception.InvalidTYPEException;

public class Driver {

	public static void main(String[] args) {	
		System.out.println("Starting driver");

		Driver d = new Driver();
		
		try {
			d.buildDatabase();

			ArrayList<String> colNames = new ArrayList<>();
			ArrayList<TYPE> types = new ArrayList<>();

			colNames.add("sepalwidth");
			types.add(TYPE.Numeric);

			colNames.add("sepallength");
			types.add(TYPE.Numeric);

			colNames.add("petalwidth");
			types.add(TYPE.Numeric);

			colNames.add("petallength");
			types.add(TYPE.Numeric);

			colNames.add("Class");
			types.add(TYPE.Discrete);

			Set set = d.buildDataSet(colNames, types);

			set.setClassCol(4);

			System.out.println(set.toString());

			KNN learner = new KNN(set, 3, .7);

			learner.run();

			System.out.println(learner.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidColumnException e) {
			e.printStackTrace();
		} catch (InvalidTYPEException e) {
			e.printStackTrace();
		}


	}
	
	public void buildDatabase() throws SQLException {
		DBUtils.ResetDatabase();
		
		DBUtils.CreateDatabases();
		DBUtils.PopulateDatabase();
		DBUtils.DisplayTables();

	}

	public Set buildDataSet(List<String> colNames, List<TYPE> types) throws SQLException, InvalidColumnException {
		Set s = new Set();

		int size = colNames.size();

		for(int i = 0; i < size; ++i) {
			s.addColumn(DBUtils.getColumnFromDB(colNames.get(i), types.get(i)));
		}

		return s;
	}

	public IColumn getColumnFromDB(String colName, TYPE type) {
		IColumn col = null;



		return col;
	}
}
