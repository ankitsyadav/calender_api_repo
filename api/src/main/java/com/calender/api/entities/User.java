package com.calender.api.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Email
	private String email;

	private String sheetId = null;

	@NotNull
	private LocalDate expiryDate;

	private Boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSheetId() {
		return sheetId;
	}

	public void setSheetId(String sheetId) {
		this.sheetId = sheetId;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, expiryDate, id, sheetId, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(expiryDate, other.expiryDate) && id == other.id
				&& Objects.equals(sheetId, other.sheetId) && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", sheetId=" + sheetId + ", expiryDate=" + expiryDate
				+ ", status=" + status + "]";
	}

	public User(int id, String email, String sheetId, LocalDate expiryDate, Boolean status) {
		super();
		this.id = id;
		this.email = email;
		this.sheetId = sheetId;
		this.expiryDate = expiryDate;
		this.status = status;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
