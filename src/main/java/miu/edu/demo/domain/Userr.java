package miu.edu.demo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    List<Post> posts;

   @OneToMany(mappedBy = "principle", cascade = CascadeType.ALL)
   @JsonManagedReference
   List<Logger> logList;

   public  static Userr getLoggedInUser(){
      return new Userr(1,"logged in",null,null);
   }
}
