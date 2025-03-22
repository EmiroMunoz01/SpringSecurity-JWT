package com.security.springsecurity.service.Contact;

import com.security.springsecurity.model.Contact;
import com.security.springsecurity.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContact{


    @Autowired
    private ContactRepository contactRepository;
    @Override
    public List<Contact> listAllContacts() {
        return List.of();
    }

    @Override
    public Contact createContact(Contact asunto) {
        return contactRepository.save(asunto);
    }

    @Override
    public Contact findContactById(Long id) {
        return null;
    }

    @Override
    public void deleteContactById(Long id) {

    }

    @Override
    public void updateContact(Long id, Contact asunto) {

    }
}
