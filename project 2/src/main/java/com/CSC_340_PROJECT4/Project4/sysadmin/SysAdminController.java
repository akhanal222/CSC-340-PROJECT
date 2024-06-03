package com.CSC_340_PROJECT4.Project4.sysadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sysadmins")
public class SysAdminController {

    @Autowired
    private SysAdminService service;

    @GetMapping("/all")
    public List<SysAdmin> getAllSysAdmins() {
        return service.getAllSysAdmins();
    }

    @GetMapping("/{id}")
    public SysAdmin getSysAdmin(@PathVariable int id) {
        return service.getSysAdmin(id);
    }

    @PostMapping("/create")
    public void createSysAdmin(@RequestBody SysAdmin sysAdmin) {
        service.createSysAdmin(sysAdmin);
    }

    @PutMapping("/update/{id}")
    public SysAdmin updateSysAdmin(@PathVariable int id, @RequestBody SysAdmin updatedSysAdmin) {
        return service.updateSysAdmin(id, updatedSysAdmin);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSysAdmin(@PathVariable int id) {
        service.deleteSysAdmin(id);
    }

    @PostMapping("/monitorContent")
    public void monitorContent() {
        service.monitorContent();
    }

    @PostMapping("/handleContentModerationActions")
    public void handleContentModerationActions() {
        service.handleContentModerationActions();
    }

    @PostMapping("/manageSystemSettings")
    public void manageSystemSettings() {
        service.manageSystemSettings();
    }
}
