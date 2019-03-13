package vn.edu.leading.kiemtra.services;

import vn.edu.leading.kiemtra.models.SinhVienModel;

import java.util.List;

public interface SinhVienService {

    List<SinhVienModel> findAll();

    List<SinhVienModel> search (String term);

    SinhVienModel findById (Long id);

    boolean update (SinhVienModel sinhVien);

    void save (SinhVienModel sinhVien);

    boolean delete (Long id);

}
