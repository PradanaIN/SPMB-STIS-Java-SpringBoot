package spmb.polstatstis.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import spmb.polstatstis.services.UserDetailsServiceImpl;

/* ============= SECURITY CONFIGURATION ============= */
/*
*	Konfigurasi Authentication & Authorization Login
*/
/* ================================================== */

@Configuration
@EnableWebSecurity
@Deprecated
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    // Enkripsi password yang diinputkan
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    // Authentication & Authorization 
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").hasAnyAuthority("Pengawas SPMB", "Panitia SPMB")
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
            .logout().permitAll()
            .logoutSuccessHandler(new LogoutSuccessHandler() { 
                @Override
                public void onLogoutSuccess(HttpServletRequest request,
                            HttpServletResponse response, Authentication authentication)
                        throws IOException, ServletException {
                    response.sendRedirect(request.getContextPath());
                }
            })
            .and()
            .csrf().disable()
            .exceptionHandling().accessDeniedPage("/403")
            ;
    }
}
