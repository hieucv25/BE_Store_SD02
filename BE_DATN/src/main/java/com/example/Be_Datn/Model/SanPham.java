package com.example.Be_Datn.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="SanPham")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="MaSP")
    private String maSP;

    @Column(name="TenSP")
    private String tenSP;

    @Column(name="LoaiSanPham")
    private int loaiSanPham;

    @Column(name="SoLuong")
    private int soLuong;

    @Column(name="NgayTao")
    private LocalDateTime ngayTao;

    @Column(name="DonGia")
    private BigDecimal donGia;

    @Column(name="MoTa")
    private String moTa;

    @Column(name="TrangThai")
    private int trangThai;

    @Column(name="LinkAnh1")
    private String linkSP1;

    @Column(name="LinkAnh2")
    private String linkSP2;

    @Column(name="LinkAnh3")
    private String linkSP3;

    @Column(name="LinkAnh4")
    private String linkSP4;

    @Column(name="LinkAnh5")
    private String linkSP5;

    @Column(name="MauSac")
    private String mauSac;

    @Column(name="Size")
    private int size;

    @Column(name="DanhMuc")
    private int danhMuc;

    // các quan hệ

    @ManyToOne
    @JoinColumn(name="IdNhaCungCap")
    private NhaCungCap ncc;


}
