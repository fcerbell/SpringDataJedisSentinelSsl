package com.redis.SpringDataJedisSentinelSSL;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Getter
@Builder
@RedisHash("Student")
public class Student implements Serializable {
    private String id;
    private String name;
    private Gender gender;
    private int grade;

    public enum Gender {
        MALE, FEMALE
    }
}
