package com.assignmentevent.graphql.util;

import com.assignmentevent.graphql.Datamodule.entity.UsersEntity;
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
}
