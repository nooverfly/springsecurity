package com.huayun.scsso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created by overfly on 2017/9/20.
 */
//@EnableGlobalMethodSecurity(prePostEnabled = true)  //AOP
@Configuration          // 配置文件
@EnableWebSecurity      // 开启Security
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Bean
    @Override
    protected UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user_1").password("123456").authorities("USER").build());
        manager.createUser(User.withUsername("user_2").password("123456").authorities("USER").build());
        return manager;
    }*/

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        //路由策略和访问权限的简单配置
        http
                .formLogin()                        //启用默认登陆页面
                .failureUrl("/login?error")         //登陆失败返回URL:/login?error
                .defaultSuccessUrl("/home")         //登陆成功跳转URL
                .permitAll();                       //登陆页面全部权限可访问

        super.configure(http);
        // @formatter:off
        *//*http
                .requestMatchers().anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth*//**//*").permitAll();*//*
        // @formatter:on

    }*/

    /**
     * 设置获取token的url
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http
                .anonymous().disable()
                .authorizeRequests()
                .antMatchers("/oauth/token").permitAll();*/
        http
                .requestMatchers().anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/*").permitAll();
    }

    /**
     * 配置内存用户
     */
    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("fly").password("123").roles("USER");
    }*/
    /**
     * 在内存中创建两个用户
     * @param
     * @throws Exception
     */
    /*@Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("bill").password("abc123").roles("admin1").and()
                .withUser("bob").password("abc123").roles("USER");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/

    @Bean
    @Override
    protected UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user_1").password("123456").authorities("USER").build());
        manager.createUser(User.withUsername("user_2").password("123456").authorities("USER").build());
        return manager;
    }
}
