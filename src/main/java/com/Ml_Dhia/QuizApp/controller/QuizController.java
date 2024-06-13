package com.Ml_Dhia.QuizApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizController {

    QuizService quizService ;

    public ResponseEntity<String> createQuiz(@RequestParam String category , @RequestParam int numOfQuestions , @RequestParam  String Title ){
        return  quizService.createQuiz() ;
    }

}
