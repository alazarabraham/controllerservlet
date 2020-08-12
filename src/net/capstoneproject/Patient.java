package net.capstoneproject;


/**
 * Book.java
 * This is a model class represents a book entity
 * @author www.codejava.net
 *
 */
public class Patient {
    protected int patientid;
    protected String firstname;
    protected String lastname;
    protected String dob;
    protected String email; 
    protected String password; 

    public Patient() {
    }
 
    public Patient(int patientid) {
        this.patientid = patientid;
    }
 
    public Patient(int patientid, String firstname, String lastname, String dob, String email, String password) {
        this(firstname, lastname, dob,email,password);
        this.patientid = patientid;
    }
     
    public Patient(String firstname, String lastname, String dob, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.email = email;
        this.password = password;

    }

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 
  
}