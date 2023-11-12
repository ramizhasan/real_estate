package com.prettier;

import com.prettier.entity.concretes.User;
import com.prettier.repository.UserRepository;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaAuditing
public class RealEstateApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RealEstateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		User user = new User();
//		user.setCreateAte(LocalDateTime.now());
//		user.setEmail("aaabbbccc@ddd.com");
//		user.setPhone("55555555555");
//		user.setFirstName("Ramiz");
//		user.setLastName("Hasan");
//		user.setPasswordHash("fejfhioewufr78348ofyuerg8473fbvi");
//		user.setResetPasswordCode("ljervhbuhaebuyfvbouerbhv97889revh");
//		user.setUpdateAt(LocalDateTime.now());

		User build = User.builder()
				.firstName("Ramiz")
				.lastName("Hasan")
				.email("aaabbbdddd@ccc.com")
				.phone("0555555555")
				.passwordHash("93486249587ytfhhebdkjhv")
				//.createAte(LocalDateTime.now())
				.build();
		System.out.println(build.getEmail());

		userRepository.save(build);

	}
}


