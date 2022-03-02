package com.redis.SpringDataJedisSentinelSSL;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
    List<Student> findByFirstname(String name);

    List<Student> findByLastname(String gender);

}
