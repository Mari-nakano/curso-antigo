package com.brq.exceptions;

import java.time.LocalDateTime;
//import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandardError {
	
//	private Long timestamp;
//	private Date timestamp;
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	private String path;

}
