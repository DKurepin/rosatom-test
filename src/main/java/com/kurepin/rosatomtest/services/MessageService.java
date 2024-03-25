package com.kurepin.rosatomtest.services;

import com.kurepin.rosatomtest.dto.MessageDto;
import com.kurepin.rosatomtest.entities.Message;
import com.kurepin.rosatomtest.entities.Topic;

import java.util.List;

public interface MessageService {
    Message saveMessage(Message message);
    MessageDto getMessageById(Long id);
    void deleteMessageById(Long id);
    List<MessageDto> getAllMessages();
    Message updateMessage(Message message);
    List<MessageDto> getMessagesByTopicId(Topic topicId);
}
