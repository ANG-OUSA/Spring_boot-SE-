package com.lambdacode.spring.boot.crud.service.impl;

import com.lambdacode.spring.boot.crud.entity.Topics;
import com.lambdacode.spring.boot.crud.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void addTopic(Topics topic) {
        topicRepository.save(topic);
    }

    @Override
    public List<Topics> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public Topics getTopic(Long id) {
        return topicRepository.findById(id).orElse(null);
    }

    @Override
    public void updateTopic(Long id, Topics topic) {
        topicRepository.findById(id).ifPresent(existingTopic -> {
            existingTopic.setTopicTitle(topic.getTopicTitle());
            // other properties...

            topicRepository.save(existingTopic);
        });
    }

    @Override
    public void deleteTopic(Long id) {
        topicRepository.findById(id).ifPresent(topicRepository::delete);
    }
}
