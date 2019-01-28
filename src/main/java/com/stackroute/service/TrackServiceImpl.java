package com.stackroute.service;
import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
//service implemntation class where the actual bussiness logic goes
@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    //saving a track method
    @Override
    public Track saveTrack(Track track)throws  TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        else {
            Track savedTrack = trackRepository.save(track);
            return savedTrack;
        }

    }
    //getting all the tracks
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
    //getting particular tracks by id
    @Override
    public  Optional<Track> getTrackById(int id) throws TrackNotFoundException{
        if(trackRepository.existsById(id)) {
            Optional<Track> getTrack = trackRepository.findById(id);
            return getTrack;
        }
        else
        {
            throw new TrackNotFoundException("Track not present");
        }

    }
    //updating a new track with existing one or if not fond it saves as a new one
    @Override
    public Track updateTrackComments(String trackComments,int trackId)throws TrackNotFoundException {
        if(!trackRepository.existsById(trackId)){
            throw new TrackNotFoundException("Track to update not found");
        }

        Track updateMusic = trackRepository.findById(trackId).get();
        updateMusic.setTrackComment(trackComments);
        return trackRepository.save(updateMusic);



       }


    //deleting a track method
    @Override
    public boolean deleteTrackById(int trackId) throws TrackNotFoundException {
        if(trackRepository.existsById(trackId)) {
            trackRepository.deleteById(trackId);
        }
        else
        {
            throw new TrackNotFoundException("Track Not found");
        }
        return true;
    }
   // finding a track by name
    @Override
    public List<Track> findTrackByName(String trackName)  {
        return trackRepository.findTrackByName(trackName);

    }
}
