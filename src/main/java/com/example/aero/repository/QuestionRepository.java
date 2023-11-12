package com.example.aero.repository;

import com.example.aero.dto.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("SELECT q FROM Question q WHERE q.categoryId=:catId")
    List<Question> getQuestionByGroupId(@Param("catId") int catId);
}
