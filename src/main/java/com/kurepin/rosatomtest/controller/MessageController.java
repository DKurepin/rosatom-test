package com.kurepin.rosatomtest.controller;

import com.kurepin.rosatomtest.dto.MessageDto;
import com.kurepin.rosatomtest.dto.TopicDto;
import com.kurepin.rosatomtest.entities.Message;
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
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;
    private final TopicService topicService;
    private final MessageMapper messageMapper;
    private final TopicMapper topicMapper;

    @GetMapping("/all")
    public List<MessageDto> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public MessageDto getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    @GetMapping("/topic/{topicId}")
    public List<MessageDto> getMessagesByTopicId(@PathVariable Long topicId) throws ParseException {
        TopicDto topicDto = topicService.getTopicById(topicId);
        Topic topic = topicMapper.toEntity(topicDto);
        return messageService.getMessagesByTopicId(topic);
    }

    @PostMapping("/add")
    public Message addMessage(@RequestBody MessageDto messageDto) throws ParseException {
        TopicDto topicDto = topicService.getTopicById(messageDto.getTopicId());
        System.out.println(topicDto);
        Topic topic = topicMapper.toEntity(topicDto);
        Message message = messageMapper.toEntity(messageDto, topic);
        System.out.println(message);
        return messageService.saveMessage(message);
    }

    @PutMapping("/update/{id}")
    public Message updateMessage(@PathVariable Long id, @RequestBody MessageDto messageDto) throws ParseException {
        TopicDto topicDto = topicService.getTopicById(messageDto.getTopicId());
        Topic topic = topicMapper.toEntity(topicDto);
        Message message = messageMapper.toEntity(messageDto, topic);
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessageById(id);
    }
}
