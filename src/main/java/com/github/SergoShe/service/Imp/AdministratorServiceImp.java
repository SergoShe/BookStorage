package com.github.SergoShe.service.Imp;

import com.github.SergoShe.model.Administrator;
import com.github.SergoShe.repository.AdministratorRepository;
import com.github.SergoShe.service.AdministratorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AdministratorServiceImp implements AdministratorService {

    private final AdministratorRepository administratorRepository;
    public static final HashMap<Long,Administrator> ADMINISTRATOR_HASH_MAP = new HashMap<>();

    public static final AtomicLong ADMINISTRATOR_ID_HOLDER = new AtomicLong();

    public AdministratorServiceImp(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public void create(Administrator administrator) {
        long administratorId = ADMINISTRATOR_ID_HOLDER.incrementAndGet();
        administrator.setId(administratorId);
        ADMINISTRATOR_HASH_MAP.put(administratorId,administrator);
    }

    @Override
    public List<Administrator> getAll() {
        return administratorRepository.findAllAdministrators();
    }

    @Override
    public Administrator get(long id) {
        return ADMINISTRATOR_HASH_MAP.get(id);
    }

    @Override
    public boolean update(Administrator administrator) {
        if (ADMINISTRATOR_HASH_MAP.containsKey(id)){
            administrator.setId(id);
            ADMINISTRATOR_HASH_MAP.put(id,administrator);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        return ADMINISTRATOR_HASH_MAP.remove(id) != null;
    }
}
