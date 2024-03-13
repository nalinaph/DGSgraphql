package com.assignmentevent.graphql.util;

import com.assignmentevent.graphql.Datamodule.entity.EventsEntity;
import com.assignmentevent.graphql.Datamodule.entity.UsersEntity;
import com.assignmentevent.graphql.generated.types.Event;
import com.assignmentevent.graphql.generated.types.EventInput;
import com.assignmentevent.graphql.generated.types.User;
import com.assignmentevent.graphql.generated.types.UserInput;
import com.netflix.graphql.dgs.DgsComponent;

import java.time.ZoneOffset;
@DgsComponent

public class GraphqlBeanMapper {
    private static final ZoneOffset ZONE_OFFSET = ZoneOffset.UTC;
    public static User mapToGraph(UsersEntity original) {
        User result = new User();
        result.setUId(original.getCustId());
        result.setFirstName(original.getFirstName());
        result.setSecondName(original.getSecondName());
        return result;

    }

    public static UsersEntity mapToEntity(UserInput userInput)
    {
        UsersEntity result1 = new UsersEntity();
        result1.setFirstName(userInput.getFirstName());
        result1.setSecondName(userInput.getSecondName());
        return result1;
    }

    public static Event mapToGraphEvent(EventsEntity original)
    {
        Event result = new Event();
        result.setEId(original.getEventId());
        result.setEventName(original.getEventName());
        result.setLocation(original.getLocation());
        result.setOrganizer(original.getOrganizer());
        result.setDuration(original.getDuration());
        result.setDateTime(original.getDateTime().atOffset(ZONE_OFFSET));
       // result.setUser(new User());
        return result;
    }

    public static EventsEntity mapToEventEntity(EventInput eventInput, UsersEntity usersEntity)
    {
        EventsEntity result1 = new EventsEntity();
        result1.setUsersEntity(usersEntity);
        result1.setEventName(eventInput.getEventName());
        result1.setLocation(eventInput.getLocation());
        result1.setOrganizer(eventInput.getOrganizer());
        result1.setDuration(eventInput.getDuration());
       // result1.setDateTime(eventInput.);
        return  result1;

    }

}
