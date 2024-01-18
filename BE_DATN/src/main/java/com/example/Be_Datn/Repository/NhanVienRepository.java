package com.example.Be_Datn.Repository;

import com.example.Be_Datn.Model.NhanVien;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien,Long> {
    @Override
    <S extends NhanVien> S saveAndFlush(S entity);

    @Override
    <S extends NhanVien> List<S> findAll(Example<S> example);

    @Override
    List<NhanVien> findAll();

    @Override
    <S extends NhanVien> S save(S entity);

    @Override
    Optional<NhanVien> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void deleteById(Long aLong);

    @Override
    Page<NhanVien> findAll(Pageable pageable);

    @Query("Select nv from NhanVien nv where nv.email = :email")
    Optional<NhanVien> getByEmail(@Param("email")String email);
}
