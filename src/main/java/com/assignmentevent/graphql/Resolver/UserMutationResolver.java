package com.assignmentevent.graphql.Resolver;

import com.assignmentevent.graphql.Service.command.UserService;
import com.assignmentevent.graphql.generated.types.User;
import com.assignmentevent.graphql.generated.types.UserInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent

public class UserMutationResolver {

    private final UserService userService;
    @Autowired
    public UserMutationResolver(UserService userService) {
        this.userService = userService;
    }

    @DgsMutation
    public User createUser(@InputArgument UserInput userInput) {

        return userService.createUser(userInput);
    }

}
