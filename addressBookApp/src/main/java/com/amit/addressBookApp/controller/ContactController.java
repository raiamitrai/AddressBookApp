package com.amit.addressBookApp.controller;

import com.amit.addressBookApp.entities.Contact;
import com.amit.addressBookApp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/contacts")
    public Contact addContact(@RequestBody Contact contact){
        return contactService.addContact(contact);
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContact(){
        return contactService.getAllContacts();
    }

    @GetMapping("/contacts/{id}")
    public Contact GetContactById(@PathVariable Long id){
        return contactService.getContactById(id);
    }

     @PutMapping("contacts/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact){
        return contactService.updateContact(id, contact);
    }
     @DeleteMapping("/contacts/{id}")
    public String deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
        return "Contact Deleted Successfully";
    }

}
