package pl.ciupa.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ciupa.Entity.Blogers;

/**
 * Created by Kamil on 2017-08-28.
 */

@Repository
public interface BlogerRepository extends JpaRepository<Blogers,Long>{
}
