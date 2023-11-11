package com.azshop.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String firstName;
	private String lastName;
	private String slug;
	private String cartId;
	private String email;
	private String phone;
	private boolean isDeleted;
	private boolean isEmailActive;
	private boolean isPhoneActive;
	private String salt;
	private String hashedPassword;
	private String role;
	private int userLevelId;
	private String avatar;
	private String coverImage;
	private int point;
	private BigDecimal eWallet;
	private Date createAt;
	private Date updateAt;

	public UserModel() {
	}

	public UserModel(int id, String firstName, String lastName, String slug, String cartId, String email, String phone,
			boolean isDeleted, boolean isEmailActive, boolean isPhoneActive, String salt, String hashedPassword,
			String role, int userLevelId, String avatar, String coverImage, int point, BigDecimal eWallet,
			Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.slug = slug;
		this.cartId = cartId;
		this.email = email;
		this.phone = phone;
		this.isDeleted = isDeleted;
		this.isEmailActive = isEmailActive;
		this.isPhoneActive = isPhoneActive;
		this.salt = salt;
		this.hashedPassword = hashedPassword;
		this.role = role;
		this.userLevelId = userLevelId;
		this.avatar = avatar;
		this.coverImage = coverImage;
		this.point = point;
		this.eWallet = eWallet;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	
	

	public UserModel(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isEmailActive() {
		return isEmailActive;
	}

	public void setEmailActive(boolean isEmailActive) {
		this.isEmailActive = isEmailActive;
	}

	public boolean isPhoneActive() {
		return isPhoneActive;
	}

	public void setPhoneActive(boolean isPhoneActive) {
		this.isPhoneActive = isPhoneActive;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserLevelId() {
		return userLevelId;
	}

	public void setUserLevelId(int userLevelId) {
		this.userLevelId = userLevelId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public BigDecimal geteWallet() {
		return eWallet;
	}

	public void seteWallet(BigDecimal eWallet) {
		this.eWallet = eWallet;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "UserModels [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", slug=" + slug
				+ ", cartId=" + cartId + ", email=" + email + ", phone=" + phone + ", isDeleted=" + isDeleted
				+ ", isEmailActive=" + isEmailActive + ", isPhoneActive=" + isPhoneActive + ", salt=" + salt
				+ ", hashedPassword=" + hashedPassword + ", role=" + role + ", userLevelId=" + userLevelId + ", avatar="
				+ avatar + ", coverImage=" + coverImage + ", point=" + point + ", eWallet=" + eWallet + ", createAt="
				+ createAt + ", updateAt=" + updateAt + "]";
	}

}
