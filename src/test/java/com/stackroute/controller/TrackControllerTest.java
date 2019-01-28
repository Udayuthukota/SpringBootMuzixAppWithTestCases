package com.stackroute.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.service.TrackService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(TrackController.class)
public class TrackControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private Track track;
    @MockBean
    private TrackService trackService;
    @InjectMocks
    private TrackController trackController;
    private List<Track> list =null;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(trackController).build();
        track = new Track();
        track.setTrackId(4);
        track.setTrackName("nooru janmaku");
        track.setTrackComment("america");
        track.setTrackId(5);
        track.setTrackName("kal ho na ho");
        track.setTrackComment("SRK");
        list= new ArrayList();
        list.add(track);
    }
    @Test
    public void saveTrack() throws Exception {
        when(trackService.saveTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void getAllTracks() throws Exception {
        when(trackService.getAllTracks()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void updateComment() throws Exception {
        when(trackService.updateTrackComments(anyString(),anyInt())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/track2/{trackId}",4)
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void deleteMusic() throws Exception {
        when(trackService.deleteTrackById(anyInt())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("api/v1/track/{trackId}")
                        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void getTrack() throws Exception {


        String trackName = "RANGITARANAGA";
        String trackComment = "ABCD";
        int trackId = 6;


        Track findUserResponse = Track.builder()
                .trackId(trackId)
                .trackName(trackName)
                .trackComment(trackComment)
                .build();

        Mockito.when(trackService.getTrackById(trackId)).thenReturn(java.util.Optional.ofNullable(findUserResponse));


        this.mockMvc.perform( MockMvcRequestBuilders
                .get("/api/v1/track/{trackId}", 6)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.trackId").value(6))
                .andReturn().getResponse().getContentAsString();
    }
    private static String asJsonString(Object obj) {
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

