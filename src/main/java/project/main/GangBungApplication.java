package project.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan; // <-- ต้อง Import ตัวนี้
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "project") // <-- สั่งให้ Scan ทุกอย่างที่อยู่ใน 'project' package
public class GangBungApplication {

	public static void main(String[] args) {
		SpringApplication.run(GangBungApplication.class, args);
	}

}