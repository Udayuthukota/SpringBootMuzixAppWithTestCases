package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;
import java.util.Optional;
//Track service interface which is used in service implementation class
public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> getAllTracks();
    public Optional<Track> getTrackById(int id) throws TrackNotFoundException;
    public  Track updateTrack(Track track,int trackId) ;
    public List<Track> deleteTrackById(int id) throws TrackNotFoundException;
    public List<Track> findTrackByName(String trackName);

}
