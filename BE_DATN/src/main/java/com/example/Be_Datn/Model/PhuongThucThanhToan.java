package com.example.Be_Datn.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PhuongThucThanhToan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhuongThucThanhToan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Ten")
    private String ten;
}
