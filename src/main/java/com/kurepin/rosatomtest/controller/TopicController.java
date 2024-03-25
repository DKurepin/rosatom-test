package com.kurepin.rosatomtest.controller;

import com.kurepin.rosatomtest.dto.TopicDto;
import com.kurepin.rosatomtest.entities.Topic;
import com.kurepin.rosatomtest.mapper.MessageMapper;
import com.kurepin.rosatomtest.mapper.TopicMapper;
import com.kurepin.rosatomtest.services.MessageService;
import com.kurepin.rosatomtest.services.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/topic")
public class TopicController {
    private final MessageService messageService;
    private final TopicService topicService;
    private final MessageMapper messageMapper;
    private final TopicMapper topicMapper;

    @GetMapping("/all")
    public List<TopicDto> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public TopicDto getTopicById(Long id) {
        return topicService.getTopicById(id);
    }

    @PostMapping("/add")
    public Topic addTopic(TopicDto topicDto) throws ParseException {
        return topicService.saveTopic(topicMapper.toEntity(topicDto));
    }

    @PutMapping("/update/{id}")
    public Topic updateTopic(Long id, TopicDto topicDto) throws ParseException {
        Topic topic = topicMapper.toEntity(topicDto);
        topic.setId(id);
        return topicService.updateTopic(topic);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTopic(Long id) {
        topicService.deleteTopicById(id);
    }
}
