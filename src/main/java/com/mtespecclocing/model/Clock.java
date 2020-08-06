package com.mtespecclocing.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "clock")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"}, 
        allowGetters = true)
public class Clock implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2757171769472634939L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String type;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date clockDate;
	
	@ManyToOne()
	@JsonIgnore
    private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getClockDate() {
		return clockDate;
	}

	public void setClockDate(Date clockDate) {
		this.clockDate = clockDate;
	}

	public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
}
