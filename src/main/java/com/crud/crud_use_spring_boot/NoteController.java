package com.crud.crud_use_spring_boot;

import org.springframework.web.bind.annotation.*;

// @CrossOrigin(origins = "http://localhost:5500")
// @CrossOrigin(origins = '*')
@CrossOrigin
@RestController
public class NoteController {

  private final NoteRepositoryInterface noteRepositoryInterface;

  NoteController(NoteRepositoryInterface repository) {
    noteRepositoryInterface = repository;
  }

  // @CrossOrigin(origins = "http://localhost:5500")
  // @CrossOrigin(origins = "*")
  @GetMapping("/notes")
  Iterable<Note> getNotes() {
    return noteRepositoryInterface.findAll();
  }

  @PostMapping("/notes")
  Note createNote(@RequestBody Note newNote) {
    return noteRepositoryInterface.save(newNote);
  }

  @GetMapping("/notes/{noteId}")
  Note getNote(@PathVariable Long noteId) {
    return noteRepositoryInterface.findById(noteId).orElseThrow();
  }

  @PutMapping("/notes/{noteId}")
  Note putNote(@PathVariable Long noteId, @RequestBody Note newNote) {
    Note note = noteRepositoryInterface.findById(noteId).orElseThrow();
    note.setTitle(newNote.getTitle());
    note.setContent(newNote.getContent());
    return noteRepositoryInterface.save(note);
  }

  @DeleteMapping("/notes/{noteId}")
  void deleteNote(@PathVariable Long noteId) {
    Note note = noteRepositoryInterface.findById(noteId).orElseThrow();
    noteRepositoryInterface.delete(note);
  }
}
