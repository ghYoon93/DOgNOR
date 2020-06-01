package com.spare.dogiver.service.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import contact.bean.ContactDTO;
import contact.dao.ContactDAO;


@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDAO contactDAO;

	@Override
	public int contactWrite(ContactDTO contctDTO) {
		return contactDAO.contactWrite(contctDTO);
		
	}

	@Override
	public List<ContactDTO> contactList() {
		List<ContactDTO> list = contactDAO.contactList();
		return list;
	}

	@Override
	public List<ContactDTO> myContactList() {
		List<ContactDTO> list = contactDAO.myContactList();
		return list;
	}

	@Override
	public void admin_contect_delete(String seq) {
		contactDAO.admin_contect_delete(seq);
	}

	@Override
	public List<ContactDTO> getInfo(String email) {
		List<ContactDTO> list = contactDAO.getInfo(email);
		return list;
	}

	@Override
	public void my_contect_delete(String seq) {
		contactDAO.my_contect_delete(seq);
		
	}
	
	
}









