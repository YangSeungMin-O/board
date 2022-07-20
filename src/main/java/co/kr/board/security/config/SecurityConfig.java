package co.kr.board.security.config;

import co.kr.board.security.handler.FailureHandler;
import co.kr.board.security.handler.SuccessHandler;
import co.kr.board.security.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Resource(name = "customUserDetailsService")
  private CustomUserDetailsService customUserDetailsService;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .logout().disable()
        .httpBasic().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers("/loginPage").permitAll()
        .antMatchers("/loginFailure").permitAll()
        .antMatchers("/favicon.ico").permitAll()
        .anyRequest().access("@authorizationChecker.check(request, authentication)")
        .and()
        .formLogin()
        .loginPage("/loginPage")
        .usernameParameter("username")
        .passwordParameter("password")
        .loginProcessingUrl("/loginProcess")
        .successHandler(new SuccessHandler())
        .failureHandler(new FailureHandler());
  }
  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    //String password = passwordEncoder().encode("1234");
    auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
  }
}
