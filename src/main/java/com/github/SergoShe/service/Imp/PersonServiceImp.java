package com.github.SergoShe.service.Imp;

import com.github.SergoShe.model.Person;
import com.github.SergoShe.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServiceImp implements PersonService {

    public static final HashMap<Long,Person> PERSON_HASH_MAP = new HashMap<>();

    public static final AtomicLong PERSON_ID_HOLDER = new AtomicLong();

    @Override
    public void create(Person person) {
        long personId = PERSON_ID_HOLDER.incrementAndGet();
        person.setId(personId);
        PERSON_HASH_MAP.put(personId,person);
    }

    @Override
    public List<Person> readAll() {
        return new ArrayList<>(PERSON_HASH_MAP.values());
    }

    @Override
    public Person read(long id) {
        return PERSON_HASH_MAP.get(id);
    }

    @Override
    public boolean update(Person person, long id) {
        if (PERSON_HASH_MAP.containsKey(id)){
            person.setId(id);
            PERSON_HASH_MAP.put(id,person);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        return PERSON_HASH_MAP.remove(id) != null;
    }
}
