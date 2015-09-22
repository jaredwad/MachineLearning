package Test;

import java.sql.SQLException;
import Database.DBUtils;

public class Driver {

	public static void main(String[] args) {	
		System.out.println("Starting driver");
		
		Driver d = new Driver();
		
		try {
			d.buildDatabase();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buildDatabase() throws SQLException {
		DBUtils.ResetDatabase();
		
		DBUtils.CreateDatabases();
		DBUtils.PopulateDatabase();
		DBUtils.DisplayTables();
	}

}
