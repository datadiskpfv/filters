package uk.co.datadisk.filters.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import uk.co.datadisk.filters.configuration.filters.THREEFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // This controls the HTTP side of things
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Disable CSRF (cross site request forgery)
        http.csrf().disable();

        // No session will be created or used by spring security
        // http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        // Entry points
        http.authorizeRequests()//
                .antMatchers( "/index/**", "/app/**", "/*.ico").permitAll()
                // Disallow everything else..
                .anyRequest().authenticated();

        // Form login
//        http.formLogin()
//                .loginPage("/login")
//                //.defaultSuccessUrl("/")           / is default
//                .failureUrl("/login?error");

        //Logout
        http.logout()
                .permitAll()
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login?logout");

        // If a user try to access a resource without having enough permissions
        http.exceptionHandling().accessDeniedPage("/login?error");

        // Non-specific URL filters
        http.addFilterBefore(new THREEFilter(), BasicAuthenticationFilter.class);

        // Optional, if you want to test the API from a browser
        // http.httpBasic();
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/static/**");
//    }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // Allow swagger to be accessed without authentication
    web
        .ignoring()
            .antMatchers("/three/**")
            .antMatchers("/two/**")
            .antMatchers("/one/*");
            //.antMatchers("/*.ico")
            //.antMatchers("/error");
//            .antMatchers("/swagger-resources/**")
//            .antMatchers("/swagger-ui.html")
//            .antMatchers("/configuration/**")
//            .antMatchers("/webjars/**")
//            .antMatchers("/public");
  }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(5);
//    }

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

}
