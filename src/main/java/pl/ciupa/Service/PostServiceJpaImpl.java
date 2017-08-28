package pl.ciupa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import pl.ciupa.Entity.Post;
import pl.ciupa.Repositories.PostRepository;

import java.util.List;

/**
 * Created by Kamil on 2017-08-28.
 */
public class PostServiceJpaImpl implements PostService{
    @Autowired
    private PostRepository postRepo;
    @Override
    public List<Post> findAll() {
        return this.postRepo.findAll();
    }
    @Override
    public List<Post> findLatest5() {
        return this.postRepo.findLatest5Posts(new PageRequest(0, 5));
    }
    @Override
    public Post findById(Long id) {
        return this.postRepo.findOne(id);
    }
    @Override
    public Post create(Post post) {
        return this.postRepo.save(post);
    }
    @Override
    public Post edit(Post post) {
        return this.postRepo.save(post);
    }
    @Override
    public void deleteById(Long id) {
        this.postRepo.delete(id);
    }
}
