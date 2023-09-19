package com.pet.sumpro.controller;

import com.pet.sumpro.dtos.FormDataDto;
import com.pet.sumpro.services.MoneyWritingService;
import com.pet.sumpro.validation.PatternValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Slf4j
public class MoneyController {
    private final MoneyWritingService moneyWritingService;
    private final PatternValidator patternValidator;
    @PostMapping("/convert")
    public ResponseEntity<?> getConvertMoney(@RequestBody FormDataDto data) {
        if (patternValidator.isMatches(data)) {
           return ResponseEntity.of(Optional.of(moneyWritingService.getMoneyWriting(data)));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect data");
        }

    }
}
