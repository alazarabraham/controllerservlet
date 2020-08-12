<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Patient Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
</head>
<body>
    <center>
        <h1>Patient Form</h1>
        <h2>
            <a href="/Clinic/newpatient">Add New Patient</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Clinic/listpatient">List All Patients</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${patient != null}">
            <form action="updatepatient" method="post" >
        </c:if>
        <c:if test="${patient == null}">
            <form action="insertpatient" method="post">
        </c:if>
        <table border="1" cellpadding="5" class="table">
            <caption>
                <h2>
                    <c:if test="${patient != null}">
                        Edit Patient
                    </c:if>
                    <c:if test="${patient == null}">
                        Add New Patient
                    </c:if>
                </h2>
            </caption>
                <c:if test="${patient != null}">
                    <input type="hidden" name="patientid" value="<c:out value='${patient.patientid}' />" />
                </c:if>           
            <tr>
                <th>First Name: </th>
                <td>
                    <input type="text" name="firstname" size="45"
                            value="<c:out value='${patient.firstname}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="lastname" size="45"
                            value="<c:out value='${patient.lastname}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Date of Birth: </th>
                <td>
                    <input type="text" name="dob" size="45"
                            value="<c:out value='${patient.dob}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45"
                            value="<c:out value='${patient.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="45"
                            value="<c:out value='${patient.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>