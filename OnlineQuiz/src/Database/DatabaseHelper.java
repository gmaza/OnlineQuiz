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

	public DatabaseHelper(){
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con =  DriverManager.getConnection( MyDBInfo.MYSQL_DATABASE_SERVER,
					MyDBInfo.MYSQL_USERNAME ,
					MyDBInfo.MYSQL_PASSWORD);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet ExcecuteQuery(String query){
		ResultSet rs = null;
		boolean bo;
		String stt;
		try{
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute("USE onlinequizdb");
			//		stmt.execute("USE " + "onlinequizdb");

			bo = stmt.execute();

			/*	while(rs.next()) {
				String name = rs.getString("metropolis");

				long pop = rs.getLong("population");
			}*/
		}
		catch (Exception ex){
			stt = ex.getMessage();
		}
		return rs;
	}

	public void Insert(String tablename, Map<String, String> keyValues ){
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
		ExcecuteQuery(query);
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


}
