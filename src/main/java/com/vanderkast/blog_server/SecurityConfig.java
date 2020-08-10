package com.vanderkast.blog_server;


import com.vanderkast.blog_server.user_service.RoleKeeper;
import com.vanderkast.blog_server.user_service.RoleKeeperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
@EnableAutoConfiguration
@Profile("!test")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final RoleKeeper roleKeeper;
    private final DataSource dataSource;

    @Autowired
    public SecurityConfig(RoleKeeper roleKeeper, DataSource dataSource) {
        this.roleKeeper = roleKeeper;
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select (username, password) from user where username = ?")
                .authoritiesByUsernameQuery("select (username, role) from user where username = ? ");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/auth").permitAll()
                .antMatchers("/api/user/setRole").hasRole(roleKeeper.getRoleAdmin())
                .antMatchers(HttpMethod.POST).hasAnyRole(roleKeeper.getRoleAdmin(), roleKeeper.getRoleUser());
    }

    @Bean
    RoleKeeper beanRoleKeeper() {
        return new RoleKeeperImpl();
    }
}
