package com.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.model.Contact;

@Repository
public class ContactImpl implements ContactInterface{
	
	private static final Logger logger = LoggerFactory.getLogger(ContactImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Contact contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		logger.info("Save contact successfully, Details : "+contact);
	}

	@Override
	public void edit(Contact contact) {
		sessionFactory.getCurrentSession().update(contact);
		logger.info("Update contact successfully, Details : "+contact);
	}

	@Override
	public void remove(int id) {
		Session session=sessionFactory.getCurrentSession();
		Contact contact=(Contact) session.load(Contact.class,new Integer(id));
		if(contact!=null){
			session.delete(contact);
		}
		logger.info("Delete contact successfully, Details : "+contact);
	}

	@Override
	public List<Contact> getNLatestContact(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getNextListContact(int last_contact_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContactById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Contact) session.load(Contact.class,new Integer(id));
	}
	
}
