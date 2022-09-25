package ro.sda.javaremote39.springseed.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class AuthorDto {

    private Long id;
    private String firstName;
    private String lastName;

}
