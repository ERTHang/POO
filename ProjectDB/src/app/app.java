package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class app {
	
	public static void main(String[] args) {
		try {
			
			Class.forName("org.postgresql.Driver");
			
			String url = "jdbc:postgresql://localhost:5432/dbend";
			
			Connection con = DriverManager.getConnection(url, "postgres", "udesc");
			
			String sql = "insert into cidade (nome, estado) values (?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			
			stmt.setString(1, "Floripa");
			stmt.setString(2, "SC");
			stmt.executeUpdate();
			
			String sql1 = "select * from cidade";
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			
			ResultSet rs = stmt1.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("nome") + " - " + rs.getString("estado"));
			}
						
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
		catch (SQLException e) {
			// TODO: handle exception
		}
	}

}
