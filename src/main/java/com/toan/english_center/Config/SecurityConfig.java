package com.toan.english_center.Config;


//import com.toan.english_center.Entity.Account;
//import com.toan.english_center.Repository.AccountRepository;
//import com.toan.english_center.Service.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

//    @Autowired
//    private JwtAuthenticationFilter jwtAuthFilter;
//
//    @Autowired
//    private AuthenticationProvider authenticationProvider; // Cấu hình AuthenticationProvider (ví dụ UserDetailsService)
//
//    @Autowired
//    private AuthenticationEntryPoint unauthorizedHandler; // Xử lý lỗi 401 Unauthorized
//
//    @Autowired
//    private AccountRepository accountRepository; // Repository để tìm Account theo username
//
//    @Autowired
//    private JwtService jwtService; // Service để tạo và validate JWT



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/feedbacks/**").permitAll()
                        .requestMatchers("/api/students/**").permitAll()
                        .requestMatchers("/api/teachers/**").permitAll()
                        .requestMatchers("/api/classes/**").permitAll()
                        .requestMatchers("/api/learning-progress/**").permitAll()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
////                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF cho REST API
////                .cors(CorsConfigurer::disable) // Disable CORS (nếu cần cấu hình CORS thì bật lại và config cụ thể)
//                .authorizeHttpRequests((authz) -> authz
//                        .requestMatchers("/api/auth/**").permitAll() // Cho phép truy cập /api/auth/login mà không cần JWT
//                        .requestMatchers("/api/public/**").permitAll() // Cho phép truy cập các endpoint public (nếu có)
//                        .requestMatchers("api/learning-progress/**").permitAll()
//                        .requestMatchers("/api/classes/**").permitAll()
//                        .requestMatchers("/api/students/**").permitAll()
//                        .requestMatchers("/api/teachers/**").permitAll()
//                        .anyRequest().authenticated() // Tất cả các request khác cần xác thực
//                )
//                .sessionManagement((session) -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless session cho JWT
//                )
//                .authenticationProvider(authenticationProvider) // Sử dụng AuthenticationProvider đã cấu hình
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class) // Thêm JWT filter trước UsernamePasswordAuthenticationFilter
//                .exceptionHandling((exceptionHandling) ->
//                        exceptionHandling.authenticationEntryPoint(unauthorizedHandler) // Xử lý lỗi 401
//                );
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService()); // Cấu hình UserDetailsService (sẽ tạo sau)
//        authProvider.setPasswordEncoder(passwordEncoder()); // Sử dụng PasswordEncoder
//        return authProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            Account account = accountRepository.findByAUid(username)
//                    .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//
//            // Tạo UserDetails object từ Account. Có thể tùy chỉnh UserDetails nếu cần roles, authorities...
//            return new User(account.getaUid(), account.getaPwd(), Collections.emptyList());
//        };
//    }
//
//    @Bean
//    public AuthenticationEntryPoint unauthorizedHandler() {
//        return (request, response, authException) -> {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//        };
//    }
//
//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter() {
//        return new JwtAuthenticationFilter(jwtService, userDetailsService(), accountRepository);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
