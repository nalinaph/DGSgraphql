package com.assignmentevent.graphql.Repository;

import com.assignmentevent.graphql.Datamodule.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
}
