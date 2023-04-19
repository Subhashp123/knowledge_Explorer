package com.app.pojo;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name = "student_tbl")
public class Student extends BaseEntity {

	@Column(name = "student_name", length = 30)
	private String name;
	@Column(name = "student_email", length = 30)
	private String email;
	@Column(name = "student_password", length = 30)
	private String password;
	@Column(name = "student_mobile", length = 30)
	private String mobile;
	@Column(name = "student_dob", length = 30)
	private String dob;
	@Lob
	@Column(name = "student_image", length = 10000000)
	private byte[] image;
	@Transient
	private String imgUtility;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_address_id")
	private Addresses address;
	private String status;

	public Student() {
		super();
	}

	public Student(String name, String email, String password, String mobile, String dob, byte[] image, String status) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.dob = dob;
		this.image = image;

		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Addresses getAddress() {
		return address;
	}

	public void setAddress(Addresses address) {
		this.address = address;
	}

	public String getImgUtility() throws UnsupportedEncodingException {
		byte[] encodeBase64 = Base64.encodeBase64(getImage());
		String base64Encoded = new String(encodeBase64, "UTF-8");
		return base64Encoded;
	}

	public void setImgUtility(String imgUtility) {
		this.imgUtility = imgUtility;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", email=" + email + ", password=" + password + ", mobile=" + mobile + ", dob="
				+ dob + ", image=" + Arrays.toString(image) + ", address=" + address + "]";
	}

}
