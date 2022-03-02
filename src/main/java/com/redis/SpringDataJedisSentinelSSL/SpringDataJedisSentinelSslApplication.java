// From https://smoothed9.medium.com/introduction-to-spring-data-redis-with-repository-4404355a3133

package com.redis.SpringDataJedisSentinelSSL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringDataJedisSentinelSslApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {

        SpringApplication.run(SpringDataJedisSentinelSslApplication.class, args);

    }
    @Override
    public void run(String... args) throws Exception {


        Student student = new Student(
                "Eng2015001", "John Doe", Student.Gender.MALE, 1);
        System.out.println(student);

        studentRepository.save(student);
    }
}
