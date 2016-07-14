package org.sshTest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="easybuy_USER")
public class EbUser {
	
	
	private Integer id;
    private String name;
    private String password;
    private String sex;
    private Date birthday;
    private String identity;
    private String email;
    private String mobile;
    private String address;
    private String status;
    
	public String toString() {
		return "EbUser [id=" + id + ", name=" + name + ", password=" + password
				+ ", sex=" + sex + ", birthday=" + birthday + ", identity="
				+ identity + ", email=" + email + ", mobile=" + mobile
				+ ", address=" + address + ", status=" + status + "]";
	}
	public EbUser(){
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="eu_user_id")
	public Integer getId() {
        return id;
    }
	@Column(name="eu_user_name")//getEu_user_name
	public String getName() {
        return name;
    }
	
	@Column(name="eu_password")
    public String getPassword() {
        return password;
    }
	@Column(name="eu_sex")
    public String getSex() {
        return sex;
    }
	@Column(name="eu_birthday")
    public Date getBirthday() {
        return birthday;
    }
	@Column(name="eu_identity_code")
    public String getIdentity() {
        return identity;
    }
	@Column(name="eu_email")
    public String getEmail() {
        return email;
    }
	@Column(name="eu_mobile")
    public String getMobile() {
        return mobile;
    }
	@Column(name="eu_address")
    public String getAddress() {
        return address;
    }
	@Column(name="eu_status")
    public String getStatus() {
        return status;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
