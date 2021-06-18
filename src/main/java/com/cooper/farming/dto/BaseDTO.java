package com.cooper.farming.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

public class BaseDTO {

	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "modified_at")
	private LocalDateTime modifiedAt;

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return "BaseDTO [createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + "]";
	}
	
}
