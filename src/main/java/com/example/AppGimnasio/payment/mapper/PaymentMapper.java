package com.example.AppGimnasio.payment.mapper;

import com.example.AppGimnasio.payment.domain.PaymentEntity;
import com.example.AppGimnasio.payment.dto.PaymentCreateRequest;
import com.example.AppGimnasio.payment.dto.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "enrollment", ignore = true)
    @Mapping(target = "amount", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "date", ignore = true)
    PaymentEntity toEntity(PaymentCreateRequest request);

    @Mapping(target = "enrollmentExternalId", source = "enrollment.externalId")
    PaymentResponse toResponse(PaymentEntity entity);
}
