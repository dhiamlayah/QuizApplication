package com.Ml_Dhia.QuizApp.controller;

import com.Ml_Dhia.QuizApp.model.Question;
import com.Ml_Dhia.QuizApp.model.QuestionWrapper;
import com.Ml_Dhia.QuizApp.model.Response;
import com.Ml_Dhia.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired

    QuizService quizService ;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category , @RequestParam int numOfQuestions , @RequestParam  String Title ){
        return  quizService.createQuiz(category, numOfQuestions, Title) ;
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
        return  quizService.getQuizQuestions( id );
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getSubmitResult (@PathVariable int id ,@RequestBody List<Response> response){
        return  quizService.getSubmitResult(id , response );
    }

}
