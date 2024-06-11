package com.CSC_340_PROJECT4.Project4.security;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * Make changes to it so it will give everyone their login page and when users login they will sent user info to the database.
 */




@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        requestCache.setMatchingRequestParameterName(null);

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                        .requestMatchers("/", "/home", "/customer/signup", "/customer/login",
                                "/restaurant-owners/signup", "/restaurant-owners/login",
                                "/admin/login").permitAll()
                        .requestMatchers("/customer/**").hasRole("CUSTOMER")
                        .requestMatchers("/restaurant-owners/**").hasRole("RESTAURANT_OWNER")
                        .requestMatchers("/sysadmins/**").hasRole("SYSADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .successHandler(customAuthenticationSuccessHandler)
                        .permitAll()
                )
                .exceptionHandling((x) -> x.accessDeniedPage("/403"))
                .logout((logout) -> logout.permitAll())
                .requestCache((cache) -> cache
                        .requestCache(requestCache)
                );

        return http.build();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/CSS/**", "/Images/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}



//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//    @Autowired
//    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
//        requestCache.setMatchingRequestParameterName(null);
//
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((authorize) -> authorize
//                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
//                        .requestMatchers("/", "/home", "/customer/signup", "/customer/login",
//                                "/restaurant-owners/signup", "/restaurant-owners/login",
//                                "/admin/login").permitAll()
//
//                        .requestMatchers("/customer/**").hasRole("CUSTOMER")
//                        .requestMatchers("/restaurant-owners/**").hasRole("RESTAURANT_OWNER")
//                        .requestMatchers("/sysadmins/**").hasRole("SYSADMIN")
//                        .anyRequest().authenticated()
//                )
//
//                .formLogin((form) -> form
//                        .loginPage("/login") // Set a common login page for all roles
//                        .successHandler(customAuthenticationSuccessHandler)
//                        .permitAll()
//                )
//                .exceptionHandling((x) -> x.accessDeniedPage("/403"))
//                .logout((logout) -> logout.permitAll())
//                .requestCache((cache) -> cache
//                        .requestCache(requestCache)
//                );
//
//        return http.build();
//    }
//
//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/CSS/**", "/Images/**");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
