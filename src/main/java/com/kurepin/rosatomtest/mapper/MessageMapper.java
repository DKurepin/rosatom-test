package com.kurepin.rosatomtest.mapper;

import com.kurepin.rosatomtest.dto.MessageDto;
import com.kurepin.rosatomtest.entities.Message;
import com.kurepin.rosatomtest.entities.Topic;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@RequiredArgsConstructor
@Data
@Component
public class MessageMapper {
    private final ModelMapper modelMapper;
    public Message toEntity(MessageDto messageDto, Topic topic) throws ParseException {
        Message message = modelMapper.map(messageDto, Message.class);
        message.setTopicId(topic);
        return message;
    }
}
