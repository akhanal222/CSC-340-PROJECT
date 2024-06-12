package com.CSC_340_PROJECT4.Project4.sysadmin;

import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwner;
import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwnerRepository;
import com.CSC_340_PROJECT4.Project4.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class SysAdminService {

    @Autowired
    private RestaurantOwnerRepository restaurantOwnerRepository;

    @Autowired
    private SysAdminRepository repo;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        if (repo.count() == 0) {
            SysAdmin defaultAdmin = new SysAdmin("genuadmin", "Genuine Admin", "admin@genu.com", "genu");
            repo.save(defaultAdmin);
        }
    }

    public List<SysAdmin> getAllSysAdmins() {
        return repo.findAll();
    }

    public List<RestaurantOwner> getAllRestaurantOwners() {
        return restaurantOwnerRepository.findAll();
    }

    public void deleteSysAdmin(int adminId) {
        repo.deleteById(adminId);
    }

    public void deleteUser(int userId) {
        userService.deleteUser(userId);
    }

    public boolean authenticateAdmin(String username, String password) {
        SysAdmin admin = repo.findByUsername(username);
        return admin != null && admin.getPassword().equals(password);
    }

    public void deleteRestaurant(int restaurantId) {
        restaurantOwnerRepository.deleteById(restaurantId);
    }
}




















//package com.CSC_340_PROJECT4.Project4.sysadmin;
//
//import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwnerRepository;
//import com.CSC_340_PROJECT4.Project4.user.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import jakarta.annotation.PostConstruct;
//import java.util.List;
//
//@Service
//public class SysAdminService {
//
//    @Autowired
//    private RestaurantOwnerRepository restaurantOwnerRepository;
//
//
//    @Autowired
//    private SysAdminRepository repo;
//
//    @Autowired
//    private UserService userService;
//
//    @PostConstruct
//    public void init() {
//        if (repo.count() == 0) {
//            SysAdmin defaultAdmin = new SysAdmin("genuadmin", "Genuine Admin", "admin@genu.com", "genu");
//            repo.save(defaultAdmin);
//        }
//    }
//
//    public List<SysAdmin> getAllSysAdmins() {
//        return repo.findAll();
//    }
//
//    public void deleteSysAdmin(int adminId) {
//        repo.deleteById(adminId);
//    }
//
//    public void deleteUser(int userId) {
//        userService.deleteUser(userId);
//    }
//
//    public boolean authenticateAdmin(String username, String password) {
//        SysAdmin admin = repo.findByUsername(username);
//        return admin != null && admin.getPassword().equals(password);
//    }
//
//    public void deleteRestaurant(int restaurantId) {
//        restaurantOwnerRepository.deleteById(restaurantId);
//    }
//}
