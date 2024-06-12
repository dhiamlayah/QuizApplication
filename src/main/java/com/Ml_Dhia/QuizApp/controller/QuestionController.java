package com.Ml_Dhia.QuizApp.controller;

import com.Ml_Dhia.QuizApp.model.Question;
import com.Ml_Dhia.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("add")
    public String addQuestion (@RequestBody  Question question){
        return  questionService.addQuestion(question);
    }


}
