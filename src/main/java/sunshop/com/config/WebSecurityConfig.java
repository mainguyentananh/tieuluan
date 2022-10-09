package sunshop.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import sunshop.com.serviceImpl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl nv;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(nv);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	//userDetailsService(nv) . khi remove jsession ID mà còn remember-me fix required userdetailsservice
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider()).userDetailsService(nv);
	}
		

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		//Đã Đăng Nhập Mới Được Truy Cập
		http.authorizeRequests().antMatchers("/noibo/**").authenticated();
				
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
		http.authorizeRequests()
			.and().formLogin().loginPage("/dangnhap")
			.loginProcessingUrl("/j_spring_security_check")
				.usernameParameter("email").passwordParameter("password")
				.defaultSuccessUrl("/noibo/trangchu")
				.failureUrl("/dangnhap?error=true")
				.and().logout().logoutUrl("/dangxuat").logoutSuccessUrl("/dangnhap").deleteCookies("remember-me");
				
		//Config remember-me		
		http.rememberMe().key("uniqueAndSecret").tokenRepository(persistentTokenRepository()).tokenValiditySeconds(86400);	
		
		
	}

	//Lưu tạm cookies trên ram
	 @Bean
	 public PersistentTokenRepository persistentTokenRepository() {
		 InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl(); 
	     return memory;
	 }
	
}
