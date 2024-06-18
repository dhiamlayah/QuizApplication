package com.Ml_Dhia.QuizApp.service;

import com.Ml_Dhia.QuizApp.dao.QuestionDao;
import com.Ml_Dhia.QuizApp.dao.QuizDao;
import com.Ml_Dhia.QuizApp.model.Question;
import com.Ml_Dhia.QuizApp.model.QuestionWrapper;
import com.Ml_Dhia.QuizApp.model.Quiz;
import com.Ml_Dhia.QuizApp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions (int id ){
        Optional<Quiz> getQuizFromDB =    quizDao.findById(id);
        List<Question> getQuestionsFromQuiz = getQuizFromDB.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for (Question q :getQuestionsFromQuiz  ){
            QuestionWrapper questionWrapper = new QuestionWrapper(q.getId() , q.getQuestion() , q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionForUser.add(questionWrapper);
        }

        return new  ResponseEntity<>(questionForUser , HttpStatus.OK);
    }

    public ResponseEntity<Integer> getSubmitResult(int id, List<Response> response) {
        Optional<Quiz> getQuizFromDB =    quizDao.findById(id);
        List<Question> getQuestionsFromQuiz = getQuizFromDB.get().getQuestions();
        int trueResponse = 0 ;
        for (Response R :response  ){
            for (Question Q : getQuestionsFromQuiz){
                if(Q.getId() == R.getId() && Q.getResponse().equals( R.getUserResponse()) ){
                    trueResponse++ ;
                }
            }
        }
        return  new ResponseEntity<>(trueResponse , HttpStatus.OK);
    }
}
