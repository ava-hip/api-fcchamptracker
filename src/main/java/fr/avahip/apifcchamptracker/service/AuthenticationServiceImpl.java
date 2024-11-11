package fr.avahip.apifcchamptracker.service;

import fr.avahip.apifcchamptracker.entity.Token;
import fr.avahip.apifcchamptracker.entity.User;
import fr.avahip.apifcchamptracker.repository.TokenRepository;
import fr.avahip.apifcchamptracker.repository.UserRepository;
import fr.avahip.apifcchamptracker.tools.EmailTemplateName;
import fr.avahip.apifcchamptracker.tools.RegistrationRequest;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;
    @Value("${mailing.frontend.activation_url}")
    private String activationUrl;


    @Override
    public void register(RegistrationRequest request) throws MessagingException {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .accountLocked(false)
                .enabled(false)
                .build();
        userRepository.save(user);
        sendValidationEmail(user);
    }

    @Override
    public void sendValidationEmail(User user) throws MessagingException {
        emailService.sendEmail(
                user.getEmail(),
                user.getUsername(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                generateAndSaveActivationToken(user),
                "Account Activation"
        );
    }

    @Override
    public String generateAndSaveActivationToken(User user) {
        String generatedToken = generateActivationCode(6);
        Token token = Token.builder()
                .token(generatedToken)
                .createAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        tokenRepository.save(token);
        return generatedToken;
    }

    @Override
    public String generateActivationCode(int length) {
        SecureRandom random = new SecureRandom();
        return random.ints(length, 0, 10)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}
