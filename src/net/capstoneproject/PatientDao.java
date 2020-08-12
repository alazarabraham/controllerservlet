package net.capstoneproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 

public class PatientDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public PatientDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("connected successfully");
        }
        
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO patient (firstname, lastname, dob,email,password) VALUES (?, ?, ?,?,?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, patient.getFirstname());
        statement.setString(2, patient.getLastname());
        statement.setString(3, patient.getDob());
        statement.setString(4, patient.getEmail());
        statement.setString(5, patient.getPassword());

         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Patient> listAllPatients() throws SQLException {
        List<Patient> listPatient = new ArrayList<>();
         
        String sql = "SELECT * FROM patient";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int patientid = resultSet.getInt("patientid");
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            String dob = resultSet.getString("dob");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
             
            Patient patient = new Patient(patientid,firstname, lastname, dob, email,password);
            listPatient.add(patient);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listPatient;
    }
     
    public boolean deletePatient(Patient patient) throws SQLException {
        String sql = "DELETE FROM patient where patientid = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, patient.getPatientid());
        System.out.print(patient.getPatientid());
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updatePatient(Patient patient) throws SQLException {
        String sql = "UPDATE patient SET firstname = ?, lastname = ?, dob = ?, email = ?, password = ?";
        sql += " WHERE patientid = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, patient.getFirstname());
        statement.setString(2, patient.getLastname());
        statement.setString(3, patient.getDob());
        statement.setString(4, patient.getEmail());
        statement.setString(5, patient.getPassword());
        statement.setInt(6, patient.getPatientid());
         System.out.println(patient.getPatientid());
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Patient getPatient(int patientid) throws SQLException {
        Patient patient = null;
        String sql = "SELECT * FROM patient WHERE patientid = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, patientid);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            String dob = resultSet.getString("dob");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            patient = new Patient(patientid, firstname, lastname,dob, email,password);
        }
         
        resultSet.close();
        statement.close();
         
        return patient;
    }
}