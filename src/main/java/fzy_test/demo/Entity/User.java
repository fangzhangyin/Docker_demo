package fzy_test.demo.Entity;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String username;
    private String password;
}
