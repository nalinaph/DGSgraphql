package com.assignmentevent.graphql.Resolver;

import com.assignmentevent.graphql.Service.command.EventService;
import com.assignmentevent.graphql.generated.types.Event;
import com.assignmentevent.graphql.generated.types.EventInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent

public class EventMutationResolver {
@Autowired
private EventService eventService;

@DgsMutation

public Event createEvent (@InputArgument EventInput eventInput, @InputArgument Integer uId)

{

    Event event = eventService.createEvent(eventInput, uId);
    return event;
}

@DgsMutation
  //  @DgsData(parentType = "Mutation", field = "updateEvent")
    public Event updateEvent(@InputArgument Integer eId, @InputArgument EventInput eventInput) {
        return eventService.updateEvent(eId, eventInput);
    }

}
