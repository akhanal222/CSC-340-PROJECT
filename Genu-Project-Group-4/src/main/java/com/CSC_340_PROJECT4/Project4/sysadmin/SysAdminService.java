package com.CSC_340_PROJECT4.Project4.sysadmin;

import com.CSC_340_PROJECT4.Project4.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.util.List;

@Service
public class SysAdminService {

    @Autowired
    private SysAdminRepository repo;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        if (repo.count() == 0) {
            SysAdmin defaultAdmin = new SysAdmin("genuadmin", "Genuine Admin", "admin@genu.com", "genu", "ADMIN");
            repo.save(defaultAdmin);
        }
    }

    public List<SysAdmin> getAllSysAdmins() {
        return repo.findAll();
    }

    public void deleteUser(int userId) {
        userService.deleteUser(userId);
    }
}
