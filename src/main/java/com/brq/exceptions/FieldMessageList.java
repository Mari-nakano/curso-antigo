package com.brq.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class FieldMessageList extends StandardError 	{
	
	public FieldMessageList(LocalDateTime timestamp, int status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	private List<FieldMessage> errors = new ArrayList<>();
	
	public void addError(String fieldName, String message) {
		
		errors.add(new FieldMessage(fieldName, message));
		
	}

}
