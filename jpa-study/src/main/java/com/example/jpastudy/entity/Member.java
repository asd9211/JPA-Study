package com.example.jpastudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity //Entity ������̼��� ���� JPA�� ó�� �ε��Ҷ�, �ν��ϰ� ����.
@Data
public class Member {

	@Id //PK�� �˷��ִ� ������̼�
	private Long id;

	@Column(name = "userId")
	private String name;

}
