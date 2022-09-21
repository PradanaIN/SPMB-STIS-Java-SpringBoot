package spmb.polstatstis.entity;

import java.sql.Date;

import javax.persistence.*;

/* =============== ENTITAS PESERTA =============== */
/*
*	nama            = nama peserta
*	jenis_kelamin   = jenis kelamin peserta
*	gambar          = foto profil peserta
*   tanggal_lahir   = tanggal lahir peserta
*   nik             = nik peserta
*   alamat          = alamat peserta
*   prodi           = prodi pilihan peserta
*   formasi         = formasi pilihan peserta (SPMB 2022)
*   tahap_1         = jadwal peserta untuk SPMB tahap 1
*   
*   NOTE : 
*   - terdapat tahap_2 dan tahap_3 
*   - atribut tersebut masih diberikan komentar karena
*       mengikuti alur SPMB itu sendiri
*   - atribut tersebut bisa diaktifkan apabila sudah
*       mencapai alur tersebut
*   - misalnya, apabila sudah Tahap 2 SPMB, atribut diaktifkan
*       sehingga peserta memuliki jadwal Tahap 2
*/
/* ================================================ */

@Entity
// custom table name peserta
@Table(name = "peserta")
public class Peserta {
    @Id
    // autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String gambar;

    @Column(length = 100, nullable = false)
    private String nama;

    @Column(length = 10, nullable = false)
    private String jenis_kelamin;

    @Column(length = 10, nullable = false)
    private Date tanggal_lahir;

    @Column(length = 16, nullable = false)
    private String nik;

    @Column(length = 50, nullable = false)
    private String alamat;

    @Column(length = 25, nullable = false)
    private String prodi;

    @Column(length = 25, nullable = false)
    private String formasi;

    @Column(length = 10, nullable = false)
    private Date tahap_1;

    // @Column(length = 10, nullable = true)
    // private Date tahap_2;

    // @Column(length = 10, nullable = true)
    // private Date tahap_3;

/* =================== Constructor ================= */
    public Peserta() {

    }

/* =============== Getter dan Setter =============== */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getFormasi() {
        return formasi;
    }

    public void setFormasi(String formasi) {
        this.formasi = formasi;
    }

    public Date getTahap_1() {
        return tahap_1;
    }

    public void setTahap_1(Date tahap_1) {
        this.tahap_1 = tahap_1;
    }
    
}
