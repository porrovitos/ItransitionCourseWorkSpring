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

    private static final String LOGIN_ENDPOINT = "/login";
    private static final String REGISTRATION_ENDPOINT = "/registration";
    private static final String CREATE_FANFIC_ENDPOINT = "/fanfic/create";
    private static final String ALL_FANFIC_ENDPOINT = "/fanfic";
    private static final String ADD_FANFIC_ENDPOINT = "/fanfic/**";
    private static final String ADD_COMMENT_ENDPOINT = "/comment/add";
    private static final String SEARCH_FANFICS_ENDPOINT = "/user/**";
    private static final String ONE_FANFIC_ENDPOINT = "/fanfic/id/**";
    private static final String FANDOM_ENDPOINT = "/fandom";
    private static final String ADD_FAVORITE_ENDPOINT = "/favorite/add";
    private static final String ALL_FAVORITE_ENDPOINT = "/favorite/my_favorite_fanfics";
    private static final String MY_FANFICS_ENDPOINT = "/fanfic/my_fanfics";
    private static final String FANFIC_COMMENTS_ENDPOINT = "/comment/fanfic/**";
    private static final String DELETE_FROM_FAVARITE_ENDPOINT = "/favorite/fanfic/**";
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
                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .antMatchers(LIKE_ENDPOINT).permitAll()
                .antMatchers(ALL_FAVORITE_ENDPOINT).permitAll()
                .antMatchers(DELETE_FROM_FAVARITE_ENDPOINT).permitAll()
                .antMatchers(ADD_FAVORITE_ENDPOINT).permitAll()
                .antMatchers(MY_FANFICS_ENDPOINT).permitAll()
                .antMatchers(ADD_COMMENT_ENDPOINT).permitAll()
                .antMatchers(REGISTRATION_ENDPOINT).permitAll()
                .antMatchers(CREATE_FANFIC_ENDPOINT).permitAll()
                .antMatchers(ALL_FANFIC_ENDPOINT).permitAll()
                .antMatchers(FANFIC_COMMENTS_ENDPOINT).permitAll()
                .antMatchers(ONE_FANFIC_ENDPOINT).permitAll()
                .antMatchers(FANDOM_ENDPOINT).permitAll()
                .antMatchers(SEARCH_FANFICS_ENDPOINT).permitAll()
                .antMatchers(ADD_FANFIC_ENDPOINT).permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}