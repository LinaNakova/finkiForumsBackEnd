package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Model.Admin;
import bazi.finki.ukim.mk.finkiforums.Service.AdminPanelService;
import bazi.finki.ukim.mk.finkiforums.Service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;
    private final AdminPanelService adminPanelService;

    public AdminController(AdminService adminService, AdminPanelService adminPanelService) {
        this.adminService = adminService;
        this.adminPanelService = adminPanelService;
    }

    @GetMapping("/all")
    public List<Admin> getAllAdmins(){
        return this.adminService.findAllAdmins();
    }

    @GetMapping("/admin-panel/{id}")
    public List<Map<String, Object>> getStats(@PathVariable int id){
        return adminPanelService.getStats(id);
    }

}
