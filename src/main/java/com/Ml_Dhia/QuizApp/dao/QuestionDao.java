package com.Ml_Dhia.QuizApp.dao;

import com.Ml_Dhia.QuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {


}
