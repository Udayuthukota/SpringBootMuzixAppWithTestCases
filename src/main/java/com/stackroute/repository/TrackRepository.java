package com.stackroute.repository;
import com.stackroute.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer> {
   // @Query("select track from Track track where track.trackName=?1")
     List<Track> findTrackByName(String name);

}
