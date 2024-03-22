package com.assignmentevent.graphql.Resolver;
import com.assignmentevent.graphql.Datamodule.entity.EventsEntity;
import com.assignmentevent.graphql.Service.query.EventQueryService;
import com.assignmentevent.graphql.generated.types.Event;
import com.assignmentevent.graphql.generated.types.EventFilterInput;
import com.assignmentevent.graphql.generated.types.EventFilterInputByDateRange;
import com.assignmentevent.graphql.util.GraphqlBeanMapper;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.time.LocalDateTime;
//import com.assignmentevent.graphql.Service.query.EventQueryService;
//import com.assignmentevent.graphql.generated.types.Event;
//import com.netflix.graphql.dgs.DgsComponent;
//import com.netflix.graphql.dgs.DgsQuery;
//import com.netflix.graphql.dgs.InputArgument;

import java.util.Date;
import java.util.List;

@DgsComponent

public class EventQueryResolver {

    private EventQueryService eventQueryService;

    // Method to get Event detail by EventID

    @DgsQuery
    public Event getEventDetailById(@InputArgument Integer eId) {
        Event event = eventQueryService.getEventDetailById(eId);
        return event;

    }

   // Method to get list of events by Date and Duration range

    @DgsQuery
    public List<Event> listEventsByAttendeesAndOrganiser(@InputArgument EventFilterInputByDateRange filter) {

       String startDate = filter.getStartDate();
       String endDate = filter.getEndDate();
       // LocalDateTime startDate = filter.getStartDate().toLocalDateTime();
       // LocalDateTime endDate = filter.getEndDate().toLocalDateTime();
       int minDuration = filter.getMinDuration();
        int maxDuration = filter.getMaxDuration();

        List<EventsEntity> list = eventQueryService.listOfEventsByDateAndDuration(startDate, endDate, minDuration, maxDuration);
         return list.stream().map(GraphqlBeanMapper::mapToGraphEvent).toList();
    }

    @DgsQuery
    public List<Event> listEventsByDateAndDuration(@InputArgument EventFilterInput filter)
    {
        String organizer= filter.getOrganizer();
        Integer attendees = filter.getAttendees();
        List<EventsEntity> list1 = eventQueryService.listEventsByDateAndDuration(organizer,attendees);
        return list1.stream().map(GraphqlBeanMapper::mapToGraphEvent).toList();

    }


}