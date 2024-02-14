package com.suggest.county.service;

import com.suggest.county.entity.CountySuggestion;
import com.suggest.county.repository.CountyRepository;
import java.util.Arrays;
import static org.junit.Assert.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class CountySuggestionServiceTest {
  CountyRepository countyRepositoryMock = PowerMockito.mock(CountyRepository.class);
  CountySuggestionService countySuggestionService = new CountySuggestionService(countyRepositoryMock);

  @Test
  public void suggestTestWithSingleQuery() throws Exception {
    PowerMockito.when(countyRepositoryMock.findByNameContainingIgnoreCase("ran")).thenReturn(Arrays.asList( new CountySuggestion("1200","AL","ranson")));
   assertNotEquals(null,countySuggestionService.suggest("ran"));
  }
  @Test
  public void suggestTestWithTwoQueries() throws Exception {
    PowerMockito.when(countyRepositoryMock.findByNameContainingIgnoreCase("ran,GA")).thenReturn(Arrays.asList( new CountySuggestion("1200","GA","Ranson")));
    assertNotEquals(null,countySuggestionService.suggest("ran,GA"));
  }
  @Test
  public void suggestTestWithEmpty() throws Exception {
    PowerMockito.when(countyRepositoryMock.findByNameContainingIgnoreCase("")).thenReturn(Arrays.asList());
    assertNotEquals(null,countySuggestionService.suggest("ran,GA"));
  }
}
