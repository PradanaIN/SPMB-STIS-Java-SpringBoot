package spmb.polstatstis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spmb.polstatstis.dto.SearchFromData;
import spmb.polstatstis.entity.Pengawas;
import spmb.polstatstis.services.PengawasService;

/* ============= PENGAWAS CONTROLLER ============= */
/*
*	Mengontrol akses dan proses navigasi pengawas
*/
/* =============================================== */

@Controller
@RequestMapping("")
public class PengawasController {

    @Autowired
    private PengawasService pengawasService;

    // Navigasi ke halaman login 
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    // Navigasi pengawas setelah login ke dashboard
    @GetMapping("/")
    public String home() {
        return "dashboard";
    }

    @PostMapping("/login")
    public String dashboard() {
        return "dashboard";
    }

    // Menampilkan semua data pengawas di halaman daftar pengawas
    @GetMapping("/daftar-pengawas")
    public String daftarPenagwasAdmin(Model model) {
        model.addAttribute("searchForm", new SearchFromData());
        model.addAttribute("pengawas", pengawasService.findAll());
        return "daftar-pengawas";
    }

    // Navigasi ke halaman tambah pengawas
    @GetMapping("/tambah-pengawas")
    public String tambahPengawasAdmin(Model model) {
        model.addAttribute("pengawas", new Pengawas());
        return "tambah-pengawas";
    }

    // Save data pengawas (Pengawas yang baru ditambahkan)
    @PostMapping("/save-pengawas")
    public String save(Pengawas pengawas, Model model) {
        pengawasService.addPengawas(pengawas);
        return "redirect:/daftar-pengawas";
    }

    // Hapus pengawas berdasarkan id
    @GetMapping("/delete-pengawas/{id}")
    public String delete(@PathVariable("id") Long id) {
        pengawasService.deletePengawas(id);
        return "redirect:/daftar-pengawas";
    }

    // Navigasi ke halaman edit pengawas berdasaerkan id
    @GetMapping("/edit-pengawas/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("pengawas", pengawasService.findById(id));
        return "edit-pengawas";
    }

    // Update data pengawas yang diedit
    @PostMapping("/update-pengawas")
    public String update(Pengawas pengawas, Model model) {
        pengawasService.updatePengawas(pengawas);
        return "redirect:/daftar-pengawas";
    }

    // Mengontrol searching nama pengawas berdasarkan keyword yang diinputkan
    @PostMapping("/search-pengawas")
    public String searchPengawasAdmin(SearchFromData searchFromData, Model model) {
        // handler form kosong
        model.addAttribute("searchForm", searchFromData);
        model.addAttribute("pengawas", pengawasService.findByNamaContains(searchFromData.getKeyword()));
        return "daftar-pengawas";
    }
}
