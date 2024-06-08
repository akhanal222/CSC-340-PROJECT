package com.CSC_340_PROJECT4.Project4.sysadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sysadmins")
public class SysAdminController {

    @Autowired
    private SysAdminService service;


    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable int userId) {
        service.deleteUser(userId);
    }


}

