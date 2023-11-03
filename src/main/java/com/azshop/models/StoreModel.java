package com.azshop.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StoreModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String bio;
	private String slug;
	private int ownerId;
	private int storeLevelId;
	private boolean isDeleted;
	private boolean isActive;
	private String avatar;
	private String cover;
	private String featuredImage;
	private int point;
	private BigDecimal rating;
	private BigDecimal eWallet;
	private Date createAt;
	private Date updateAt;

	public StoreModel() {
	}

	public StoreModel(int id, String name, String bio, String slug, int ownerId, int storeLevelId, boolean isDeleted,
			boolean isActive, String avatar, String cover, String featuredImage, int point, BigDecimal rating,
			BigDecimal eWallet, Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.name = name;
		this.bio = bio;
		this.slug = slug;
		this.ownerId = ownerId;
		this.storeLevelId = storeLevelId;
		this.isDeleted = isDeleted;
		this.isActive = isActive;
		this.avatar = avatar;
		this.cover = cover;
		this.featuredImage = featuredImage;
		this.point = point;
		this.rating = rating;
		this.eWallet = eWallet;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getStoreLevelId() {
		return storeLevelId;
	}

	public void setStoreLevelId(int storeLevelId) {
		this.storeLevelId = storeLevelId;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getFeaturedImage() {
		return featuredImage;
	}

	public void setFeaturedImage(String featuredImage) {
		this.featuredImage = featuredImage;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
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
		return "StoreModel [id=" + id + ", name=" + name + ", bio=" + bio + ", slug=" + slug + ", ownerId=" + ownerId
				+ ", storeLevelId=" + storeLevelId + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", avatar="
				+ avatar + ", cover=" + cover + ", featuredImage=" + featuredImage + ", point=" + point + ", rating="
				+ rating + ", eWallet=" + eWallet + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}

}
