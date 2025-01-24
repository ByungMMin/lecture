package com.kh.secom.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity //메소드 보안기능을 활성화
public class SecurityConfigure {

	@Bean // Bean 애노테이션을 이용해서 Bean으로 등록하는 경우 동일한 이름의 메소드가 존재해서는 안됨!
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		// return httpSecurity.formLogin().disable().build(); 역사속으로 사라질 코드
		/*
		 * return httpSecurity.formLogin(new
		 * Customizer<FormLoginConfigurer<HttpSecurity>>() {
		 * 
		 * @Override public void customize(FormLoginConfigurer<HttpSecurity> formLogin)
		 * { formLogin.disable(); } }).httpBasic(null).csrf(null).cors(null).build(); //
		 * 정석적인 방법
		 */
		return httpSecurity.formLogin(AbstractHttpConfigurer::disable) // form 로그인 방식은 사용하지 않겠다.
				.httpBasic(AbstractHttpConfigurer::disable) // httpBasic 사용하지 않겠다.
				.csrf(AbstractHttpConfigurer::disable) // csrf 비활성화
				.cors(AbstractHttpConfigurer::disable) // 얘는 일단은 꺼놓고 나중에 nginx붙이기
				.authorizeHttpRequests(requests -> {
					requests.requestMatchers("/members", "/members/login").permitAll();
					requests.requestMatchers(null)
				})
				.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

}
