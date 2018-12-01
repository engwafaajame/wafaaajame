package com.emuniapp.emuni.classes;


import java.util.List;

public class ContactResponse {

    private List<Contact> contacts = null;

    public List<Contact> getContacts()
    {
        return contacts;
    }

    public void setContacts(List<Contact> contacts)

    {
        this.contacts = contacts;
    }
}