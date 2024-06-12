package com.Ml_Dhia.QuizApp.controller;

import com.Ml_Dhia.QuizApp.model.Question;
import com.Ml_Dhia.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions ( ){
        return  questionService.getAllQuestions() ;
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory (@PathVariable String category){
        return  questionService.getQuestionsByCategory(category);
    }
}
