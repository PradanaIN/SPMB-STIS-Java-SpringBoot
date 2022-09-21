package spmb.polstatstis.entity;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/* ================= MY USER DETAILS ================= */
/*
*   Entitas ini diperlukan untuk SpringSecurity	
*/
/* ==================================================== */

public class MyUserDetails implements UserDetails {

    // Memanggil objek Pengawas 
    private Pengawas pengawas;

    public MyUserDetails(Pengawas pengawas) {
        this.pengawas = pengawas;
    }

    // Menyiapkan authority untuk setiap Role Pengawas
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = pengawas.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authorities;
    }

    // Mengambil data password Pengawas
    @Override
    public String getPassword() {
        return pengawas.getPassword();
    }

    // Mengambil data username Pengawas (NIP)
    @Override
    public String getUsername() {
        return pengawas.getUsername();
    }

    /* =============== Settinf Login SpringSecurity =============== */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return pengawas.isEnabled();
    }

}