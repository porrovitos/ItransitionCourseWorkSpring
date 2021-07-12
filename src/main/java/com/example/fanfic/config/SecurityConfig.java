package com.example.fanfic.config;

import com.example.fanfic.security.jwt.JwtConfigurer;
import com.example.fanfic.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    private static final String ONLY_LOGIN_ENDPOINT = "/login";
    private static final String ONLY_REGISTRATION_ENDPOINT = "/registration";
    private static final String ONLY_FANFIC_ENDPOINT = "/fanfic";
    private static final String FANFIC_ENDPOINT = "/fanfic/**";
    private static final String COMMENT_ENDPOINT = "/comment/**";
    private static final String ONLY_SEARCH_FANFICS_ENDPOINT = "/user";
    private static final String FANFICS_ENDPOINT = "/user/**";
    private static final String ONLY_FANDOM_ENDPOINT = "/fandom";
    private static final String FAVORITE_ENDPOINT = "/favorite/**";
    private static final String LIKE_ENDPOINT = "/like/**";



    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(ONLY_LOGIN_ENDPOINT).permitAll()
                .antMatchers(LIKE_ENDPOINT).permitAll()
                .antMatchers(ONLY_REGISTRATION_ENDPOINT).permitAll()
                .antMatchers(ONLY_FANFIC_ENDPOINT).permitAll()
                .antMatchers(FANFIC_ENDPOINT).permitAll()
                .antMatchers(COMMENT_ENDPOINT).permitAll()
                .antMatchers(ONLY_SEARCH_FANFICS_ENDPOINT).permitAll()
                .antMatchers(FANFICS_ENDPOINT).permitAll()
                .antMatchers(ONLY_FANDOM_ENDPOINT).permitAll()
                .antMatchers(FAVORITE_ENDPOINT).permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}