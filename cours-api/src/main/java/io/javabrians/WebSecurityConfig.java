package io.javabrians;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
//            .antMatchers("/css/**","/js/**","/image/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/topics");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
//       auth
//            .inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
//                .withUser("user").password("password").roles("ADMIN");
//       auth
//        .inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
//        .withUser("riadh").password("123").roles("USER");
   
        auth.jdbcAuthentication().passwordEncoder(new MyPasswordEncoder()).dataSource(dataSource)
        .usersByUsernameQuery("select name,password,actived from users where name=?")
        .authoritiesByUsernameQuery("select user_name , roles_role from users_roles where user_name=?")
        .rolePrefix("ROLE_");
    	
//    	auth.ldapAuthentication().userDnPatterns("uid={0},ou=people").groupSearchBase("ou=groups").contextSource()
//    	.url("ldap://localhost:8080/dc=springframework,dc=org")
//		.and()
//	.passwordCompare()
//		.passwordEncoder(new LdapShaPasswordEncoder())
//		.passwordAttribute("userPassword");

    }
}