package com.lambdacode.spring.boot.crud.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lambdacode.spring.boot.crud.entity.Topics;

@Service
public interface TopicService {
    void addTopic(Topics topic);

    List<Topics> getAllTopics();

    Topics getTopic(Long id);

    void updateTopic(Long id, Topics topic);

    void deleteTopic(Long id);
}