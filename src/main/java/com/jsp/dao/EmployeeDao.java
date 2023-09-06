package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.jsp.dto.Employee;

@Component
public class EmployeeDao {

	
	public Employee saveEmployee(Employee employee) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sagar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(employee!=null) {
			entityTransaction.begin();
			entityManager.persist(employee);
			entityTransaction.commit();
		}
		return employee;
	}
	
	public Employee updateEmployee(Employee employee) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sagar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Employee employee2=entityManager.find(Employee.class,employee.getId());
		if(employee2!=null) {
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
		}
		return employee2;
	}
	
	public Employee getEmployeeById(int id) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sagar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Employee employee=entityManager.find(Employee.class,id);
		
		if(employee!=null) {
			return employee;
		}
		return null;
	}
	
	public Employee deleteEmployee(int id) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sagar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		
		Employee  employee=entityManager.find(Employee.class,id);
		if(employee!=null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
		}
		return employee;
	}
	
	public List<Employee> getAllEmployee() {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sagar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select e from Employee e");
		
		List<Employee> list=query.getResultList();
		
		return list;
		
	}
}
