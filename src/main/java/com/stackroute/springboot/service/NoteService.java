package com.stackroute.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.springboot.domain.Note;
import com.stackroute.springboot.exception.NoteAlreadyExistsException;
import com.stackroute.springboot.exception.NoteNotFoundException;
import com.stackroute.springboot.repository.NoteRepository;

@Service
public class NoteService implements INoteService {
	
	private NoteRepository noteRepository;

	
	@Autowired
	public NoteService(NoteRepository noteRepository) {
		
		this.noteRepository = noteRepository;
	}

	@Override
	public Note saveNote(Note note) throws NoteAlreadyExistsException {
		
    /*
     * 1. check whether employee object is already existing with the details
     * 2. If yes, throw EmployeeAlreadyExistsException
     * 3. If not, persiste the employee entity in the db table
     * 4. Return the object
     */
		Optional<Note> optional =  this.noteRepository.findById(note.getId());
		if(optional.isPresent()) {
			throw new NoteAlreadyExistsException();
		}
		Note createdNote = this.noteRepository.save(note);
		
		return createdNote;
	}

	@Override
	public Note getNoteById(String id) throws NoteNotFoundException {
		Optional<Note> optional =  this.noteRepository.findById(id);
		Note note = null ;
		if(optional.isPresent()) {
			note = optional.get();
		}else {
			throw new NoteNotFoundException();
		}
		
		return note;
	}

	@Override
	public List<Note> getNotes() {		
		return  noteRepository.findAll();
	}

	@Override
	public Note updateNote(Note note) throws NoteNotFoundException {
		Optional<Note> optional =  this.noteRepository.findById(note.getId());
		Note updatedNote = null;
		if(optional.isPresent()) {
			updatedNote  = noteRepository.save(note);
		}else {
			throw new NoteNotFoundException();
		}
		return updatedNote;
	}

	@Override
	public boolean deleteNote(String id) throws NoteNotFoundException {
		Optional<Note> optional =  this.noteRepository.findById(id);
		boolean status = false;
		if(optional.isPresent()) {
			noteRepository.delete(optional.get());
			status = true;
		}else {
			throw new NoteNotFoundException();
		}
		
		return status;
	}

	

	

}
