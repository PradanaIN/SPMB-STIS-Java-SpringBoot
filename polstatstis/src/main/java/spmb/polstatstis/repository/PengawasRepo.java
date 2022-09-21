package spmb.polstatstis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import spmb.polstatstis.entity.Pengawas;

public interface PengawasRepo extends CrudRepository<Pengawas, Long> {
    
    // Searching berdasarkan nama pengawas
    List<Pengawas> findByNamaContains(String keyword);

    // Query untuk mengambil username (NIP) pengawas dari database
    @Query("SELECT u FROM Pengawas u WHERE u.username = :username")
    public Pengawas getPengwasByUsername(@Param("username") String username);
    Pengawas getPengawasByUsername(String username);

}
