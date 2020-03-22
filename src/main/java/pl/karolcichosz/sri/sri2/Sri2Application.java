package pl.karolcichosz.sri.sri2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@SpringBootApplication
@EntityScan("pl.karolcichosz.sri.model")
@EnableScheduling
public class Sri2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sri2Application.class, args);
	}

	@Configuration
	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.authorizeRequests()
						.antMatchers("/", "/home", "/h2-console/**").permitAll()
						.anyRequest().authenticated()
						.and()
					.formLogin()
						.permitAll()
						.and()
					.logout()
						.permitAll();

			http.csrf().disable();
			http.headers().frameOptions().disable();
		}

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
		}
	}
}
