package com.example.mental_arithmetic.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class ChallengeServiceTest {

    private ChallengeService challengeService;

    @BeforeEach
    public void setUp() {
        challengeService = new ChallengeServiceImpl();
    }

    @Test
    public void checkCorrectAttemptTest() {
        //given
        ChallengeAttemptDTO challengeAttemptDTO = new ChallengeAttemptDTO(50, 60, "Jhon", 3000);
        //when
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(challengeAttemptDTO);
        //then
        then(resultAttempt.isCorrect()).isTrue();
    }

    @Test
    public void checkWrongAttemptTest() {
        //given
        ChallengeAttemptDTO challengeAttemptDTO = new ChallengeAttemptDTO(50, 60, "Jhon", 6000);
        //when
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(challengeAttemptDTO);
        //then
        then(resultAttempt.isCorrect()).isFalse();
    }
}