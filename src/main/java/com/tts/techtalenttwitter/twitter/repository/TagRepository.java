package com.tts.techtalenttwitter.twitter.repository;

import org.springframework.stereotype.Repository;

import com.tts.techtalenttwitter.twitter.model.Tag;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    Tag findByPhrase(String phrase);
}