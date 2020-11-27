package com.toni.spring.rest.REPOSITORY;

import com.toni.spring.rest.MODEL.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonInterface extends JpaRepository<Person, Long> {


}
