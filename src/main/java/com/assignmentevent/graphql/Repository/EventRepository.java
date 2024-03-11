package com.assignmentevent.graphql.Repository;

import com.assignmentevent.graphql.Datamodule.entity.EventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventsEntity,Integer> {
}
