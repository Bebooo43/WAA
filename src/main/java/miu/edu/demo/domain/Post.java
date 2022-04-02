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
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String content;
    String author;
    @OneToMany(mappedBy = "post", cascade= CascadeType.ALL)
//    @JoinColumn(name= "id_post")
    List<Comment> comments;
 }
