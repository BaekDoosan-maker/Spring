



package com.sparta.week02.domain;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week02Application {

	public static void main(String[] args) {
		SpringApplication.run(Week02Application.class, args);
	}
	// Week02Application.java 의 main 함수 아래에 붙여주세요.
	@Bean
	public CommandLineRunner demo(CourseRepository repository) {
		return (args) -> {
			repository.save(new Course("df","dfs"));

		};
	}
}

