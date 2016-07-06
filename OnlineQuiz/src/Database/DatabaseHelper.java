package Database;


import java.security.KeyPair;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Map.Entry;

import Database.MyDBInfo;

public class DatabaseHelper {

	Connection con;

	private void declare(){
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con =  DriverManager.getConnection( MyDBInfo.MYSQL_DATABASE_SERVER,
					MyDBInfo.MYSQL_USERNAME ,
					MyDBInfo.MYSQL_PASSWORD);
			
			con.setAutoCommit(true);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public DatabaseHelper(){
		declare();
	}

	public int ExcecuteQuery(String query){
		boolean bo;
		int returnID = -1;
		try{
			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.execute("USE onlinequizdb;");
			//		stmt.execute("USE " + "onlinequizdb");

			//bo = stmt.execute();
			returnID= stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			//con.commit();
		    ResultSet rs = stmt.getGeneratedKeys();
	        if (rs.next()){
	        	returnID=rs.getInt(1);
	        }
			//if (rs.next()){
			//	returnID=rs.getInt(1);
			//}
			/*	while(rs.next()) {
				String name = rs.getString("metropolis");

				long pop = rs.getLong("population");
			}*/
		}
		catch (Exception ex){
			String ragaca = ex.getMessage();
		}
		
		try {
			con.close();
			declare();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnID;
	}
	
	public ResultSet ExcecuteSelect(String query){
			ResultSet rs = null;
			try{
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.execute("USE onlinequizdb;");
				stmt.execute("RESET QUERY CACHE;;");
				//		stmt.execute("USE " + "onlinequizdb");

				rs = stmt.executeQuery(query);
				//con.commit();
				/*	while(rs.next()) {
					String name = rs.getString("metropolis");

					long pop = rs.getLong("population");
				}*/
			}
			catch (Exception ex){
			}
			
			return rs;
		}

	public int Insert(String tablename, Map<String, String> keyValues ){
		String query = "INSERT INTO " + tablename;
		String keys = "";
		String values = "";
		for(Entry<String, String> entry : keyValues.entrySet()) {
			String key = entry.getKey();
			keys +=key + ",";
			String value = entry.getValue();
			values +=value + ",";
		}
		keys = keys.substring(0, keys.length()-1);
		values = values.substring(0, values.length()-1);
		query += " (" + keys + ") " + "values (" + values + ");";
		return ExcecuteQuery(query);
	}

	public void Delete(String tablename,  Map<String, String> keyValues){
		String query = "DELETE FROM " + tablename + " WHERE ";
		for(Entry<String, String> entry : keyValues.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			query += key + "=" + value + " AND ";
		}
		query = query.substring(0, query.length()-4) + ";";
		ExcecuteQuery(query);
	}

	public void Update(String tablename, Map<String, String> keyValues, int id ){
		String query = "UPDATE " + tablename + " SET ";
		for(Entry<String, String> entry : keyValues.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			query += key + "=" + value + ", ";
		}
		query = query.substring(0, query.length()-2);
		query += " WHERE ID = " + id + ";";
		ExcecuteQuery(query);
	}

}
