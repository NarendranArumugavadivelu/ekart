package com.cooper.farming.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserVO {

	@JsonProperty("user_id")
	@Schema(description = "The id of the user", type = "integer")
	private int userId;
	
	@JsonProperty("user_name")
	@Schema(description = "The user name to login", type = "string")
	@NotBlank(message = "{user.name.notBlank}")
	private String userName;
	
	@JsonProperty("password")
	@Schema(description = "The password to login", type = "string")
	@NotBlank(message = "{password.notBlank}")
	@Size(min = 8, max = 16, message = "{user.password.length}")
	private String password;
	
	@JsonProperty("first_name")
	@Schema(description = "The first name of the user", type = "string")
	@NotBlank(message = "{first.name.notBlank}")
	private String firstName;
	
	@JsonProperty("last_name")
	@Schema(description = "The last name of the user", type = "string")
	@NotBlank(message = "{last.name.notBlank}")
	private String lastName;
	
	@JsonProperty("email_id")
	@Schema(description = "The email id of the user", type = "string")
	@NotBlank(message = "{email.invalid}")
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "{email.invalid}")
	private String emailId;
	
	@JsonProperty("phone_number")
	@Schema(description = "The phone number of the user", type = "long")
	@Pattern(regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$", message = "{phoneNumber.invalid}")
	private String phoneNumber;
	
	@JsonProperty("address")
	@Schema(description = "The door number of the user", type = "string")
	@NotBlank(message = "{doorNumber.notBlank}")
	private String address;
	
	@JsonProperty("city")
	@Schema(description = "The living city of the user", type = "string")
	@NotBlank(message = "{city.notBlank}")
	private String city;
	
	@JsonProperty("zip_code")
	@Schema(description = "The zipcode of the user address", type = "integer")
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "{zipCode.invalid}")
	private String zipCode;
	
	@JsonProperty("role_id")
	@Schema(description = "The role id of the user", type = "integer")
	@Min(value = 1, message = "{role.id.min}")
	private int roleId;
	
	@JsonProperty("role_name")
	@Schema(description = "The name of the role", type = "string")
	private String roleName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", city=" + city + ", zipCode=" + zipCode + ", roleId=" + roleId
				+ ", roleName=" + roleName + "]";
	}
	
	
	
	
	
}
