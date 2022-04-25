package com.example.backend.controller;

import com.example.backend.domain.Show;
import com.example.backend.service.ShowService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.awt.*;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ShowControllerTest {

    @Mock
    ShowService showService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Show show;
    private List<Show> showList;

    @InjectMocks
    private ShowController showController;

    @BeforeEach
    public void setup() {
        show = new Show(1);
        mockMvc = MockMvcBuilders.standaloneSetup(showController).build();
    }

    @AfterEach
    public void tearDown() {
        show = null;
    }

    @Test
    public void GetMappingOfAllShows() throws Exception {
        when(showService.findAll()).thenReturn(showList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/findall").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(show))).andDo(MockMvcResultHandlers.print());
        verify(showService).findAll();
        verify(showService, times(1)).findAll();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void PostMappingOfSave() throws Exception {
        when(showService.save(any())).thenReturn(show);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/save").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(show))).andDo(MockMvcResultHandlers.print());
        verify(showService).save(any());
        verify(showService, times(1)).save(any());
    }

}
