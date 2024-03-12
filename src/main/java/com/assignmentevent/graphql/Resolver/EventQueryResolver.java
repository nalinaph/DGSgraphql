package com.assignmentevent.graphql.Resolver;

import com.assignmentevent.graphql.Datamodule.entity.EventsEntity;
import com.assignmentevent.graphql.Service.query.EventQueryService;
import com.assignmentevent.graphql.generated.types.Event;
import com.assignmentevent.graphql.generated.types.EventFilterInputByDateRange;
import com.assignmentevent.graphql.util.GraphqlBeanMapper;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.time.LocalDateTime;
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

    //Method to get list of events by Date and Duration range

    @DgsQuery
    public List<Event> listEventsByDateAndDuration(@InputArgument EventFilterInputByDateRange filter) {

        LocalDateTime startDate = filter.getStartDate().toLocalDateTime();
        LocalDateTime endDate = filter.getEndDate().toLocalDateTime();
       int minDuration = filter.getMinDuration();
        int maxDuration = filter.getMaxDuration();

        List<EventsEntity> list = eventQueryService.listOfEventsByDateAndDuration(startDate, endDate, minDuration, maxDuration);
         return list.stream().map(GraphqlBeanMapper::mapToGraphEvent).toList();
    }



}