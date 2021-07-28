package com.example.mental_arithmetic.challenge;

import com.example.mental_arithmetic.serviceclients.GamificationServiceClient;
import com.example.mental_arithmetic.user.User;
import com.example.mental_arithmetic.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

    private final UserRepository userRepository;
    private final ChallengeAttemptRepository attemptRepository;
    private final GamificationServiceClient gameClient;

    @Override
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDTO attemptDTO) {
        // Check if the user already exists for that alias, otherwise create it
        User user = userRepository.findByAlias(attemptDTO.getUserAlias())
                .orElseGet(() -> {
                    log.info("Creating new user with alias {}",
                            attemptDTO.getUserAlias());
                    return userRepository.save(
                            new User(attemptDTO.getUserAlias())
                    );
                });
        // Check if the attempt is correct
        boolean isCorrect = attemptDTO.getGuess() == attemptDTO.getFactorA() * attemptDTO.getFactorB();


        // Stores the attempt
        ChallengeAttempt storedAttempt = attemptRepository.save(new ChallengeAttempt(null,
                user,
                attemptDTO.getFactorA(),
                attemptDTO.getFactorB(),
                attemptDTO.getGuess(),
                isCorrect
        ));

        // Sends the attempt to gamification and prints the response
        boolean status = gameClient.sendAttempt(storedAttempt);
        log.info("Gamification service response: {}", status);

        return storedAttempt;
    }

    @Override
    public List<ChallengeAttempt> getStatsForUser(String userAlias) {
        return attemptRepository.findTop10ByUserAliasOrderByIdDesc(userAlias);
    }
}
