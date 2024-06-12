package com.Ml_Dhia.QuizApp.service;

import com.Ml_Dhia.QuizApp.dao.QuestionDao;
import com.Ml_Dhia.QuizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao ;
    public List<Question> getAllQuestions (){
       return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory (String category){
        return  questionDao.findByCategory(category);
    }
}
