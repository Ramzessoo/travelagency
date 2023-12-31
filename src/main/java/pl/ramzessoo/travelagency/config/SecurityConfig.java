package pl.ramzessoo.travelagency.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authorize -> authorize

                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .formLogin(Customizer.withDefaults())
                .headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.
                        frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {

        List<UserDetails> usersList = new ArrayList<>();
        usersList.add(
                createUser("buzz", "pass", encoder, "ROLE_USER", "ROLE_ADMIN"));
        return new InMemoryUserDetailsManager(usersList);
    }

    private User createUser(String login, String pass, PasswordEncoder encoder, String... roles) {
        String encodedPass = encoder.encode(pass);
        List<SimpleGrantedAuthority> role = Arrays.stream(roles)
                .map(r -> new SimpleGrantedAuthority(r))
                .toList();
        return new User(login, encodedPass, role);
    }

}
