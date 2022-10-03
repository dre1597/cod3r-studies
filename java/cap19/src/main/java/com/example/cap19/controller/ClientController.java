package com.example.cap19.controller;

import com.example.cap19.model.entity.Client;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

  @GetMapping("any")
  public Client getClient() {
    return new Client(100, "name1", "111.111.111-11");
  }

  @GetMapping("/{id}")
  public Client getClientById(@PathVariable int id) {
    return new Client(id, "name1", "111.111.111-11");
  }

  @GetMapping("")
  public Client getClientByQueryParam(@RequestParam(name = "id", defaultValue = "1") int id) {
    return new Client(id, "name1", "111.111.111-11");
  }
}
