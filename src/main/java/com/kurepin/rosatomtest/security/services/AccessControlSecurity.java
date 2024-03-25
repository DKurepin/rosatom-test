package com.kurepin.rosatomtest.security.services;

import com.kurepin.rosatomtest.entities.Message;
import com.kurepin.rosatomtest.entities.Topic;
import com.kurepin.rosatomtest.repositories.MessageRepository;
import com.kurepin.rosatomtest.repositories.TopicRepository;
import com.kurepin.rosatomtest.security.models.Role;
import com.kurepin.rosatomtest.security.models.User;
import com.kurepin.rosatomtest.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccessControlSecurity {
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final TopicRepository topicRepository;


    public boolean messageIsAllowed(String username, Long messageId) {
        return isAdmin(username) || getMessage(messageId).getUsername().equals(username);
    }
    public Message getMessage(String username) {
        return messageRepository.getReferenceById(getUser(username).getMessageId().getId());
    }
    public boolean topicIsAllowed(String username, Long topicId) {
        return isAdmin(username) || getTopic(topicId).equals(getMessage(username).getTopicId());
    }
    public Topic getTopic(String username) {
        return topicRepository.getReferenceById(getMessage(username).getTopicId().getId());
    }

    public boolean isAdmin(String username) {
        return getUser(username).getRole().equals(Role.ADMIN);
    }

    private User getUser(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }


    private Topic getTopic(Long topicId) {
        return topicRepository.getReferenceById(topicId);
    }
    private Message getMessage(Long messageId) {
        return messageRepository.getReferenceById(messageId);
    }

}
