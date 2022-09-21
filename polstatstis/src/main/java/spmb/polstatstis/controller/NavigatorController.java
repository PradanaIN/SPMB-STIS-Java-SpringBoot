package spmb.polstatstis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* ============= NAVIGATOR CONTROLLER ============= */
/*
*	Mengontrol akses dan proses navigasi sidebar
*/
/* ================================================ */

@Controller
public class NavigatorController {
    
    // Navigasi untuk logout ke halaman login
    @RequestMapping("/logout")
    public String logout() {
        return "login";
    }

    // Navigasi ke halaman dashboard
    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    // Navigasi ke halaman daftar pengawas
    @RequestMapping("/daftar-pengawas")
    public String daftarPengawas() {
        return "daftar-pengawas";
    }

    // Navigasi ke halaman daftar peserta
    @RequestMapping("/daftar-peserta")
    public String daftarPeserta() {
        return "daftar-peserta";
    }

    // Navigasi ke halaman jadwal
    @RequestMapping("/jadwal")
    public String jadwal() {
        return "jadwal";
    }

    // Navigasi ke halaman laporan
    @RequestMapping("/daftar-laporan")
    public String daftarLaporan() {
        return "daftar-laporan";
    }

    // Navigasi ke halaman tambah laporan
    @RequestMapping("/tambah-laporan")
    public String TambahLaporan() {
        return "tambah-laporan";
    }
}