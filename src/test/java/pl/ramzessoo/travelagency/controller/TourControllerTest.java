package pl.ramzessoo.travelagency.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Sql({"/data-test.sql"})
class TourControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldAllGetOnTours() throws Exception {
        this.mockMvc.perform(get("/tours/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void shouldReturn4OfTours() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/tours/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(4)))
                .andReturn();
    }

    @Test
    void shouldByResponseBodyLike() throws Exception {
        this.mockMvc.perform(get("/tours/"))
                .andExpect(jsonPath("$[0].id", equalTo(1)));
    }

    @Test
    void shouldGetLastMinuteReturn3Records() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/tours/lastMinute"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andReturn();
    }
}