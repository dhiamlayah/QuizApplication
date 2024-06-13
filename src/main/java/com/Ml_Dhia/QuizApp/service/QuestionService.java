package com.Ml_Dhia.QuizApp.service;

import com.Ml_Dhia.QuizApp.dao.QuestionDao;
import com.Ml_Dhia.QuizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao ;
    public ResponseEntity<List<Question>> getAllQuestions (){
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception error) {
            error.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory (String category){
        try {
            return  new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);

        }catch (Exception error){
            error.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion (Question question ){
        try {
            questionDao.save(question);
            return new ResponseEntity<>("success" , HttpStatus.OK) ;
        }catch (Exception error){
            return new ResponseEntity<>("Error " , HttpStatus.BAD_REQUEST) ;
        }
    }

    public ResponseEntity<String> deleteQuestion (Question question ){
        try {
            questionDao.delete(question);
            return new ResponseEntity<>("success" , HttpStatus.OK) ;
        }catch (Exception error){
            return new ResponseEntity<>("Error " , HttpStatus.BAD_REQUEST) ;
        }
    }
}
