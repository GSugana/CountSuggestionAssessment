package com.suggest.county.controller;

import com.suggest.county.entity.CountySuggestion;
import com.suggest.county.service.CountySuggestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CountSuggestionController {
  private final CountySuggestionService countySuggestionService;

  public CountSuggestionController(CountySuggestionService countySuggestionService) {
    this.countySuggestionService = countySuggestionService;
  }

  /*
  for my reference to get the list of in-memory data
   */
  @GetMapping("list")
  public Iterable<CountySuggestion> list() {
    return countySuggestionService.list();
  }

  @GetMapping("suggest")
  public ResponseEntity suggest(@RequestParam(required = true, name="q") String q) throws Exception {
    try {
      return new ResponseEntity<>(countySuggestionService.suggest(q), HttpStatus.OK);
    }catch (Exception e){
      return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
