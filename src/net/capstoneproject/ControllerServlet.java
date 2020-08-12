package net.capstoneproject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PatientDao patientDao;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        patientDao = new PatientDao(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/newpatient":
                showNewPatientForm(request, response);
                break;
            case "/insertpatient":
                insertPatient(request, response);
                break;
            case "/deletepatient":
                deletePatient(request, response);
                break;
            case "/editpatient":
                showPatientEditForm(request, response);
                break;
            case "/updatepatient":
                updatePatient(request, response);
                break;
                
            default:
                listPatient(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listPatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Patient> listPatient = patientDao.listAllPatients();
        request.setAttribute("listPatient", listPatient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("PatientList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewPatientForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("PatientForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showPatientEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int patientid = Integer.parseInt(request.getParameter("patientid"));
        Patient existingPatient = patientDao.getPatient(patientid);
        RequestDispatcher dispatcher = request.getRequestDispatcher("PatientForm.jsp");
        request.setAttribute("patient", existingPatient);
        dispatcher.forward(request, response);
 
    }
 
    private void insertPatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
 
        Patient newPatient = new Patient(firstname, lastname, dob,email,password);
        patientDao.insertPatient(newPatient);
        response.sendRedirect("listPatient");
    }
 
    private void updatePatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int patientid = Integer.parseInt(request.getParameter("patientid"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        
 
        Patient patient = new Patient(patientid, firstname, lastname, dob,email,password);
        patientDao.updatePatient(patient);
        response.sendRedirect("listPatient");
    }
 
    private void deletePatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int patientid = Integer.parseInt(request.getParameter("patientid"));
 
        Patient patient = new Patient(patientid);
        patientDao.deletePatient(patient);
        response.sendRedirect("listPatient");
 
    }
}