package com.kurepin.rosatomtest.services;

import com.kurepin.rosatomtest.dto.MessageDto;
import com.kurepin.rosatomtest.entities.Message;
import com.kurepin.rosatomtest.entities.Topic;
import com.kurepin.rosatomtest.repositories.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    @Autowired
    private final MessageRepository messageRepository;
    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public MessageDto getMessageById(Long id) {
        Message message = messageRepository.getReferenceById(id);
        MessageDto messageDto = MessageDto.builder()
                .id(message.getId())
                .username(message.getUsername())
                .content(message.getContent())
                .creationDate(message.getCreationDate())
                .topicId(message.getTopicId().getId())
                .build();
        return messageDto;
    }

    @Override
    public void deleteMessageById(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public List<MessageDto> getAllMessages() {
        List<Message> messages = messageRepository.findAll();
        List<MessageDto> messageDtos = messages.stream().map(message -> MessageDto.builder()
                .id(message.getId())
                .username(message.getUsername())
                .content(message.getContent())
                .creationDate(message.getCreationDate())
                .topicId(message.getTopicId().getId())
                .build()).toList();
        return messageDtos;
    }

    @Override
    public Message updateMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<MessageDto> getMessagesByTopicId(Topic topicId) {
        List<Message> messages = messageRepository.getMessagesByTopicId(topicId);
        List<MessageDto> messageDtos = messages.stream().map(message -> MessageDto.builder()
                .id(message.getId())
                .username(message.getUsername())
                .content(message.getContent())
                .creationDate(message.getCreationDate())
                .topicId(message.getTopicId().getId())
                .build()).toList();
        return messageDtos;
    }
}
