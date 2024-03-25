package com.kurepin.rosatomtest.services;

import com.kurepin.rosatomtest.dto.TopicDto;
import com.kurepin.rosatomtest.entities.Topic;
import com.kurepin.rosatomtest.repositories.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicServiceImpl implements TopicService {
    @Autowired
    private final TopicRepository topicRepository;
    @Override
    public void deleteTopicById(Long id) {
        topicRepository.deleteById(id);
    }

    @Override
    public TopicDto getTopicById(Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        TopicDto topicDto = TopicDto.builder()
                .id(topic.getId())
                .title(topic.getTitle())
                .build();
        return topicDto;
    }

    @Override
    public List<TopicDto> getAllTopics() {
        List<Topic> topics = topicRepository.findAll();
        List<TopicDto> topicDtos = topics.stream().map(topic -> TopicDto.builder()
                .id(topic.getId())
                .title(topic.getTitle())
                .build()).toList();
        return topicDtos;
    }

    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public Topic updateTopic(Topic topic) {
        return topicRepository.save(topic);
    }
}
