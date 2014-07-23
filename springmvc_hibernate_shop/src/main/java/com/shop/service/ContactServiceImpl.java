package com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.ContactDAO;
import com.shop.model.Contact;

@Service
public class ContactServiceImpl implements ContactService{
	
	private ContactDAO contactDAO;
	
	
	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	@Override
	@Transactional
	public void add(Contact contact) {
		this.contactDAO.add(contact);
		
	}

	@Override
	public void edit(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contact getContactById(int id) {
		// TODO Auto-generated method stub
		return null;
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

}
