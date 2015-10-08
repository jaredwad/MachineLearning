package Database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.DeleteDbFiles;

public class DBUtils {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:";
    private static final String DB_NAME = "test";
    private static final String DB_PATH = "~/";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    
    public static void CreateDatabases() throws SQLException {
    	System.out.println("Starting Create Databases");
    	Connection connection = getDBConnection();
        Statement stmt = null;
                
        String Data = "CREATE TABLE DATA(id int primary key auto_increment"
        		+ ", sepallength double, sepalwidth double"
        		+ ", petallength double, petalwidth double"
        		+ ", class varchar(30))";
        
        String Class = "CREATE TABLE CLASSIFICATION(id int primary key"
        		+ ", class varchar(30))";
        
        try {
        	connection.setAutoCommit(false);
            stmt = connection.createStatement();
            
            stmt.execute(Data);
            stmt.execute(Class);
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally {
        	connection.commit();
        	connection.close();
        }
    }
    
    public static void PopulateDatabase() throws SQLException {
    	System.out.println("Starting Populate Databases");
    	Connection connection = getDBConnection();
        Statement stmt = null;
        
        String filePath = new File("lib/Iris.csv").getAbsolutePath();

    	String toData =  "INSERT INTO DATA (sepallength, sepalwidth,"
    			+ " petallength, petalwidth, class)"
    			+ " SELECT * FROM CSVREAD('" + filePath + "')";
    	
    	/*
    	String toData =  "INSERT INTO DATA (sepallength, sepalwidth,"
    			+ " petallength, petalwidth, class) VALUES"
    			+ " (1,2,3,4,'test');";
    	*/
    	
    	String toClass = "INSERT INTO CLASSIFICATION SELECT id, class FROM DATA";
    	
    	String alter = "UPDATE DATA SET class = NULL";
    	
        try {
        	connection.setAutoCommit(false);
            stmt = connection.createStatement();
            
            stmt.execute(toData);
            stmt.execute(toClass);
            stmt.execute(alter);
            
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally {
        	connection.commit();
        	connection.close();
        }
    }
    
    public static void DisplayTables() throws SQLException {
    	System.out.println("Starting Display Tables");
    	
    	Connection connection = getDBConnection();
        Statement stmt = null;
        
        try {
        	connection.setAutoCommit(false);
            stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from DATA");
            System.out.println("\tData Table:");
            while (rs.next()) {
                System.out.println("Id "+rs.getInt("id")
                + " Sepal Width:  " + rs.getDouble("sepalwidth" )
                + " Sepal Length: " + rs.getDouble("sepallength")
                + " Petal Width:  " + rs.getDouble("petalwidth" )
                + " Petal Length: " + rs.getDouble("sepallength")
                + " Class: " + rs.getString("class"));
            }
            
            rs = stmt.executeQuery("select * from Classification");
            System.out.println("\tClassification Table:");
            while (rs.next()) {
                System.out.println("Id "+rs.getInt("id")
                + " Class: " + rs.getString("class"));
            }
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally {
        	connection.commit();
        	connection.close();
        }
    }
    
    public static void ResetDatabase() throws SQLException {
    	System.out.println("Starting Database Reset");
    	
        DeleteDbFiles.execute(DB_PATH, DB_NAME, true);
    }
    
    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(
            		DB_CONNECTION + DB_PATH + DB_NAME
            		, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
