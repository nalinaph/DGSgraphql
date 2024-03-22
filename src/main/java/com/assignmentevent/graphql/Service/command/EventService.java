package com.assignmentevent.graphql.Service.command;

import com.assignmentevent.graphql.Datamodule.entity.EventsEntity;
import com.assignmentevent.graphql.Datamodule.entity.UsersEntity;
import com.assignmentevent.graphql.Repository.EventRepository;
import com.assignmentevent.graphql.Repository.UserRepository;
import com.assignmentevent.graphql.generated.types.Event;
import com.assignmentevent.graphql.generated.types.EventInput;
import com.assignmentevent.graphql.generated.types.UpdateInput;
import com.assignmentevent.graphql.generated.types.User;
import com.assignmentevent.graphql.util.GraphqlBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
      private final EventRepository eventRepository;
    private final UserRepository userRepository;


    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }


    // create Event
    public Event createEvent(EventInput eventInput, Integer uId) {
        EventsEntity eventsEntity = new EventsEntity();
        // event = GraphqlBeanMapper.mapToEventEntity(eventInput);
        UsersEntity usersEntity = userRepository.findById(uId).get();
        eventsEntity = GraphqlBeanMapper.mapToEventEntity(eventInput, usersEntity);
        // event.setUsersEntity(usersEntity);

        EventsEntity eventSaved = eventRepository.save(eventsEntity);
        return GraphqlBeanMapper.mapToGraphEvent(eventSaved);
    }

    // Update Event
    public Event updateEvent(int eId, UpdateInput udpateInput) {
        EventsEntity event = new EventsEntity();
        event = eventRepository.findById(eId).orElseThrow(
                ()-> new RuntimeException("Event Id not found")
        );

        if (udpateInput.getEventName() != null)
            event.setEventName(udpateInput.getEventName());
       if (udpateInput.getLocation() != null)
            event.setLocation(udpateInput.getLocation());
        if (udpateInput.getOrganizer() != null)
            event.setOrganizer(udpateInput.getOrganizer());
        if (udpateInput.getAttendees() != null)
            event.setNumberOfAttendees(udpateInput.getAttendees());
       if (udpateInput.getDuration() != null)
            event.setDuration(udpateInput.getDuration());
        event.setDateTime(udpateInput.getDate());


        return GraphqlBeanMapper.mapToGraphEvent(event);

    }
}




