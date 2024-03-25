package com.kurepin.rosatomtest.repositories;

import com.kurepin.rosatomtest.entities.Message;
import com.kurepin.rosatomtest.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> getMessagesByTopicId(Topic topicId);
}
