package com.assignmentevent.graphql.Repository;

import com.assignmentevent.graphql.Datamodule.entity.EventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<EventsEntity,Integer> {
    List<EventsEntity> findAllByDateTimeBetweenAndDurationBetween(
            LocalDateTime startDate,
            LocalDateTime endDate,
            int minDuration,
            int maxDuration
    );
}
