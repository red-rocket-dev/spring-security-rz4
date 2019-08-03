package pl.sda.springsecurity.sectest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public SecurityConfiguration(PasswordEncoder passwordEncoder,
                                 UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/hello")
                .authenticated()
        .and()
        .formLogin();
/*        .and()
        .formLogin()
                .loginPage("tutajpodajgdziejeststronalogowania")
                .loginProcessingUrl("tutajendpointdoprocesowaniadanychlogowania")
                .usernameParameter("username")
                .passwordParameter("password");*/
    }
}
