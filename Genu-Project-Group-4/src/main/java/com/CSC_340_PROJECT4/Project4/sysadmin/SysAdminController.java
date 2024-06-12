package com.CSC_340_PROJECT4.Project4.sysadmin;

import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sysadmins")
public class SysAdminController {

    @Autowired
    private SysAdminService service;

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Admin/AdminDashboard";
    }

    @GetMapping("/login")
    public String adminLogin() {
        return "Admin/AdminLogin";
    }

    @GetMapping("/content-moderation")
    public String contentModeration() {
        return "Admin/ContentModeration";
    }

    @GetMapping("/user-management")
    public String userManagement(Model model) {
        List<SysAdmin> users = service.getAllSysAdmins();  // Change this to get all users
        List<RestaurantOwner> restaurantOwners = service.getAllRestaurantOwners();  // Assuming you have a method for this
        model.addAttribute("users", users);
        model.addAttribute("restaurantOwners", restaurantOwners);
        return "Admin/UserManagement";
    }

    @PostMapping("/login")
    public String loginAdmin(@RequestParam String username, @RequestParam String password, Model model) {
        if (service.authenticateAdmin(username, password)) {
            return "redirect:/sysadmins/dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "Admin/AdminLogin";
        }
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable int userId, Model model) {
        try {
            service.deleteUser(userId);
            return "redirect:/sysadmins/user-management";
        } catch (Exception e) {
            model.addAttribute("error", "Error deleting user");
            return "Admin/UserManagement";
        }
    }

    @DeleteMapping("/deleteRestaurant/{restaurantId}")
    public String deleteRestaurant(@PathVariable int restaurantId, Model model) {
        try {
            service.deleteRestaurant(restaurantId);
            return "redirect:/sysadmins/user-management";
        } catch (Exception e) {
            model.addAttribute("error", "Error deleting restaurant");
            return "Admin/UserManagement";
        }
    }
}
















//package com.CSC_340_PROJECT4.Project4.sysadmin;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/sysadmins")
//public class SysAdminController {
//
//    @Autowired
//    private SysAdminService service;
//
//    @DeleteMapping("/deleteUser/{userId}")
//    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
//        try {
//            service.deleteUser(userId);
//            return ResponseEntity.ok("User deleted successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
//        }
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> loginAdmin(@RequestParam String username, @RequestParam String password) {
//        if (service.authenticateAdmin(username, password)) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }
//
//    @GetMapping("/getUsername")
//    public ResponseEntity<String> getAdminUsername() {
//        List<SysAdmin> admins = service.getAllSysAdmins();
//        if (!admins.isEmpty()) {
//            SysAdmin admin = admins.get(0);
//            return ResponseEntity.ok(admin.getUsername());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/deleteRestaurant/{restaurantId}")
//    public ResponseEntity<String> deleteRestaurant(@PathVariable int restaurantId) {
//        try {
//            service.deleteRestaurant(restaurantId);
//            return ResponseEntity.ok("Restaurant deleted successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting restaurant");
//        }
//    }
//}
//
