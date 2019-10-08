package restApplication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "rakutendb", name="Student12")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long studentId;	

	@Column
	private String name;
	@Column
	private String rollNumber;
	@Column
	private String std;
	@Column
	private String address;
	@Column
	private String schoolName;
	@Column
	private String schoolAddress;
	@Column
	private String friendsName;
	@Column
	private String friendsAddress;
	@Column
	private String friendsRollNumber;
	
	

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getFriendsName() {
		return friendsName;
	}

	public void setFriendsName(String friendsName) {
		this.friendsName = friendsName;
	}

	public String getFriendsAddress() {
		return friendsAddress;
	}

	public void setFriendsAddress(String friendsAddress) {
		this.friendsAddress = friendsAddress;
	}

	public String getFriendsRollNumber() {
		return friendsRollNumber;
	}

	public void setFriendsRollNumber(String friendsRollNumber) {
		this.friendsRollNumber = friendsRollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", rollNumber=" + rollNumber + ", std=" + std
				+ ", address=" + address + ", schoolName=" + schoolName + ", schoolAddress=" + schoolAddress
				+ ", friendsName=" + friendsName + ", friendsAddress=" + friendsAddress + ", friendsRollNumber="
				+ friendsRollNumber + "]";
	}

}
