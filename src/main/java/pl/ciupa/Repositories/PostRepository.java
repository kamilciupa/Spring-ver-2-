package pl.ciupa.Repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.ciupa.Entity.Post;

import java.util.List;



/**
 * Created by Kamil on 2017-08-28.
 */

@Repository
public interface PostRepository  extends JpaRepository<Post, Long>{

    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.author ORDER BY p.date DESC")
    List<Post> findLatest5Posts(Pageable pageable);
}
