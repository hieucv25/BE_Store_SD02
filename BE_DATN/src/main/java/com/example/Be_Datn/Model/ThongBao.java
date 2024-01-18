package com.example.Be_Datn.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="ThongBao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ThongBao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="TrangThaiDonHang")
    private int trangThaiDonHang;

    @Column(name="NoiDung")
    private String noiDung;

    @Column(name="NgayGui")
    private LocalDateTime thoiGianGui;

//    @ManyToOne
//    @JoinColumn(name="IdDonHang")

}
