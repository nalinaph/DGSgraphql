package com.assignmentevent.graphql.Service.query;

import com.assignmentevent.graphql.Datamodule.entity.EventsEntity;
import com.assignmentevent.graphql.Repository.EventRepository;
import com.assignmentevent.graphql.generated.types.Event;
import com.assignmentevent.graphql.generated.types.EventFilterInputByDateRange;
import com.assignmentevent.graphql.util.GraphqlBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class EventQueryService {

    @Autowired
    public EventRepository eventRepository;

    // Method to get Event detail by EventID


    public Event getEventDetailById(Integer eId) {
        EventsEntity eventsEntity = eventRepository.findById(eId).get();
        return GraphqlBeanMapper.mapToGraphEvent(eventsEntity);

    }

    //Method to get list of events by Date and Duration range

    public List<EventsEntity> listOfEventsByDateAndDuration(String startDate, String endDate, int minDuration, int maxDuration)
    {

        List<EventsEntity> allEvents = eventRepository.findAllBydateTimeBetweenAnddurationBetween(startDate, endDate, minDuration, maxDuration);

        return allEvents;


    }

      // List of Events By organizer and attendees Range

    public List<EventsEntity> listEventsByDateAndDuration(String organizer, Integer attendees) {
        List<EventsEntity> allEvents1=eventRepository.findAllByorganizerAndnumberOfAttendees(organizer,attendees);
        return allEvents1;

    }
}
