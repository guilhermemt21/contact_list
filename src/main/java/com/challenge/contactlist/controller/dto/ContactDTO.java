package com.challenge.contactlist.controller.dto;

import com.challenge.contactlist.model.Contact;
import com.challenge.contactlist.model.ContactType;
import lombok.Getter;

@Getter
public class ContactDTO {

    private Long id;
    private ContactType type;
    private String value;

    public ContactDTO(Contact contact) {
        this.id = contact.getId();
        this.type = contact.getType();
        this.value = contact.getValue();
    }
}
