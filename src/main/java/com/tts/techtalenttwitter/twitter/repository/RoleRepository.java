package com.tts.techtalenttwitter.twitter.repository;

import com.tts.techtalenttwitter.twitter.model.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
    Role findByRole(String role);
}