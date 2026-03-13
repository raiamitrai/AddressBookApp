package com.amit.addressBookApp.service;

import com.amit.addressBookApp.entities.Contact;
import com.amit.addressBookApp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    // CREATE
    public Contact addContact(Contact contact){
        return contactRepository.save(contact);
    }

    //  READ ALL
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    //  READ BY ID
    public Contact getContactById(Long id){
        return contactRepository.findById(id).orElse(null);
    }

    //  UPDATE
    public Contact updateContact(Long id , Contact updatedContact){

        Contact contact = contactRepository.findById(id).orElse(null);

        if (contact != null) {

            contact.setFirstName(updatedContact.getFirstName());
            contact.setLastName(updatedContact.getLastName());
            contact.setAddress(updatedContact.getAddress());
            contact.setCity(updatedContact.getCity());
            contact.setState(updatedContact.getState());
            contact.setZip(updatedContact.getZip());
            contact.setPhone(updatedContact.getPhone());
            contact.setEmail(updatedContact.getEmail());
            contact.setAddressBookName(updatedContact.getAddressBookName());

            return contactRepository.save(contact);
        }

        return null;
    }

    //  DELETE
    public void deleteContact(Long id){
        contactRepository.deleteById(id);
    }
}