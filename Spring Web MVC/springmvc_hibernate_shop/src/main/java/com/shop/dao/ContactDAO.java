package com.shop.dao;

import java.util.List;


import com.shop.model.Contact;

public interface ContactDAO {
	public void add(Contact contact);
	public void edit(Contact contact);
	public void remove(int id);
	public Contact getContactById(int id);
	public List<Contact> getNLatestContact(int n);
	public List<Contact> getNextListContact(int last_contact_id);
}
