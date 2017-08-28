package pl.ciupa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.ciupa.Entity.Blogers;
import pl.ciupa.Repositories.BlogerRepository;

import java.util.List;

/**
 * Created by Kamil on 2017-08-28.
 */
@Service
@Primary
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private BlogerRepository userRepo;
    @Override
    public List<Blogers> findAll() {
        return this.userRepo.findAll();
    }
    @Override
    public Blogers findById(Long id) {
        return this.userRepo.findOne(id);
    }
    @Override
    public Blogers create(Blogers user) {
        return this.userRepo.save(user);
    }
    @Override
    public Blogers edit(Blogers user) {
        return this.userRepo.save(user);
    }
    @Override
    public void deleteById(Long id) {
        this.userRepo.delete(id);
    }

}
