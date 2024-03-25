package com.kurepin.rosatomtest.services;

import com.kurepin.rosatomtest.dto.TopicDto;
import com.kurepin.rosatomtest.entities.Topic;

import java.util.List;

public interface TopicService {
    void deleteTopicById(Long id);
    TopicDto getTopicById(Long id);
    List<TopicDto> getAllTopics();
    Topic saveTopic(Topic topic);
    Topic updateTopic(Topic topic);
}
