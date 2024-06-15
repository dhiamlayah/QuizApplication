package com.Ml_Dhia.QuizApp.service;

import com.Ml_Dhia.QuizApp.dao.QuestionDao;
import com.Ml_Dhia.QuizApp.dao.QuizDao;
import com.Ml_Dhia.QuizApp.model.Question;
import com.Ml_Dhia.QuizApp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao ;

    @Autowired
    QuestionDao questionDao ;
    public  ResponseEntity<String> createQuiz (String category , int numOfQuestions , String Title){
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category ,numOfQuestions);
        Quiz quiz = new Quiz() ;
        quiz.setTitle(Title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return  new ResponseEntity<String>("success", HttpStatus.OK);

    }
}
