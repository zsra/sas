package hu.zsra.enaplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnaploApplication implements CommandLineRunner {

	@Autowired
	private InitData initData;

	public static void main(String[] args) {
		SpringApplication.run(EnaploApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initData.Init();
	}

}
