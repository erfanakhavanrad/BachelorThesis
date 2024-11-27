package com.tarazgroup.tws.util.security;

import com.tarazgroup.tws.filter.JwtRequestFilter;
import com.tarazgroup.tws.service.JwtUserDetailsService;
//import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    final private JwtUserDetailsService jwtUserDetailsService;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtRequestFilter jwtRequestFilter;

    @Value("${WAN.ip}")
    private String ip;

    @Value("${WAN.port}")
    private String port;

    @Autowired
    public WebSecurityConfig(JwtUserDetailsService myUserDetailsService, JwtRequestFilter jwtRequestFilter, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.jwtUserDetailsService = myUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
//                .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
//                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
//                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/tkt/register/*").permitAll()
                .antMatchers("/tkt/users/forgetpassword/*").permitAll()
                .antMatchers("/tkt/users/forgetpasswordlink/*").permitAll()
                .antMatchers("/tkt/accountinfo/*").permitAll()
                .antMatchers("/tkt/settings/generalmessage").permitAll()
                .antMatchers("/pub/geolocations/*/*").permitAll()
                .antMatchers("/pub/geolocations/*").permitAll()
                .antMatchers("/tkt/register/*/*").permitAll()
                .antMatchers("/tkt/register").permitAll()
                .antMatchers("/crm/voip").permitAll()
                .antMatchers("/crm/voiplogs/startvoip/*/*").permitAll()
                .antMatchers("/crm/calendarevents").permitAll()
//                .antMatchers("/crm/shillantype/*").permitAll()
//                .antMatchers("/crm/shillantype*/").permitAll()
//                .antMatchers("/crm/shillantype").permitAll()
                .antMatchers("/crm/shillantype").permitAll()
                .antMatchers("/crm/shillantype/*").permitAll()
                .antMatchers("/crm/shillan*/*").permitAll()
                // .antMatchers("/endpoint").permitAll()
                //  .antMatchers("/endpoint/**").permitAll()
                .antMatchers("/images/goods/*/*.png").permitAll()
                .antMatchers("/images/goods/*/*.gif").permitAll()
                .antMatchers("/images/goods/*/*.jpeg").permitAll()
                .antMatchers("/images/goods/*/*.jpg").permitAll()
                .antMatchers("/images/goods/*/*.bmp").permitAll()
                .antMatchers("/images/goods/*/*.svg").permitAll()
                .antMatchers("/images/goodsgroups/*/*.png").permitAll()
                .antMatchers("/images/goodsgroups/*/*.gif").permitAll()
                .antMatchers("/images/goodsgroups/*/*.jpeg").permitAll()
                .antMatchers("/images/goodsgroups/*/*.jpg").permitAll()
                .antMatchers("/images/goodsgroups/*/*.bmp").permitAll()
                .antMatchers("/images/goodsgroups/*/*.svg").permitAll()
                .antMatchers("/applicationinfo/version").permitAll()
                .antMatchers("/applicationinfo").permitAll()
                .anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }


    @Override
    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/**");
        web.ignoring().antMatchers("/taraz",
                "/endpoint",
                "/endpoint/**",
                "/taraz/swagger-config",
                "/taraz/authentication",
                "/taraz/acc",
                "/taraz/ast",
                "/taraz/pub",
                "/taraz/sale",
                "/taraz/inv",
                "/taraz/bdg",
                "/taraz/buy",
                "/taraz/crm",
                "/taraz/exc",
                "/taraz/trs",
                "/taraz/tkt",
                "/taraz/prc",
                "/taraz/scr",
                "/taraz/log",
                "/taraz/applicationinfo",
                "/docs.html",
                "/swagger-ui/**");
    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        var configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:8080"));
////        configuration.setAllowedOrigins(Collections.singletonList("http://"+ip+":"+port));
//        configuration.addExposedHeader("header1, header2, header3, header4");
//
//
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
//        configuration.setAllowedHeaders(Collections.singletonList("*"));
//        var source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }


}
