package com.security.springsecurity.controller;

import com.security.springsecurity.model.Contact;
import com.security.springsecurity.repository.ContactRepository;
import com.security.springsecurity.service.Contact.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contact")

public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> listContact() {
        return contactService.listAllContacts();
    }

    public Contact createContact(Contact contact) {
        return contactService.createContact(contact);
    }
}
