package dev.ebank.user;

import dev.ebank.user.model.entity.User;
import dev.ebank.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository){
		return args -> {
			User user = User.builder()
					.firstname("IYALI")
					.lastname(("Hamdy"))
					.email("hamdy@gmail.com")
					.active(true)
					.build();
			User user1 = User.builder()
					.firstname("Diay")
					.lastname(("Ashraf"))
					.email("ashraf@gmail.com")
					.active(true)
					.build();
				userRepository.save(user);
				userRepository.save(user1);
		};
	}

}
