package com.crud.crud_use_spring_boot;

import jakarta.persistence.*;

// utile lombok ma solo che gli ID li crea a caso e non in ordine
// ... quindi aggiungo solo gli get e set delle variabili
// import lombok.Data;

// decoratore di lombok
// @Data
@Entity
public class Note {

  @Id
  @GeneratedValue
  private Long id;

  private String title;
  private String content;

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  // public void setId(Long id) {
  //   this.id = id;
  // }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }

  Note() {}

  Note(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
