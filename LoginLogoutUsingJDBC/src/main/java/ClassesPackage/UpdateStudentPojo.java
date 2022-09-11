package ClassesPackage;

public class UpdateStudentPojo {
	private String firstname;
	private String lastname;
	private String dob;
	private String add;
	private String classname;
	private String Studentid;
	
	public String getStudentid() {
		return Studentid;
	}
	public void setStudentid(String studentid) {
		Studentid = studentid;
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
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}

}
