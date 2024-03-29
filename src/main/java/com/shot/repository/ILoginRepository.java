package com.shot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shot.model.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, Integer> {

}
