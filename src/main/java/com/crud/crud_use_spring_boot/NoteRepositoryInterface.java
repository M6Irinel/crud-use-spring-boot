package com.crud.crud_use_spring_boot;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepositoryInterface extends CrudRepository<Note, Long> {}
