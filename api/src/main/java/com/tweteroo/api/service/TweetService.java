package com.tweteroo.api.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository repository;

    @Autowired
    private UserRepository userRepository;
    
    public void save(String username, TweetDTO tweetDTO){

       Optional<User> user = userRepository.findByUsername(username);
        
        if(user.isPresent()){
            Tweet tweet = new Tweet(user.get().getUsername(), user.get().getAvatar(), tweetDTO);
            repository.save(tweet);
       }
       
    }

    public Page<Tweet> listTweets(String page) {
        int pageNumber = Integer.parseInt(page);
        Pageable pageable = PageRequest.of(pageNumber, 5, Sort.by("id").descending());
        return repository.findAll(pageable);
      }

      public List<Tweet> listUserTweets(String username) {
        
        return repository.findByUsername(username);
      }
}
