package clone.instagram.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

	private static final String[] AUTH_WHITELIST_SWAGGER = {"/v2/api-docs", "/configuration/ui", "/swagger-resources",
		"/swagger-resources/**", "/configuration/security", "/swagger-ui.html", "/webjars/**", "/swagger-ui/**"};
	private static final String[] AUTH_WHITELIST_STATIC = {"/static/css/**", "/static/js/**", "*.ico"};
	private static final String[] AUTH_WHITELIST = {"/accounts"};

	@Bean
	public CorsConfigurationSource configurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.addAllowedOriginPattern("*");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		configuration.setAllowCredentials(true);
		configuration.setMaxAge(3600L);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return source;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.logout().disable()
			.formLogin().disable()
			.httpBasic().disable();

		http.cors()
			.configurationSource(configurationSource())
			.and()
			.csrf()
			.disable()
			.authorizeRequests()
			.requestMatchers(CorsUtils::isPreFlightRequest)
			.permitAll()
			.antMatchers(AUTH_WHITELIST)
			.permitAll()
			.antMatchers(AUTH_WHITELIST_STATIC)
			.permitAll()
			.antMatchers(AUTH_WHITELIST_SWAGGER)
			.permitAll()
			.anyRequest().hasAuthority("ROLE_USER");

		return http.build();
	}

}
