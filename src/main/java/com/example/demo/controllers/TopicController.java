package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Topic;
import com.example.demo.exceptions.TopicNotFoundException;
import com.example.demo.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TopicController
 */
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable int id) {
        Optional<Topic> topicOptional = topicService.getTopic(id);
        if (!topicOptional.isPresent())
            throw new TopicNotFoundException("id " + id);
        return topicOptional.get();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable int id) {
        Topic currentTopic = topicService.getTopic(id).get();
        currentTopic.setName(topic.getName());
        currentTopic.setDescription(topic.getDescription());
        topicService.updateTopic(currentTopic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable int id) {
        topicService.deleteTopic(id);
    }

}