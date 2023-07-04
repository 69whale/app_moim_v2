package org.edupoll.model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "follows")
public class Follow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //오라클 기본이 시퀀스 
	Integer id;
	
	Date created;
	
	
	@ManyToOne //나한테 외래키가 있는 상황 mappedby 안나옴
	@JoinColumn(name="ownerId")
	User owner;
	
	@ManyToOne
	@JoinColumn(name="targetId")
	User target;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getTarget() {
		return target;
	}

	public void setTarget(User target) {
		this.target = target;
	}

	
	public Follow() {
		super();
	}

	
	public Follow(Integer id, Date created, User owner, User target) {
		super();
		this.id = id;
		this.created = created;
		this.owner = owner;
		this.target = target;
	}
	
	

}
