package com.codegym.blogapp.security;

import com.codegym.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public CustomSuccessHandle customSuccessHandle() {
        return new CustomSuccessHandle();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder(10));
    }

    protected void configure(HttpSecurity http) throws Exception {
        // Disable crsf cho đường dẫn /api/**
        //http.csrf().ignoringRequestMatchers("/**");
        http.httpBasic();
        http
                .httpBasic().and()
                .formLogin(form -> form
                        .successHandler(customSuccessHandle())
                        .permitAll()
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/blogs/create", "/blogs/edit/**", "/blogs/delete/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/blogs/create").authenticated()
                        .requestMatchers("/", "/blogs", "/blogs/view/**", "/blogs/search", "/blogs/load", "/category").permitAll()
                        .anyRequest().denyAll() // chặn các request không xác định rõ
                )
                .exceptionHandling(customizer -> customizer.accessDeniedHandler(customAccessDeniedHandler()));
//        http.csrf(AbstractHttpConfigurer::disable);
        //http.cors();
        http
                // ... other configurations
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout") // Redirect after successful logout
                        .addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.ALL))) // Clears site data including cookies
                );
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}12345").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}12345").roles("ADMIN");
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .requestMatchers("/").permitAll()
//                .requestMatchers("/user**").hasRole("USER")
//                .requestMatchers("/admin**").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//    }
}
