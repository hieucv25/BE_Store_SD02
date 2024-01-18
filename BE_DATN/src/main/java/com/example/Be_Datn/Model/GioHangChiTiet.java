package com.example.Be_Datn.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="GioHangChiTiet")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class GioHangChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="IdSanPham")
    private SanPham sp;

    @ManyToOne
    @JoinColumn(name="IdGioHang")
    private GioHang gh;

    @Column(name="SoLuong")
    private int soLuong;

    @Column(name="NgayChinhSua")
    private LocalDateTime ngaySua;
}
