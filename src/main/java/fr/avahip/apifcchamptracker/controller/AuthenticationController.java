package fr.avahip.apifcchamptracker.controller;

import fr.avahip.apifcchamptracker.service.AuthenticationService;
import fr.avahip.apifcchamptracker.tools.AuthenticationRequest;
import fr.avahip.apifcchamptracker.tools.AuthenticationResponse;
import fr.avahip.apifcchamptracker.tools.RegistrationRequest;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> register(@Validated @RequestBody RegistrationRequest request) throws MessagingException {
        service.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@Validated @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/activate-account")
    public void confirm(@RequestParam String token) throws MessagingException {
        service.activateAccount(token);
    }
}
