package com.example.AppGimnasio.history.controller;

import com.example.AppGimnasio.history.dto.ClientHistoryResponse;
import com.example.AppGimnasio.history.service.IHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
public class HistoryController {

    private final IHistoryService historyService;

    @GetMapping("/client/{clientUserExternalId}")
    public ClientHistoryResponse getClientHistory(
            @PathVariable UUID clientUserExternalId
    ) {
        return historyService.getClientHistory(clientUserExternalId);
    }
}
