package fr.avahip.apifcchamptracker.service;

import fr.avahip.apifcchamptracker.entity.User;
import fr.avahip.apifcchamptracker.tools.RegistrationRequest;
import jakarta.mail.MessagingException;

public interface AuthenticationService {
    void register(RegistrationRequest request) throws MessagingException;
    void sendValidationEmail(User user) throws MessagingException;
    String generateAndSaveActivationToken(User user);

    String generateActivationCode(int length);
}
