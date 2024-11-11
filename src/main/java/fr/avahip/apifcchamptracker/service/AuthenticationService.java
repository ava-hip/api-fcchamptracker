package fr.avahip.apifcchamptracker.service;

import fr.avahip.apifcchamptracker.entity.User;
import fr.avahip.apifcchamptracker.tools.AuthenticationRequest;
import fr.avahip.apifcchamptracker.tools.AuthenticationResponse;
import fr.avahip.apifcchamptracker.tools.RegistrationRequest;
import jakarta.mail.MessagingException;

public interface AuthenticationService {

    void register(RegistrationRequest request) throws MessagingException;

    void sendValidationEmail(User user) throws MessagingException;

    String generateAndSaveActivationToken(User user);

    String generateActivationCode(int length);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void activateAccount(String token) throws MessagingException;
}

