
package com.spring.angular.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.spring.angular.football.model.FootballPlayer;


@Repository
public interface FootballRepository extends JpaRepository<FootballPlayer, Long>{

}
