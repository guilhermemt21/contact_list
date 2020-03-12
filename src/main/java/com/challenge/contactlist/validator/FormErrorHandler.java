package com.challenge.contactlist.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FormErrorHandler {
	private String field;
	private String error;
}
