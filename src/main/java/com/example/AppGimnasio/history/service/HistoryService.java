package com.example.AppGimnasio.history.service;

import com.example.AppGimnasio.clientProfile.domain.ClientProfileEntity;
import com.example.AppGimnasio.clientProfile.repository.ClientRepository;
import com.example.AppGimnasio.common.exception.ClientNotFoundException;
import com.example.AppGimnasio.enrollment.dto.EnrollmentResponse;
import com.example.AppGimnasio.enrollment.service.IEnrollmentService;
import com.example.AppGimnasio.history.dto.ClientHistoryResponse;
import com.example.AppGimnasio.payment.dto.PaymentResponse;
import com.example.AppGimnasio.payment.service.IPaymentService;
import com.example.AppGimnasio.progress.dto.ProgressResponse;
import com.example.AppGimnasio.progress.service.IProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HistoryService implements IHistoryService {

    private final ClientRepository clientRepository;
    private final IEnrollmentService enrollmentService;
    private final IPaymentService paymentService;
    private final IProgressService progressService;

    @Override
    public ClientHistoryResponse getClientHistory(UUID clientUserExternalId) {

        ClientProfileEntity client = clientRepository
                .findByUserExternalId(clientUserExternalId)
                .orElseThrow(() ->
                        new ClientNotFoundException("Perfil de cliente no encontrado."));

        String clientName = client.getUser().getFirstName() + " " + client.getUser().getLastName();

        List<EnrollmentResponse> enrollments =
                enrollmentService.findByClient(clientUserExternalId);

        List<ProgressResponse> progressRecords =
                progressService.findByClient(clientUserExternalId);

        List<PaymentResponse> payments = enrollments.stream()
                .flatMap(enrollment ->
                        paymentService.findByEnrollment(enrollment.externalId()).stream())
                .toList();

        return new ClientHistoryResponse(
                clientUserExternalId,
                clientName,
                enrollments,
                payments,
                progressRecords
        );
    }
}
