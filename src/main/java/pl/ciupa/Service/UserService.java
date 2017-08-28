package pl.ciupa.Service;

import pl.ciupa.Entity.Blogers;

import java.util.List;

/**
 * Created by Kamil on 2017-08-23.
 */
public interface UserService {
    List<Blogers> findAll();
   // boolean authenticate(String username, String password);
    Blogers create(Blogers bloger);
    Blogers findById(Long id);
    Blogers edit(Blogers user);
    void deleteById(Long id);

}
