package com.assignmentevent.graphql.Service.command;

import com.assignmentevent.graphql.Datamodule.entity.UsersEntity;
import com.assignmentevent.graphql.Repository.UserRepository;
import com.assignmentevent.graphql.generated.types.User;
import com.assignmentevent.graphql.generated.types.UserInput;
import com.assignmentevent.graphql.util.GraphqlBeanMapper;
import com.netflix.graphql.dgs.DgsMutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @DgsMutation
    public User createUser(UserInput userInput) {
        UsersEntity user = new UsersEntity();
        user = GraphqlBeanMapper.mapToEntity(userInput);
       // user.setFirstName(userInput.getFirstName());
        //user.setSecondName(userInput.getSecondName());
        UsersEntity saveduser = userRepository.save(user);
        return GraphqlBeanMapper.mapToGraph((saveduser));
    }
}
