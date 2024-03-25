package com.kurepin.rosatomtest.dto;

import com.kurepin.rosatomtest.entities.Topic;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class MessageDto {
    private Long id;
    private String username;
    private String content;
    private OffsetDateTime creationDate;
    private Long topicId;
}