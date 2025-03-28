package com.security.springsecurity.service.Contact;


import com.security.springsecurity.model.Contact;

import java.util.List;

public interface IContact {

    public List<Contact> listAllContacts();

    public Contact createContact(Contact contact);

    public Contact findContactById(Long id);

    public void deleteContactById(Long id);

    public void updateContact(Long id,Contact contact);

}
