package com.stackroute.repository;
import com.stackroute.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataMongoTest
public class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp() throws Exception {
        track=new Track();
        track.setTrackId(3);
        track.setTrackName("Vennilave vennilave");
        track.setTrackComment("By SPB");
    }
    @After
    public void tearDown() throws Exception {
        trackRepository.deleteAll();
    }

    @Test
    public void testsaveTrack(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackId()).get();
        Assert.assertEquals(3,fetchTrack.getTrackId());

    }
    @Test
    public void testSaveTrackFailure(){
        Track testTrack = new Track(5,"jeniffer","By manisharma");
        trackRepository.save(track);
        Assert.assertNotSame(testTrack,track);
    }
    @Test
    public void testGetAllTracks() {
            Track testTrack = new Track(6,"jeniffer lopez","By manisharma");
            Track testTrack1 = new Track(7,"Peniviti","By penchaldas");
            trackRepository.save(testTrack);
            trackRepository.save(testTrack1);
        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("jeniffer lopez",list.get(0).getTrackName());

    }

}