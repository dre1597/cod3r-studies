package com.example.cap19.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

  @PostMapping(path = "/form")
  public String formReturn() {
    return "Form was sent!";
  }
}
