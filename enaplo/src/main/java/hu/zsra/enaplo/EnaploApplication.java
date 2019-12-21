package hu.zsra.enaplo;

import hu.zsra.enaplo.model.user.Role;
import hu.zsra.enaplo.model.user.User;
import hu.zsra.enaplo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.sql.Date;

@SpringBootApplication
public class EnaploApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(EnaploApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(!isAdminExist()) {
			userService.signUp(new User("admin", "admin", "admin", "",
					"admin", new Date(Calendar.getInstance().getTime().getTime()),
					"admin@admin.hu", "0123456789", Role.ROLE_ADMIN, true, null));
		}
	}

	private boolean isAdminExist() {
		return userService
				.getAll()
				.stream()
				.anyMatch(user -> user.getRole().equals(Role.ROLE_ADMIN));
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
