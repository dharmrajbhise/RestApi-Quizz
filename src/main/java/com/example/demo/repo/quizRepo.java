package com.example.demo.repo;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Quizz;

@Repository
public interface quizRepo extends JpaRepository<Quizz, Long> {

	Quizz findByStartDateBeforeAndEndDateAfterAndActiveTrue(LocalDateTime now, LocalDateTime now2);

	
}
