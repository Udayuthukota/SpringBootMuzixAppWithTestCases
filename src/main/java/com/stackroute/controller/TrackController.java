package com.stackroute.controller;
import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
//controller to recieve and sent the responses
@Api(value="Track")
@RestController
@RequestMapping(value="api/v1")
public class TrackController {

private TrackService trackService;
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }
    @ApiOperation(value = "Adding a new track", response = Iterable.class)
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
        //To save a track
        ResponseEntity responseEntity;
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully saved", HttpStatus.OK);
    return responseEntity;
    }
    @ApiOperation(value = "Get the details of all track", response = Iterable.class)
    @GetMapping("tracks")
    public ResponseEntity<List<Track>> getAllTracks(){
        //To get all the tracks available
        ResponseEntity responseEntity;
                try {
                    responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
                }catch (Exception ex) {
                    responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
                }
    return responseEntity;
    }

    @PutMapping("track2/{trackId}")
    public ResponseEntity<?> updateTrack(@RequestBody Track track,@PathVariable("trackId") int trackId )
    {
        //to update all the tracks
        ResponseEntity responseEntity;
        try {
            trackService.updateTrack(track, trackId);
            responseEntity = new ResponseEntity<String>("Successfully Updated", HttpStatus.OK);
        }catch (Exception ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @ApiOperation(value = "Delete a track", response = Iterable.class)
    @GetMapping("track1/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable("trackId") int trackId ) throws TrackNotFoundException
    {
        //to delete a particular track usind id
        ResponseEntity responseEntity;
            trackService.deleteTrackById(trackId);
            responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        return responseEntity;
    }
    @ApiOperation(value = "Get the details of a track by ID", response = Iterable.class)
    @GetMapping("track/{trackId}")
    public ResponseEntity<?> getTrackById(@PathVariable("trackId") int trackId) throws TrackNotFoundException
    {
        //To get a particular track using id
        ResponseEntity responseEntity;
            trackService.getTrackById(trackId);
            responseEntity = new ResponseEntity<Optional<Track>>(trackService.getTrackById(trackId), HttpStatus.OK);
        return responseEntity;
    }
    @ApiOperation(value = "Get the details of a track by trackName", response = Iterable.class)
    @GetMapping("track/{trackName}")
    public ResponseEntity<?> findByName(@PathVariable("trackName") String trackName ){
        //To find a track using name
        ResponseEntity responseEntity;
            responseEntity = new ResponseEntity<List<Track>>(trackService.findTrackByName(trackName), HttpStatus.FOUND);
        return responseEntity;
    }

}
