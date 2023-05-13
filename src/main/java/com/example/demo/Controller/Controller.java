package com.example.demo.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Quizz;
import com.example.demo.repo.quizRepo;


@RestController
@RequestMapping("/api/quizzes")
public class Controller {
	
	@Autowired
	private quizRepo repo;
	
	@GetMapping
	public String home() {
		
		return "Welcome to Quizz";
	}
	
	@PostMapping("/create")
	public Quizz createQuiz(@RequestBody Quizz quiz) {
        quiz.setActive(true);
        return repo.save(quiz);
    }
	
	@GetMapping("/active")
    public Quizz getActiveQuiz() {
        LocalDateTime now = LocalDateTime.now();
        return repo.findByStartDateBeforeAndEndDateAfterAndActiveTrue(now, now);
    }
	
	@GetMapping("/{quizId}/result")
    public String getQuizResult(@PathVariable Long quizId) throws NotFoundException {
        Quizz quiz = repo.findById(quizId).orElseThrow(() -> new NotFoundException());
        if (quiz.getEndDate().plusMinutes(5).isAfter(LocalDateTime.now())) {
        	ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Quiz result not available yet");
        }
        return quiz.getRightAnswer();
    }
	
	@GetMapping("/all")
	public List<Quizz> getAll(){
		
		return repo.findAll();
	}


}
