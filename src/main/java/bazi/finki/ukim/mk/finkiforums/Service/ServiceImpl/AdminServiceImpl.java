package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Model.Admin;
import bazi.finki.ukim.mk.finkiforums.Repository.AdminRepository;
import bazi.finki.ukim.mk.finkiforums.Service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> findAllAdmins() {
        return this.adminRepository.findAll();
    }
}
