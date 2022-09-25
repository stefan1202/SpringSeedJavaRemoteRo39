package ro.sda.javaremote39.springseed.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurtityConfigUpdate {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests((authz) -> authz.antMatchers(HttpMethod.GET, "/api/cars").hasAnyRole("ADMIN", "CARS")
//                .antMatchers(HttpMethod.POST, "/api/author").authenticated()
//                .antMatchers("/api/users/**").hasAuthority("ROLE_USER_ADMIN")
                .anyRequest().permitAll() )
                .formLogin().and()
                .httpBasic().and()
                .logout()
                .and()
                .csrf().ignoringAntMatchers("/api/**")
                .and()
                .headers().frameOptions().disable()
        ;
        return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("Secret_123")
                .roles("ADMIN")
                .build();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("Secret_123")
                .authorities("ROLE_USER")
                .build();

        return new InMemoryUserDetailsManager(admin,user);
    }
//    @Bean
//    public DaoAuthenticationProvider  daoAuthenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder();
//        provider.setUserDetailsService();
//        return provider;
//    }
}
