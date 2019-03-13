package vn.edu.leading.kiemtra.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import vn.edu.leading.kiemtra.models.SinhVienModel;
import vn.edu.leading.kiemtra.repositories.SinhVienRepository;

import java.util.List;


@Service
public class SinhVienServicelmpl implements SinhVienService {

    private final SinhVienRepository sinhVienRepository;

    public SinhVienServicelmpl(SinhVienRepository sinhVienRepository) {
        this.sinhVienRepository = sinhVienRepository;
    }

    @Override
    public List<SinhVienModel> findAll() {
        return sinhVienRepository.findAll();
    }

    @Override
    public List<SinhVienModel> search(String term) {
        return sinhVienRepository.findByTenContaining(term);
    }

    @Override
    public SinhVienModel findById(Long id) {
        return sinhVienRepository.findById(id).get();
    }

    @Override
    public boolean update(SinhVienModel sinhVien) {
        SinhVienModel sinhVienModel = sinhVienRepository.findById(sinhVien.getId()).orElse(null);
        if (sinhVienModel == null)
            return false;
        sinhVienRepository.delete(sinhVienModel);
        return true;
    }

    @Override
    public void save(SinhVienModel sinhVien) {
        sinhVienRepository.save(sinhVien);
    }

    @Override
    public boolean delete(Long id) {
        SinhVienModel sinhVienModel = sinhVienRepository.findById(id).orElse(null);
        if(sinhVienModel==null)
            return false;
        sinhVienRepository.delete(sinhVienModel);
        return true;
    }
}
