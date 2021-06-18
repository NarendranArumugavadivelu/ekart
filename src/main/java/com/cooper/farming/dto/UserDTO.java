package com.cooper.farming.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "users")
public class UserDTO extends BaseDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private RoleDTO roleDTO;
	
	@OneToMany(mappedBy = "userDTO", fetch = FetchType.LAZY)
	private Set<ProductDTO> productDTOs;
	
	@OneToMany(mappedBy = "userDTO", fetch = FetchType.LAZY)
	private Set<BidsDTO> bidsDTOs;
	
	@OneToMany(mappedBy = "userDTO", fetch = FetchType.LAZY)
	private Set<RatingDTO> ratingDTOs;

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

	public RoleDTO getRoleDTO() {
		return roleDTO;
	}

	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}

	public Set<ProductDTO> getProductDTOs() {
		return productDTOs;
	}

	public void setProductDTOs(Set<ProductDTO> productDTOs) {
		this.productDTOs = productDTOs;
	}

	public Set<BidsDTO> getBidsDTOs() {
		return bidsDTOs;
	}

	public void setBidsDTOs(Set<BidsDTO> bidsDTOs) {
		this.bidsDTOs = bidsDTOs;
	}

	public Set<RatingDTO> getRatingDTOs() {
		return ratingDTOs;
	}

	public void setRatingDTOs(Set<RatingDTO> ratingDTOs) {
		this.ratingDTOs = ratingDTOs;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", city=" + city + ", zipCode=" + zipCode + ", roleDTO=" + roleDTO
				+ ", productDTOs=" + productDTOs + ", bidsDTOs=" + bidsDTOs + ", ratingDTOs=" + ratingDTOs + "]";
	}

	
}
