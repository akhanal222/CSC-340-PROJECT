package com.CSC_340_PROJECT4.Project4.sysadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysAdminService {

    @Autowired
    private SysAdminRepository repo;

    public List<SysAdmin> getAllSysAdmins() {
        return repo.findAll();
    }

    public SysAdmin getSysAdmin(int id) {
        return repo.findById(id).orElse(null);
    }

    public void createSysAdmin(SysAdmin sysAdmin) {
        repo.save(sysAdmin);
    }

    public SysAdmin updateSysAdmin(int id, SysAdmin updatedSysAdmin) {
        SysAdmin sysAdmin = repo.findById(id).orElse(null);
        if (sysAdmin != null) {
            sysAdmin.setName(updatedSysAdmin.getName());
            sysAdmin.setEmail(updatedSysAdmin.getEmail());
            repo.save(sysAdmin);
        }
        return sysAdmin;
    }

    public void deleteSysAdmin(int id) {
        repo.deleteById(id);
    }

    public void monitorContent() {
        // will later put in code to monitor and moderate in-app content including reviews and profiles
        System.out.println("Monitoring content in the application.");
        // will later add implementation code here
    }

    public void handleContentModerationActions() {
        // will later put in code to handle content moderation actions
        System.out.println("Handling content moderation actions.");
        // will later add actual implementation code
    }

    public void manageSystemSettings() {
        // will later put in code to manage system settings and ensure the system runs smoothly
        System.out.println("Managing system settings.");
        // will later put implementation code
    }
}