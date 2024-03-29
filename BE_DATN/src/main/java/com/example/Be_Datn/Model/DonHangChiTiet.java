package com.example.Be_Datn.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="ChiTietDonHang")
public class DonHangChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="SoLuong")
    private int soLuong;

    @Column(name="NgayTao")
    private LocalDateTime ngayTao;

    @Column(name="GiaGoc")
    private BigDecimal giaGoc;

    @Column(name="GiaThoiDiemMua")
    private BigDecimal giaThoiDiemMua;

    @Column(name="TongTien")
    private BigDecimal TongTien;

    @ManyToOne
    @JoinColumn(name="IdDonHang")
    private DonHang dh;

    @ManyToOne
    @JoinColumn(name="IdSanPham")
    private SanPham sp;

    @ManyToOne
    @JoinColumn(name="IdKhuyenMai")
    private KhuyenMai km;
}
