package eu.codeacademy.eshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/**", "/h2/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
            .formLogin()
                .permitAll()
                .loginPage("/login-eshop")
                .loginProcessingUrl("/login-eshop")
                .defaultSuccessUrl("/", true)
                .usernameParameter("loginEmail")
                .passwordParameter("loginPassword")
                .and()
            .csrf()
                .ignoringAntMatchers("/h2/**")
                .and()
            .headers()
                .frameOptions()
                .sameOrigin();
    }

/*    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }*/
}
