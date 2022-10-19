package com.greatLearning.customerManagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatLearning.customerManagement.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

		try {

			this.session = sessionFactory.getCurrentSession();

		} catch (HibernateException e) {
			this.session = sessionFactory.openSession();
		}

	}

	@Override
	public List<Customer> getAllCustomers() {

		Transaction tx = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer").list();
		tx.commit();

		return customers;
	}

	@Override
	public void save(Customer customer) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
	}

	@Override
	public Customer getCustomerById(int id) {

		Transaction tx = session.beginTransaction();

		Customer customer = new Customer();

		customer = session.get(Customer.class, id);

		tx.commit();
		return customer;
	}

	@Override
	public void deleteCustomerById(int id) {
		Transaction tx = session.beginTransaction();

		Customer customer = new Customer();

		customer = session.get(Customer.class, id);
		session.delete(customer);

		tx.commit();
	}

}
