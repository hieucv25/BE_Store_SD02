package com.example.Be_Datn.Controller;

import com.example.Be_Datn.Model.CustomModel.AuthRequest;
import com.example.Be_Datn.Model.CustomModel.AuthResponse;
import com.example.Be_Datn.Model.NhanVien;
import com.example.Be_Datn.Repository.KhachHangRepository;
import com.example.Be_Datn.Repository.NhanVienRepository;
import com.example.Be_Datn.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*",allowCredentials = "true")
@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {
    @Autowired
    NhanVienRepository nvrp;
    @Autowired
    KhachHangRepository khrp;
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse>login(@RequestBody AuthRequest authenticationRequest){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

    @GetMapping("/test")
    public List<NhanVien> test(){
        return nvrp.findAll();
    }

    @GetMapping("/test2/{email}")
    public NhanVien test2(@PathVariable("email")String email){
        System.out.println(email);
        return nvrp.getByEmail(email).get();
    }


}

