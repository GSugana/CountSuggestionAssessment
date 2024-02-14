package com.suggest.county.service;

import com.suggest.county.entity.CountySuggestion;
import com.suggest.county.repository.CountyRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CountySuggestionService {
  private final CountyRepository countyRepository;

  public CountySuggestionService(CountyRepository countyRepository){
    this.countyRepository = countyRepository;
  }

  public void save(List<CountySuggestion> countySuggestionList) {
    countyRepository.saveAll(countySuggestionList);
  }

  public Iterable<CountySuggestion> list() {
    return countyRepository.findAll();
  }

  public Iterable<CountySuggestion> suggest(String q) throws Exception {
    try {
      String[] array = q.split(",");
      List<CountySuggestion> result;
      if (array.length == 2) {
        result = countyRepository.findByNameContainingIgnoreCaseAndStateContainingIgnoreCase(array[0], array[1]);
      } else {
        result = countyRepository.findByStateContainingIgnoreCase(array[0]);
        result.addAll( countyRepository.findByNameContainingIgnoreCase(array[0]));
      }
      return result.size() > 5 ? result.subList(0, 5) : result;
    } catch (Exception e) {
      log.error(e.toString());
      throw new Exception("Internal Error");
    }
  }
  }