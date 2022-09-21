package spmb.polstatstis.entity;

import java.sql.Date;
import java.util.*;

import javax.persistence.*;

/* =============== ENTITAS PENGAWAS =============== */
/*
*	nama    = nama pengawas
*	status  = status pengawas (Panitia atau Pengawas)
*	alamat  = alamat kantor pengawas
*   username= username pengawas (NIP)
*   password= password pengawas
*   gambar  = foto profil pengawas
*   tahap_1 = jadwal pengawas untuk SPMB tahap 1
*   lokasi_1= lokasi pengawas untuk SPMB tahap 1
*   
*   NOTE : 
*   - terdapat tahap_2, lokasi_2, tahap_3, dan lokasi_3 
*   - atribut tersebut masih diberikan komentar karena
*       mengikuti alur SPMB itu sendiri
*   - atribut tersebut bisa diaktifkan apabila sudah
*       mencapai alur tersebut
*   - misalnya, apabila sudah Tahap 2 SPMB, atribut diaktifkan
*       sehingga Pengawas memuliki jadwal dan lokasi Tahap 2
*/
/* ================================================ */

@Entity
@Table(name = "pengawas")
public class Pengawas {
    @Id
    // Autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nama;

    @Column(length = 50, nullable = false)
    private String status;

    @Column(length = 100, nullable = false)
    private String alamat; 

    @Column(length = 18, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String gambar;

    @Column(length = 10, nullable = true)
    private Date tahap_1;

    @Column(length = 25, nullable = true)
    private String lokasi_1;

    // @Column(length = 10, nullable = true)
    // private Date tahap_2;

    // @Column(length = 25, nullable = true)
    // private String lokasi_2;

    // @Column(length = 10, nullable = true)
    // private Date tahap_3;

    // @Column(length = 25, nullable = true)
    // private String lokasi_3;

/* =================== Spring Security ================= */
    private boolean enabled;

    // Relasi tabel database untuk mengambil id dan role pengawas
    // Digunakan agar login berdasarkan Rolenya (Authentication & Authorization)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    private Set<Role> roles = new HashSet<>();


/* =================== Constructor ================= */
    public Pengawas() {

    }

/* =============== Getter dan Setter =============== */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Date getTahap_1() {
        return tahap_1;
    }

    public void setTahap_1(Date tahap_1) {
        this.tahap_1 = tahap_1;
    }

    public String getLokasi_1() {
        return lokasi_1;
    }

    public void setLokasi_1(String lokasi_1) {
        this.lokasi_1 = lokasi_1;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

}
