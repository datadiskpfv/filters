package uk.co.datadisk.filters.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import uk.co.datadisk.filters.configuration.filters.APP1Filter;
import uk.co.datadisk.filters.configuration.filters.APP2Filter;

@EnableWebSecurity
public class MultiHttpSecurityConfig  {

    @Configuration
    @Order(9)
    class app1ConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.antMatcher("/app1/**").authorizeRequests().anyRequest().permitAll();
            http.addFilterBefore(new APP1Filter(), BasicAuthenticationFilter.class);

        }
    }

    @Configuration
    @Order(8)
    class app2ConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.antMatcher("/app2/**").authorizeRequests().anyRequest().permitAll();
            http.addFilterBefore(new APP2Filter(), BasicAuthenticationFilter.class);
        }
    }

}


