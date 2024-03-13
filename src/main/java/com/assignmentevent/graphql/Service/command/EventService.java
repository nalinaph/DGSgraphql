package com.assignmentevent.graphql.Service.command;

import com.assignmentevent.graphql.Datamodule.entity.EventsEntity;
import com.assignmentevent.graphql.Datamodule.entity.UsersEntity;
import com.assignmentevent.graphql.Repository.EventRepository;
import com.assignmentevent.graphql.Repository.UserRepository;
import com.assignmentevent.graphql.generated.types.Event;
import com.assignmentevent.graphql.generated.types.EventInput;
import com.assignmentevent.graphql.generated.types.User;
import com.assignmentevent.graphql.util.GraphqlBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;

    //public Event createEvent(EventInput eventInput, int userId)
    public Event createEvent(EventInput eventInput, Integer uId) {
        EventsEntity eventsEntity = new EventsEntity();
        // event = GraphqlBeanMapper.mapToEventEntity(eventInput);
        UsersEntity usersEntity = userRepository.findById(uId).get();
        eventsEntity = GraphqlBeanMapper.mapToEventEntity(eventInput, usersEntity);
        // event.setUsersEntity(usersEntity);

        EventsEntity eventSaved = eventRepository.save(eventsEntity);
        return GraphqlBeanMapper.mapToGraphEvent(eventSaved);
    }

    public Event updateEvent(int eId, EventInput eventInput) {
        EventsEntity event = new EventsEntity();
        event = eventRepository.findById(eId).orElseThrow(
                () -> new RuntimeException("Event id not found"));

        // event = GraphqlBeanMapper.mapToEventEntity(eventInput,event);
        if (eventInput.getEventName() != null)
            event.setEventName(eventInput.getEventName());
        if (eventInput.getLocation() != null)
            event.setEventName(eventInput.getLocation());
        if (eventInput.getOrganizer() != null)
            event.setEventName(eventInput.getOrganizer());
        return GraphqlBeanMapper.mapToGraphEvent(event);

    }
}




