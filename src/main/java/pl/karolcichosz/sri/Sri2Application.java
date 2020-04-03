package pl.karolcichosz.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EntityScan("pl.karolcichosz.sri.model")
@EnableScheduling
@SpringBootApplication(exclude = MetricsAutoConfiguration.class)
		public class Sri2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sri2Application.class, args);
	}
}
