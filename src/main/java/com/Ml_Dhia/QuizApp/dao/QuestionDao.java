package com.Ml_Dhia.QuizApp.dao;

import com.Ml_Dhia.QuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    /* we can add this methode and jpa will implement it but if we want to castemize it we should use hql or jpql */
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numOfQuestions", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numOfQuestions);
}
