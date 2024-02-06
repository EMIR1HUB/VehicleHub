package com.suleimanov.vehiclecontrol.Config;

import com.suleimanov.vehiclecontrol.Security.services.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    return http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                    .requestMatchers("/login", "/register", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
                    .requestMatchers("/users/register").permitAll()
                    .requestMatchers("/roles/user/edit/**").hasAnyAuthority("SUPER_ADMIN", "ADMIN")
                    .requestMatchers("/authenticate").permitAll()
                    .anyRequest().authenticated())
//            .formLogin(login -> login
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/index", true)  // Перенаправление на /index после успешной авторизации
//                    .permitAll())
//            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .exceptionHandling(except -> except.accessDeniedPage("/accessDenied"))
            .logout(logout -> logout
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login").permitAll())
            .build();
  }

  @Bean
  public UserDetailsService userDetailsService(){
    return new MyUserDetailsService();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  // AuthenticationProvider используется для подтверждения личности пользователя (кто ты?), возвращает провайдера
  @Bean
  public AuthenticationProvider authenticationProvider(){
    // реализация провайдера, который реализует userDetailsService и passwordEncoder
    // для аутентификации имя пользователя и пароля
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
  }
}
