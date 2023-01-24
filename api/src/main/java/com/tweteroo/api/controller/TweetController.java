package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.service.TweetService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tweets")
public class TweetController {

    @Autowired
    private TweetService service;

    @PostMapping
    public ResponseEntity<Void> save(@RequestHeader("User") String username, @RequestBody TweetDTO req){

         service.save(username, req);
         return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Page<Tweet> listTweets(@RequestParam String page) {
        return service.listTweets(page);
      }

      @GetMapping("/{username}")
    public List<Tweet> listUserTweets(@PathVariable String username) {
        return service.listUserTweets(username);
      }
}
