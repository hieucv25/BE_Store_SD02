package com.example.Be_Datn.Service;

import com.example.Be_Datn.Model.CustomModel.AuthRequest;
import com.example.Be_Datn.Model.CustomModel.AuthResponse;
import com.example.Be_Datn.Model.KhachHang;
import com.example.Be_Datn.Model.NhanVien;
import com.example.Be_Datn.Repository.KhachHangRepository;
import com.example.Be_Datn.Repository.NhanVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final NhanVienRepository nhanVienRepository;
    private final KhachHangRepository khachHangRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthResponse authenticate(AuthRequest authenticationRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        NhanVien nv = nhanVienRepository.getByEmail(authenticationRequest.getUsername()).orElse(null);
        if (nv == null) {
            KhachHang kh = khachHangRepository.getByEmail(authenticationRequest.getUsername()).orElseThrow();
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("CUSTOMER"));
            var jwtToken = jwtService.generateToken(kh, authorities);
            var jwtRefreshToken = jwtService.generateRefreshToken(kh);
            return AuthResponse.builder().token(jwtToken).refreshToken(jwtRefreshToken).build();
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(nv.getCv().getTenChucVu()));
        var jwtToken = jwtService.generateToken(nv, authorities);
        var jwtRefreshToken = jwtService.generateRefreshToken(nv);
        return AuthResponse.builder().token(jwtToken).refreshToken(jwtRefreshToken).build();
    }
}
