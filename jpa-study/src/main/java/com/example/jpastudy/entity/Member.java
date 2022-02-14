package com.example.jpastudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity //Entity 어노테이션을 통해 JPA가 처음 로딩할때, 인식하고 관리.
@Data
public class Member {

	@Id //PK를 알려주는 어노테이션
	private Long id;

	@Column(name = "userId")
	private String name;

}
