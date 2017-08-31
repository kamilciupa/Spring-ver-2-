/*package pl.ciupa.Service;

import org.springframework.stereotype.Service;
import pl.ciupa.Entity.Blogers;
import pl.ciupa.Entity.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Created by Kamil on 2017-08-23.
 *//*
@Service
public class UserServiceStubImpl implements UserService {

    private List<Blogers> blogers = new ArrayList<Blogers>() {{
        add(new Blogers(1L, "LELE", "LELELEL"));
        add(new Blogers(2L, "ADOLF", "MAgiczny jednorozec"));
    }};



    @Override
    public List<Blogers> findAll() {
        return this.blogers;
    }

    @Override
    public Blogers create(Blogers bloger) {
        bloger.setId(this.blogers.stream().mapToLong(
                p -> p.getId()).max().getAsLong() + 1);
        this.blogers.add(bloger);
        return bloger;
    }

    @Override
    public Blogers findById(Long id) {
        return null;
    }

    @Override
    public Blogers edit(Blogers user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
*/