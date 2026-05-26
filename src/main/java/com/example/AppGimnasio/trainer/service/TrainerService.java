package com.example.AppGimnasio.trainer.service;

import com.example.AppGimnasio.common.exception.TrainerNotFoundException;
import com.example.AppGimnasio.common.exception.UserNotFoundException;
import com.example.AppGimnasio.trainer.domain.TrainerProfileEntity;
import com.example.AppGimnasio.trainer.dto.TrainerCreateRequest;
import com.example.AppGimnasio.trainer.dto.TrainerResponse;
import com.example.AppGimnasio.trainer.dto.TrainerUpdateRequest;
import com.example.AppGimnasio.trainer.mapper.TrainerMapper;
import com.example.AppGimnasio.trainer.repository.TrainerRepository;
import com.example.AppGimnasio.user.domain.UserEntity;
import com.example.AppGimnasio.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrainerService implements ITrainerService {

    private final TrainerRepository trainerRepository;

    private final UserRepository userRepository;

    private final TrainerMapper trainerMapper;

    @Override
    public TrainerResponse create(
            TrainerCreateRequest request
    ) {

        UserEntity user = userRepository
                .findByExternalIdAndDeletedAtIsNull(
                        request.userExternalId()
                )
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "Usuario no encontrado."
                        ));

        TrainerProfileEntity trainer =
                TrainerProfileEntity.builder()
                        .user(user)
                        .bio(request.bio())
                        .instagram(request.instagram())
                        .whatsapp(request.whatsapp())
                        .build();

        trainer = trainerRepository.save(trainer);

        return trainerMapper.toResponse(trainer);
    }

    @Override
    public List<TrainerResponse> findAll() {

        return trainerRepository.findAll()
                .stream()
                .map(trainerMapper::toResponse)
                .toList();
    }

    @Override
    public TrainerResponse findByUserExternalId(
            UUID userExternalId
    ) {

        TrainerProfileEntity trainer =
                trainerRepository
                        .findByUserExternalId(
                                userExternalId
                        )
                        .orElseThrow(() ->
                                new TrainerNotFoundException(
                                        "Perfil de entrenador no encontrado."
                                ));

        return trainerMapper.toResponse(trainer);
    }

    @Override
    public  TrainerResponse update(
            UUID userExternalId,
            TrainerUpdateRequest request
    ) {

        TrainerProfileEntity trainer =
                trainerRepository
                        .findByUserExternalId(
                                userExternalId
                        )
                        .orElseThrow(() ->
                                new TrainerNotFoundException(
                                        "Perfil de entrenador no encontrado."
                                ));

        trainer.setBio(request.bio());
        trainer.setVerified(request.verified());
        trainer.setInstagram(request.instagram());
        trainer.setWhatsapp(request.whatsapp());

        trainer = trainerRepository.save(trainer);

        return trainerMapper.toResponse(trainer);
    }

    @Override
    public void delete(
            UUID userExternalId
    ) {

        TrainerProfileEntity trainer =
                trainerRepository
                        .findByUserExternalId(
                                userExternalId
                        )
                        .orElseThrow(() ->
                                new TrainerNotFoundException(
                                        "Perfil de entrenador no encontrdo."
                                ));

        trainerRepository.delete(trainer);
    }
}
