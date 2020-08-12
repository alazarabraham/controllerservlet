<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Patients </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
</head>
<body>
    <center>
        <h1>Patients </h1>
        <h2>
            <a href="/Clinic/newpatient">Add New Patient</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Clinic/listpatient">List All Patient</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <tr>
                <th>Patient ID</th>
                <th>Patient First Name</th>
                <th>Patient Last Name</th>
                <th>Date of Birth</th>
                <th>Email</th>
                <th>Password</th>
            </tr>
            <c:forEach var="patient" items="${listPatient}">
                <tr>
                    <td><c:out value="${patient.patientid}" /></td>
                    <td><c:out value="${patient.firstname}" /></td>
                    <td><c:out value="${patient.lastname}" /></td>
                    <td><c:out value="${patient.dob}" /></td>
                    <td><c:out value="${patient.email}" /></td>
                  <td><c:out value="${patient.password}" /></td>
                    
                    
                    <td>
                        <a href="/Clinic/editpatient?patientid=<c:out value='${patient.patientid}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Clinic/deletepatient?patientid=<c:out value='${patient.patientid}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>