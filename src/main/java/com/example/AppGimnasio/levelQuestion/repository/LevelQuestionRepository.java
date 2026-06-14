package com.example.AppGimnasio.levelQuestion.repository;

import com.example.AppGimnasio.levelQuestion.domain.LevelQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelQuestionRepository extends JpaRepository<LevelQuestionEntity,Integer> {
}
