package com.suggest.county.repository;

import com.suggest.county.entity.CountySuggestion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountyRepository extends JpaRepository<CountySuggestion, Long> {

  List<CountySuggestion> findByStateContainingIgnoreCase(String state);
  List<CountySuggestion> findByNameContainingIgnoreCaseAndStateContainingIgnoreCase(String state,String county);
  List<CountySuggestion> findByNameContainingIgnoreCase(String county);


}
