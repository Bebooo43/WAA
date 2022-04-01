package miu.edu.demo.repo.impl;

import miu.edu.demo.domain.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostRepoImpl {


    private static int postId = 300;

    private static ArrayList<Post> postList;

    static {
        postList = new ArrayList<>();
        postList.add(
                new Post(1, "post1", "content1", "author1")
        );
        postList.add(
                new Post(2, "post2", "content2", "author2")
        );
    }


//    @Override
    public List<Post> findAll() {
        return postList;
    }

//    @Override
//    public Post getPostById(int id) {
//        return postList.stream()
//                .filter(l -> l.getId() == id)
//                .findFirst()
//                .orElse(null);
//    }
//
//    @Override
//    public void savePost(Post p) {
//        p.setId(postId);
//        postId++;
//        postList.add(p);
//    }
//
//    @Override
//    public void delete(int id) {
//        var post = postList
//                .stream()
//                .filter(l -> l.getId() == id)
//                .findFirst().get();
//        postList.remove(post);
//    }
//
//    @Override
//    public void update(int id, Post p) {
//        Post toUpdate = getPostById(id);
//        toUpdate.setTitle(p.getTitle());
//        toUpdate.setContent(p.getContent());
//        toUpdate.setAuthor(p.getAuthor());
//    }

//    @Override
    public List<Post> getPostByAuthor(String author) {
        return postList.stream()
                .filter(p -> p.getAuthor().equals(author))
                .collect(Collectors.toList());
    }
}
