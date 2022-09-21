package spmb.polstatstis.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import spmb.polstatstis.entity.Peserta;

public interface PesertaRepo extends CrudRepository<Peserta, Long> {
    
    // Searching berdasarkan nama peserta
    List<Peserta> findByNamaContains(String keyword);

    
}
