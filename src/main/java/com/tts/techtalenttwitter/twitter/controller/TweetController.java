package com.tts.techtalenttwitter.twitter.controller;

import java.util.List;

import javax.validation.Valid;

import com.tts.techtalenttwitter.twitter.model.Tweet;
import com.tts.techtalenttwitter.twitter.model.User;
import com.tts.techtalenttwitter.twitter.service.TweetService;
import com.tts.techtalenttwitter.twitter.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TweetController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;

    @GetMapping(value = {"/tweets", "/"})
    public String getFeed(Model model){
        List<Tweet> tweets = tweetService.findAll();
        model.addAttribute("tweetList", tweets);
        return "feed";
    }

    @GetMapping(value = "/tweet/new")
    public String getTweetForm(Model model){
        model.addAttribute("tweet", new Tweet());
        return "newTweet";
    }

    @PostMapping(value = "/tweets")
    public String submitTweetForm(@Valid Tweet tweet, BindingResult bindingResult, Model model){
        User user = userService.getLoggedInUser();
       if(!bindingResult.hasErrors()){
           tweet.setUser(user);
           tweetService.save(tweet);
           model.addAttribute("successMessage", "Tweet Successfully Created");
           model.addAttribute("tweet", new Tweet());
       }
       return "newTweet";
    }
}