package nl.saxofoonleren.dropit.service;

import nl.saxofoonleren.dropit.domain.ERole;
import nl.saxofoonleren.dropit.domain.Role;
import nl.saxofoonleren.dropit.domain.User;
import nl.saxofoonleren.dropit.payload.request.LoginRequest;
import nl.saxofoonleren.dropit.payload.request.SignupRequest;
import nl.saxofoonleren.dropit.payload.response.JwtResponse;
import nl.saxofoonleren.dropit.payload.response.MessageResponse;
import nl.saxofoonleren.dropit.repository.RoleRepository;
import nl.saxofoonleren.dropit.repository.UserRepository;
import nl.saxofoonleren.dropit.security.jwt.AuthEntryPointJwt;
import nl.saxofoonleren.dropit.security.jwt.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Validated
public class AuthorizationService {

    private static final String ROLE_NOT_FOUND_ERROR = "Error: Role is not found.";

    private UserRepository userRepository;
    private PasswordEncoder encoder;
    private RoleRepository roleRepository;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setEncoder(PasswordEncoder passwordEncoder) {
        this.encoder = passwordEncoder;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    /**
     *
     * Deze methode verwerkt de gebruiker die wil registreren. De username en e-mail worden gecheckt. Eventuele rollen
     * worden toegevoegd en de gebruiker wordt opgeslagen in de database.
     *
     * @param signUpRequest de payload signup-request met gebruikersnaam en wachtwoord.
     * @return een HTTP response met daarin een succesbericht.
     */
    public ResponseEntity<MessageResponse> registerUser(@Valid SignupRequest signUpRequest) {
        if (Boolean.TRUE.equals(userRepository.existsByUsername(signUpRequest.getUsername()))) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_ERROR));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        System.out.println("VIEW user: " + user);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    /**
     * Deze methode controleert de ontvangen username en wachtwoord. Het gebruikt hiervoor de
     * AuthenticationManager. I.a.w. Spring security doet die allemaal voor ons.
     *
     * Wanneer de gebruikersnaam/wachtwoord combinatie niet klopt, wordt er een Runtime exception gegooid:
     * 401 Unauthorized. Deze wordt gegooid door
     * {@link AuthEntryPointJwt}
     *
     *
     * @param loginRequest De payload met username en password.
     * @return een HTTP-response met daarin de JWT-token.
     */
    public ResponseEntity<JwtResponse> authenticateUser(@Valid LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

}
