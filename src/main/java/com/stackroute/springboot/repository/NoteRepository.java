package com.stackroute.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.springboot.domain.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {

	
}
