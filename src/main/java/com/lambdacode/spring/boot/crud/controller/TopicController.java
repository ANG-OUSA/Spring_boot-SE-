package com.lambdacode.spring.boot.crud.controller;

import com.lambdacode.spring.boot.crud.entity.Topics;
import com.lambdacode.spring.boot.crud.service.impl.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping("/add")
    public ResponseEntity<String> addTopic(@RequestBody Topics topic) {
        topicService.addTopic(topic);
        return ResponseEntity.ok("Topic added successfully");
    }

    @GetMapping
    public List<Topics> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topics> getTopic(@PathVariable Long id) {
        Topics topic = topicService.getTopic(id);
        return ResponseEntity.ok(topic);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTopic(@PathVariable Long id, @RequestBody Topics topic) {
        topicService.updateTopic(id, topic);
        return ResponseEntity.ok("Topic updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.ok("Topic deleted successfully");
    }
}
