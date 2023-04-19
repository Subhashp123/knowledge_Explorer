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
@Table(name = "admin_tbl")
public class Admin extends BaseEntity {

	@Column(name = "admin_name", length = 30)
	private String name;
	@Column(name = "admin_email", length = 30)
	private String email;
	@Column(name = "admin_password", length = 30)
	private String password;
	@Column(name = "admin_mobile", length = 30)
	private String mobile;
	@Column(name = "admin_dob", length = 30)
	private String dob;
	@Lob
	@Column(name = "admin_image", length = 10000000)
	private byte[] image;
	@Transient
	private String imgUtility;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "admin_address_id")
	private Addresses address;

	public Admin() {
		super();
	}

	public Admin(String name, String email, String password, String mobile, String dob, byte[] image,
			Addresses address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.dob = dob;
		this.image = image;
		this.address = address;
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

	@Override
	public String toString() {
		return "Admin [name=" + name + ", email=" + email + ", password=" + password + ", mobile=" + mobile + ", dob="
				+ dob + ", image=" + Arrays.toString(image) + ", address=" + address + "]";
	}

}
