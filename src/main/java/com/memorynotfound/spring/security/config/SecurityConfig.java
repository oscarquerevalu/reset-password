package com.memorynotfound.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.memorynotfound.spring.security.service.UserService;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;
    
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    
    @Autowired
    public SecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }
    
    private static final String[] AUTH_WHITELIST = {
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers(
                            "/registration**",
                            "/forgot-password**",
                            "/clase**",
                            "/estiloAlumno**",
                            "/alumno**",
                            "/swagger-resources/**",
                            "/swagger-ui.html",
                            "/v2/api-docs",
                            "/reset-password**").permitAll()
                    .antMatchers(
                            "/js/**",
                            "/css/**",
                            "/img/**",
                            "/webjars/**").permitAll()
                    .anyRequest().authenticated().and().httpBasic()
                .and()
                    .formLogin()
                        .loginPage("/login")
                            .permitAll()
                .successHandler(authenticationSuccessHandler)
                .and()
                    .logout()
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                .permitAll();
    }
    

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
        		.select()
        	      .apis(RequestHandlerSelectors.basePackage("com.memorynotfound.spring.security.web"))
        	      .paths(PathSelectors.ant("/alumno/*"))
        	      .build()
        	      .apiInfo(apiEndPointsInfo());                                        
    }
    
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Sistema adaptativo predictivo")
            .description("Sistema adaptativo predictivo REST API")
            .contact(new Contact("Oscar Querevalu", "www.upc.edu.pe", "oscarquerevalu@gmail.com"))
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0")
            .build();
    }
    
    

}