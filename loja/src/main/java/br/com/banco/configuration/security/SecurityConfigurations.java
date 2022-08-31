package br.com.banco.configuration.security;



import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().
                antMatchers(HttpMethod.GET,"/api/contas/**").permitAll().
                antMatchers(HttpMethod.POST,"/api/contas/").permitAll().
                antMatchers(HttpMethod.PUT,"/api/contas/tranferencia").permitAll().
                antMatchers(HttpMethod.PUT,"/api/contas/Deposito").permitAll().
                antMatchers(HttpMethod.GET,"/api/clientes/**").permitAll().
                antMatchers(HttpMethod.POST,"/api/clientes").permitAll();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**","/configuration/**", "/swagger-resources/**");
    }

}

