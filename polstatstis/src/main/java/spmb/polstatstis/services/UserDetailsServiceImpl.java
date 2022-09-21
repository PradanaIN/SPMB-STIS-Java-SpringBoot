package spmb.polstatstis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import spmb.polstatstis.entity.MyUserDetails;
import spmb.polstatstis.entity.Pengawas;
import spmb.polstatstis.repository.PengawasRepo;

/* ============= USER DETAILS SERVICE ============= */
/*
*	Mengatur Service user (Pengawas) untuk Login
*/
/* =============================================== */

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PengawasRepo repo;
    
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Pengawas pengawas = repo.getPengawasByUsername(username);
        
        if (pengawas == null) {
            throw new UsernameNotFoundException("Akun tidak ditemukan");
        }
        
        return new MyUserDetails(pengawas);
    }
}