package eu.codeacademy.eshop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/public/**", "/").permitAll()
                .anyRequest()
                .authenticated()
                .and()
            .formLogin()
                .permitAll()
                .loginPage("/login-eshop")
                .loginProcessingUrl("/login-eshop")
                .defaultSuccessUrl("/", true)
                .usernameParameter("loginEmail")
                .passwordParameter("loginPassword");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(
                PathRequest.toStaticResources().atCommonLocations(),
                PathRequest.toH2Console() //FIXME: when take profile lesson
        );
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user@eshop.lt")
                    .password("{bcrypt}$2a$10$teqiNl4bRoRUxgrJH15ixulqUtfHsHyQMHmB62x1AGRtXyOcMJTv.") // pass is user
                    .roles("USER")
                    .and()
                .withUser("admin@eshop.lt")
                    .password("{bcrypt}$2a$10$teqiNl4bRoRUxgrJH15ixulqUtfHsHyQMHmB62x1AGRtXyOcMJTv.") // pass is user
                    .roles("USER", "ADMIN")
                    .and()
                .withUser("no-bcrypt@eshop.lt")
                    .password("{noop}a") // password without encoding, as plain text
                    .roles("USER", "ADMIN")
                    .and()
                .and()
            .jdbcAuthentication()
                .dataSource(dataSource)
                    .usersByUsernameQuery("SELECT email AS username, password, TRUE AS enabled FROM users WHERE email = ?")
                    .authoritiesByUsernameQuery("SELECT email AS username, 'USER' AS authority FROM users WHERE email = ?")
                    .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
    }
}
