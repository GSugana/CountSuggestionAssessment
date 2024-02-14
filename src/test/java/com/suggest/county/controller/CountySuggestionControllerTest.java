package com.suggest.county.controller;

import com.suggest.county.CountyApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(PowerMockRunner.class)
@SpringBootTest(classes = CountyApplication.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class CountySuggestionControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void suggestTestForInvalidPath() throws Exception {
    this.mockMvc.perform(get("/invalidPath")).andExpect(status().isNotFound());
  }
  @Test
  public void suggestTestWithoutRequiredQueryParam() throws Exception {
    this.mockMvc.perform(get("/suggest")).andExpect(status().is4xxClientError());
  }
  @Test
  public void suggestTestWithValidQueryPsaram() throws Exception {
    this.mockMvc.perform(get("/suggest?q=VI")).andExpect(status().is2xxSuccessful());
  }
  @Test
  public void listTest() throws Exception {
    this.mockMvc.perform(get("/list")).andExpect(status().is2xxSuccessful());
  }
}
