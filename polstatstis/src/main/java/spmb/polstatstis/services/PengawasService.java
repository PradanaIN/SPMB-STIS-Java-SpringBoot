package spmb.polstatstis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spmb.polstatstis.entity.Pengawas;
import spmb.polstatstis.repository.PengawasRepo;

/* =============== PENGAWAS SERVICE =============== */
/*
*	Mengatur Service CRUD untuk Pengawas
*/
/* =============================================== */

@Service
public class PengawasService {
    
    @Autowired
    private PengawasRepo repo;

    // Menampilkan Semua pengawas 
    public Iterable<Pengawas> findAll(){
        return repo.findAll();
    }

    // Tambah pengawas baru
    public void addPengawas(Pengawas pengawas){
        repo.save(pengawas);
    }

    // public void deleteBy(Long id) {
    //     repo.deleteById(id);
    // }

    // Cari pengawas berdasarkan id
    public Optional<Pengawas> findById(Long id){
        return repo.findById(id);
        
    }

    // Update data pengawas  
    public void updatePengawas(Pengawas pengawas){
        repo.save(pengawas);
    }

    // Hapus pengawas berdasarkan id
    public void deletePengawas(Long id){
        repo.deleteById(id);
    }

    // Search nama pengawas berdasarkan keyword yang diinputkan
    public List<Pengawas> findByNamaContains(String keyword) {
        return repo.findByNamaContains(keyword);
    }
}
