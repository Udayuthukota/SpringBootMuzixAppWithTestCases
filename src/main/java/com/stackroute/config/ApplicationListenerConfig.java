package com.stackroute.config;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
class ApplicationListenerConfig implements org.springframework.context.ApplicationListener<ContextRefreshedEvent> {
    @Autowired
   TrackRepository trackRepository;
    @Value("0")
    private int trackId;
    @Value("default listner")
    private String trackName;
    @Value("default comments")
    private String trackComment;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Track track=new Track(trackId,trackName,trackComment);
        trackRepository.save(track);

    }


}