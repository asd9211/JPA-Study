package com.example.jpastudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Entity 어노테이션을 통해 JPA가 처음 로딩할때, 인식하고 관리.
@Table(name="Member") // 객체와 실제 Table과 이름이 달라 매핑해야할경우
public class Member {

	@Id //PK를 알려주는 어노테이션
	private Long id;

	@Column(name = "userId")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
