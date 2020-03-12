package com.challenge.contactlist.controller.form;

import com.challenge.contactlist.model.Contact;
import com.challenge.contactlist.model.ContactType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class ContactForm {

    private ContactType type;
    private String value;

    public Contact convert() {
        return Contact.builder()
                .type(this.getType())
                .value(this.getValue())
                .build();
    }

}
