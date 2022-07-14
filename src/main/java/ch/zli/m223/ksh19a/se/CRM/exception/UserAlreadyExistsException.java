package ch.zli.m223.ksh19a.se.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends RuntimeException {
	public UserAlreadyExistsException() {
		this("");
	}

	public UserAlreadyExistsException(String msg) {
		super(msg, null, false, false);
	}
}
