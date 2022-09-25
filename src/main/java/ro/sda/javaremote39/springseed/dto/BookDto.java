package ro.sda.javaremote39.springseed.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Data

public class BookDto {
    private Long id;

@NotNull
 private String title;
@Length(min=3, max=30)
 private String author;

}
