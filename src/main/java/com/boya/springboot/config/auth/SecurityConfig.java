package com.boya.springboot.config.auth;

import com.boya.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                   .headers().frameOptions().disable()
                   .and()
                        .authorizeRequests()//url별 권한관리 옵션 시작, .antMatchers (권한관리 대상 지정 옵션) 사용하기 위해 선언
                        .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
                        .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                        .anyRequest().authenticated()  // anyRequest() = else
                   .and()
                        .logout()
                            .logoutSuccessUrl("/")
                   .and()
                        .oauth2Login()
                            .userInfoEndpoint() //로그인 성공 이후 사용자 정보 가져올 때의 설정 담당
                                .userService(customOAuth2UserService);
    }
}
