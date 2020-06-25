package com.stackroute.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "Note doesn't exists with the specified ID")
public class NoteNotFoundException extends Exception{

}
