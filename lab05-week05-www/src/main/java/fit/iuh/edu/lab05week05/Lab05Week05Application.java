package fit.iuh.edu.lab05week05;

import com.neovisionaries.i18n.CountryCode;
import fit.iuh.edu.lab05week05.entities.Address;
import fit.iuh.edu.lab05week05.entities.Candidate;
import fit.iuh.edu.lab05week05.responsitory.AddressResponsitory;
import fit.iuh.edu.lab05week05.responsitory.CandidateResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class Lab05Week05Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab05Week05Application.class, args);
	}

	@Autowired
	private AddressResponsitory addressResponsitory;
	@Autowired
	private CandidateResponsitory candidateResponsitory;
//	@Bean
	CommandLineRunner initData() {
		return args -> {
			Random rnd = new Random();
			for (int i = 1; i < 1000; i++) {
				Address add = new Address(rnd.nextInt(1, 1000) + "", "Quang Trung", "HCM",
						rnd.nextInt(70000, 80000) + "", CountryCode.VN);
				addressResponsitory.save(add);
				Candidate can = new Candidate(i,
						rnd.nextLong(1111111111L, 9999999999L) + "",
						LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),


						"email_" + i + "@gmail.com",add);
				candidateResponsitory.save(can);
				System.out.println("Added: " + can);
			}
		};
	}


}
