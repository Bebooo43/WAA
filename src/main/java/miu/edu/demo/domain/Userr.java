package miu.edu.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
 public class Userr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name= "id_user")
    List<Post> posts;
}
