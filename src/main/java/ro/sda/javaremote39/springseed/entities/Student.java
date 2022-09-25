package ro.sda.javaremote39.springseed.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "student")
public class Student {
    @Id
    private Long id;
    @Column(name="first_name")
    private String AlaName;

    private String lastName;
}
