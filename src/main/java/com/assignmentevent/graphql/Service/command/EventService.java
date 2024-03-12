package com.assignmentevent.graphql.Service.command;

import com.assignmentevent.graphql.Datamodule.entity.EventsEntity;
import com.assignmentevent.graphql.Datamodule.entity.UsersEntity;
import com.assignmentevent.graphql.Repository.EventRepository;
import com.assignmentevent.graphql.Repository.UserRepository;
import com.assignmentevent.graphql.generated.types.Event;
import com.assignmentevent.graphql.generated.types.EventInput;
import com.assignmentevent.graphql.util.GraphqlBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    private UserRepository userRepository;

    public Event createEvent(EventInput eventInput, int userId)
    {
        EventsEntity event = new EventsEntity();
        event = GraphqlBeanMapper.mapToEventEntity(eventInput);
        UsersEntity usersEntity = userRepository.findById(userId).get();
       event =  GraphqlBeanMapper.mapToEventEntity(eventInput);
       event.setUsersEntity(usersEntity);
      EventsEntity eventSaved = eventRepository.save(event);
      return GraphqlBeanMapper.mapToGraphEvent(eventSaved);
    }

    public Event updateEvent(int eId, EventInput eventInput)
    {
        EventsEntity event = new EventsEntity();
        event = GraphqlBeanMapper.mapToEventEntity(eventInput);
         event = eventRepository.findById(eId).orElse(null);
        if (event != null) {
            event.setEventName(eventInput.getEventName());
           // event.setEventId(eventInput.getUId());
            event.setOrganizer(event.getOrganizer());
            event.setLocation(event.getLocation());
            event.setDuration(event.getDuration());

            // update other properties if needed
            EventsEntity savedEvent = eventRepository.save(event);
            return  GraphqlBeanMapper.mapToGraphEvent(savedEvent);
        }
        return null;
    }
    }



