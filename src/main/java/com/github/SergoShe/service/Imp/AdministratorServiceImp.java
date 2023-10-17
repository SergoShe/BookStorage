package com.github.SergoShe.service.Imp;

import com.github.SergoShe.model.Administrator;
import com.github.SergoShe.repository.AdministratorRepository;
import com.github.SergoShe.service.AdministratorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImp implements AdministratorService {

    private final AdministratorRepository adminRepository;

    public AdministratorServiceImp(AdministratorRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void createAdministrator(Administrator administrator) {
        adminRepository.createAdministrator(administrator);
    }

    @Override
    public List<Administrator> getAllAdministrators() {
        return adminRepository.findAllAdministrators();
    }

    @Override
    public Administrator getAdministrator(long administratorId) {
        return adminRepository.findAdministratorById(administratorId);
    }

    @Override
    public Administrator updateAdministrator(Administrator administrator) {
        return adminRepository.updateAdministrator(administrator);
    }

    @Override
    public boolean deleteAdministrator(long administratorId) {
        long deletedId = adminRepository.deleteAdministratorById(administratorId);
        return administratorId == deletedId;
    }
}
