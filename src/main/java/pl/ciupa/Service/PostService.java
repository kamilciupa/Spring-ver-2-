package pl.ciupa.Service;

import pl.ciupa.Entity.Post;

import java.util.List;

/**
 * Created by Kamil on 2017-08-22.
 */
public interface PostService {
    List<Post> findAll();
    List<Post> findLatest5();
    Post findById(Long id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);
}
