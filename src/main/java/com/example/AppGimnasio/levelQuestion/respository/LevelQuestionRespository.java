package com.example.AppGimnasio.levelQuestion.respository;

import com.example.AppGimnasio.levelQuestion.domain.LevelQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelQuestionRespository extends JpaRepository<LevelQuestionEntity,Integer> {
}
