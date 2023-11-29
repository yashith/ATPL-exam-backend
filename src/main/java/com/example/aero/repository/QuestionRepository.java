package com.example.aero.repository;

import com.example.aero.dto.Question;
import com.example.aero.model.QCatLim;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("SELECT q FROM Question q WHERE q.subModuleId=:catId")
    List<Question> getQuestionByGroupId(@Param("catId") int catId);

    @Query("SELECT q FROM Question q WHERE q.subModuleId in :subModuleList")
    List<Question> getQuestionForCategories(@Param("subModuleList") List<Integer> subModuleList, Pageable pageable);

    @Query("SELECT q FROM Question q WHERE q.subModuleId in :subModuleList")
    List<Question> getAllQuestionForCategories(@Param("subModuleList") List<Integer> subModuleList);
}
