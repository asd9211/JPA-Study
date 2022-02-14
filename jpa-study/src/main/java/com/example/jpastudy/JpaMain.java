package com.example.jpastudy;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.jpastudy.entity.Member;

public class JpaMain {
	private static Logger logger = LoggerFactory.getLogger(JpaMain.class);

	public void jpaMethod1() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		// EntityManagerFactory�� �ϳ��� �����ؼ� ���ø����̼� ��ü���� �����Ѵ�
		EntityManager em = emf.createEntityManager();
		// EntityManager�� ���� ��û���� ����.
		// ��? Ʈ����� �����̱� ������. ���� �����尣�� ������ �ϸ� �������� ���Ἲ�� ������. ���� ���� x
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Member member = em.find(Member.class, 1L);

			logger.info("member_id => {}", member.getId());
			logger.info("member_name => {}", member.getName());
			tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}

	//JPQL
	public void jpaMethod2() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		// EntityManagerFactory�� �ϳ��� �����ؼ� ���ø����̼� ��ü���� �����Ѵ�
		EntityManager em = emf.createEntityManager();
		// EntityManager�� ���� ��û���� ����.
		// ��? Ʈ����� �����̱� ������. ���� �����尣�� ������ �ϸ� �������� ���Ἲ�� ������. ���� ���� x
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			List<Member> members = em.createQuery("select m from Member as m", Member.class).getResultList();
			for(Member member : members) {
				logger.info("member_id => {}", member.getId());
				logger.info("member_name => {}", member.getName());
			}
			tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}

	public static void main(String[] args) {
		JpaMain jm = new JpaMain();
		jm.jpaMethod2();
	}
}
