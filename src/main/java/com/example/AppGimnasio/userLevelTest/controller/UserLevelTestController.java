package com.example.AppGimnasio.userLevelTest.controller;

import com.example.AppGimnasio.userLevelTest.dto.SubmitTestRequest;
import com.example.AppGimnasio.userLevelTest.dto.TestResultResponse;
import com.example.AppGimnasio.userLevelTest.dto.UserLevelTestRequest;
import com.example.AppGimnasio.userLevelTest.dto.UserLevelTestResponse;
import com.example.AppGimnasio.userLevelTest.dto.UserLevelTestUpdate;
import com.example.AppGimnasio.userLevelTest.service.UserLevelTestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-level-tests")
@RequiredArgsConstructor
public class UserLevelTestController {

    private final UserLevelTestService userLevelTestService;

    @PostMapping
    public UserLevelTestResponse create(
            @Valid @RequestBody UserLevelTestRequest request) {

        return userLevelTestService.create(request);
    }

    @GetMapping
    public List<UserLevelTestResponse> findAll() {
        return userLevelTestService.findAll();
    }

    @GetMapping("/{id}")
    public UserLevelTestResponse findById(
            @PathVariable Integer id) {

        return userLevelTestService.findById(id);
    }

    @PutMapping("/{id}")
    public UserLevelTestResponse update(
            @PathVariable Integer id,
            @Valid @RequestBody UserLevelTestUpdate request) {

        return userLevelTestService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Integer id) {

        userLevelTestService.delete(id);
    }

    @PostMapping("/submit")
    public TestResultResponse submitTest(
            @RequestBody @Valid SubmitTestRequest request) {

        return userLevelTestService.submitTest(request);
    }
}