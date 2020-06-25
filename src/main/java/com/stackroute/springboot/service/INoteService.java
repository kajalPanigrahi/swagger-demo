package com.stackroute.springboot.service;

import java.util.List;

import com.stackroute.springboot.domain.Note;
import com.stackroute.springboot.exception.NoteAlreadyExistsException;
import com.stackroute.springboot.exception.NoteNotFoundException;

public interface INoteService {
	
	public Note saveNote(Note employee) throws NoteAlreadyExistsException;
	public Note getNoteById(String id) throws NoteNotFoundException;
	public List<Note> getNotes();
	public Note updateNote(Note employee) throws NoteNotFoundException;
	public boolean deleteNote(String id) throws NoteNotFoundException;

}
