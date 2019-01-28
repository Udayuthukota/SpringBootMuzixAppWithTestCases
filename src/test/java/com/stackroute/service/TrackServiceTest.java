//package com.stackroute.service;
//import com.stackroute.domain.Track;
//import com.stackroute.exceptions.TrackAlreadyExistsException;
//import com.stackroute.exceptions.TrackNotFoundException;
//import com.stackroute.repository.TrackRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import java.util.List;
//import java.util.Optional;
//import org.mockito.MockitoAnnotations;
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class TrackServiceTest {
//    private Track track;
//    //Create a mock for UserRepository
//    @Mock
//    private TrackRepository trackRepository;
//
//    // Inject the mocks as dependencies into UserServiceImpl
//    @InjectMocks
//    private TrackServiceImpl trackService;
//    List<Track> list = null;
//
//    @Before
//    public void setUp() throws Exception {
//        //Initialising the mock object
//        MockitoAnnotations.initMocks(this);
//        track = new Track();
//        track.setTrackId(8);
//        track.setTrackName("sayonnara");
//        track.setTrackComment("Rp");
//    }
//    //save a track success case
//    @Test
//    public void saveUserTestSuccess() throws TrackAlreadyExistsException {
//        when(trackRepository.save((Track) any())).thenReturn(track);
//        Track savedTrack = trackService.saveTrack(track);
//        Assert.assertEquals(track, savedTrack);
//        //verify here verifies that userRepository save method is only called once
//        verify(trackRepository, times(1)).save(track);
//    }
//    //save a track failure case
//    @Test()
//    public void saveTrackTestFailure() throws TrackAlreadyExistsException {
//        when(trackRepository.save((Track) any())).thenReturn(null);
//        Track savedTrack = trackService.saveTrack(track);
//        Assert.assertEquals(null, savedTrack);
//        }
//    //get all tracks
//    @Test
//    public void getAllTracksSuccess() {
//
//        trackRepository.save(track);
//        //stubbing the mock to return specific data
//        when(trackRepository.findAll()).thenReturn(list);
//        List<Track> tracklist = trackService.getAllTracks();
//        Assert.assertEquals(list, tracklist);
//    }
//
//    @Test
//    public void updateUserTestSuccess() throws TrackAlreadyExistsException {
//        when(trackRepository.save((Track) any())).thenReturn(track);
//        Track savedTrack = trackService.saveTrack(track);
//        Assert.assertEquals(track, savedTrack);
//        //verify here verifies that userRepository save method is only called once
//        verify(trackRepository, times(1)).save(track);
//    }
//    //update a comment in track
//    @Test
//    public void updateTrackCommentTestSuccess() throws TrackNotFoundException {
//        when(trackRepository.existsById(anyInt())).thenReturn(true);
//        when(trackRepository.findById(anyInt())).thenReturn(Optional.of(track));
//        when(trackRepository.save((Track) any())).thenReturn(track);
//        track.setTrackComment("bbgbbbd");
//        Track updateTrack = trackService.updateTrackComments(track.getTrackComment(),track.getTrackId());
//        Assert.assertEquals(track,updateTrack);
//
//        //verify here verifies that userRepository save method is only called once
//        verify(trackRepository,times(1)).save(track);
//    }
//    //get track by id
//    @Test
//    public void getTrackById() throws TrackNotFoundException{
//        when(trackRepository.existsById(anyInt())).thenReturn(true);
//        when(trackRepository.findById(anyInt())).thenReturn(Optional.of(track));
//        Optional<Track> getTrackById = trackService.getTrackById(track.getTrackId());
//        Assert.assertEquals(Optional.of(track),getTrackById);
//        verify(trackRepository,times(1)).findById(track.getTrackId());
//    }
//
//    //delete delete by id
//    @Test
//    public void deleteById() throws TrackNotFoundException{
//        when(trackRepository.existsById(anyInt())).thenReturn(true);
//       // when(trackRepository.deleteById();
//       // when(trackRepository.delete(anyInt())).thenReturn(null);
//        boolean deleted=trackService.deleteTrackById(track.getTrackId());
//        Assert.assertEquals(true,deleted);
//    }
//
//}
//
//
//
