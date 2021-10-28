package ru.kpfu.itis.models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Deputy {
    private Long id;
    private String first_name;
    private String last_name;
    private Integer age;
    private String photo;
    private String title;
    private Integer number;
}
