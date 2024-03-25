package com.kurepin.rosatomtest.mapper;

import com.kurepin.rosatomtest.dto.TopicDto;
import com.kurepin.rosatomtest.entities.Topic;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@RequiredArgsConstructor
@Data
@Component
public class TopicMapper {
    private final ModelMapper modelMapper;
    public Topic toEntity(TopicDto topicDto) throws ParseException {
        return modelMapper.map(topicDto, Topic.class);
    }
}
