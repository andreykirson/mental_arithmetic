package com.example.mental_arithmetic.challenge;

import com.example.mental_arithmetic.user.User;

public class ChallengeServiceImpl implements ChallengeService{
    @Override
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDTO resultAttempt) {
        // Check if the attempt is correct
        boolean isCorrect = resultAttempt.getGuess() == resultAttempt.getFactorA() * resultAttempt.getFactorB();
        User user = new User(null, resultAttempt.getUserAlias());
        // Builds the domain object. Null id for now.
        ChallengeAttempt checkedAttempt = new ChallengeAttempt(null,
                user,
                resultAttempt.getFactorA(),
                resultAttempt.getFactorB(),
                resultAttempt.getGuess(),
                isCorrect
        );
        return checkedAttempt;
    }
}
