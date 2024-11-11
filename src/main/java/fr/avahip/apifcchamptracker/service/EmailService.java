package fr.avahip.apifcchamptracker.service;

import fr.avahip.apifcchamptracker.tools.EmailTemplateName;
import jakarta.mail.MessagingException;

public interface EmailService {
    void sendEmail(String to,
                   String username,
                   EmailTemplateName emailTemplate,
                   String confirmationUrl,
                   String activationCode,
                   String subject) throws MessagingException;
}
