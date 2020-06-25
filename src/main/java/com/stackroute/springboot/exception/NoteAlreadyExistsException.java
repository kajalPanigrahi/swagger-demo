package com.stackroute.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.CONFLICT, reason = "Note already exists")
public class NoteAlreadyExistsException extends Exception{

}
