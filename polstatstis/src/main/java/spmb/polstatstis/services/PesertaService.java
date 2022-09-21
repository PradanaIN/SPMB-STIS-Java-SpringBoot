package spmb.polstatstis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spmb.polstatstis.entity.Peserta;
import spmb.polstatstis.repository.PesertaRepo;

/* =============== PESERTA SERVICE =============== */
/*
*	Mengatur Service CRUD untuk Peserta
*/
/* =============================================== */

@Service
public class PesertaService {

    @Autowired
    private PesertaRepo repo;

    // Menampilkan Semua pengawas
    public Iterable<Peserta> findAll(){
        return repo.findAll();
    }

    // Tambah peserta baru
    public void addPeserta(Peserta peserta){
        repo.save(peserta);
    }

    // Cari peserta berdasarkan id
    public Optional<Peserta> findById(Long id){
        return repo.findById(id);
        
    }

    // Update data peserta
    public void updatePeserta(Peserta peserta){
        repo.save(peserta);
    }

    // Hapus peserta berdasarkan id
    public void deletePeserta(Long id){
        repo.deleteById(id);
    }

    // public void deleteBy(Long id) {
    //     repo.deleteById(id);
    // }

    // Search nama peserta berdasarkan keyword yang diinputkan
    public List<Peserta> findByNamaContains(String keyword) {
        return repo.findByNamaContains(keyword);
    }
}