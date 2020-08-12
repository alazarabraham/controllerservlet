package net.capstoneproject.login;
import java.sql.*;

public class DoctorDao {
	 
		 
	    public Doctor checkLogin(String email, String password) throws SQLException,
	            ClassNotFoundException {
	        String jdbcURL = "jdbc:mysql://localhost:3306/clinic";
	        String dbUser = "root";
	        String dbPassword = "markos";
	 
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
	        String sql = "SELECT * FROM doctors WHERE email = ? and password = ?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, email);
	        statement.setString(2, password);
	 
	        ResultSet result = statement.executeQuery();
	 
	        Doctor doctor = null;
	 
	        if (result.next()) {
	            doctor = new Doctor();
	            doctor.setFullname(result.getString("fullname"));
	            doctor.setEmail(email);
	        }
	 
	        connection.close();
	 
	        return doctor;
	    
	}
}
