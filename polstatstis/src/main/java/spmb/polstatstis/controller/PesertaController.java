package spmb.polstatstis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spmb.polstatstis.dto.SearchFromData;
import spmb.polstatstis.entity.Peserta;
import spmb.polstatstis.services.PesertaService;

@Controller
@RequestMapping("")
public class PesertaController {
        
    @Autowired
    private PesertaService pesertaService;
    
    // menampilkan data peserta
    @GetMapping("/daftar-peserta")
    public String daftarPesertaAdmin(Model model) {
        model.addAttribute("searchForm", new SearchFromData());
        model.addAttribute("peserta", pesertaService.findAll());
        return "daftar-peserta";
    }

    // menampilkan halaman tambah peserta
    @GetMapping("/tambah-peserta")
    public String tambahPeserta(Model model) {
        model.addAttribute("peserta", new Peserta());
        return "tambah-peserta";
    }
    
    // save peserta
    @PostMapping("/save-peserta")
        public String save(Peserta peserta, Model model) {
        pesertaService.addPeserta(peserta);
        return "redirect:/daftar-peserta";
    }

    // hapus peserta
    @GetMapping("/delete-peserta/{id}")
    public String delete(@PathVariable("id") Long id) {
        pesertaService.deletePeserta(id);
        return "redirect:/daftar-peserta";
    }

    // menampilkan halaman edit peserta
    @GetMapping("/edit-peserta/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("peserta", pesertaService.findById(id));
        return "edit-peserta";
    }

    // update peserta
    @PostMapping("/update-peserta")
    public String update(Peserta peserta, Model model) {
        pesertaService.updatePeserta(peserta);
        return "redirect:/daftar-peserta";
    }

    // controller search
    @PostMapping("/search-peserta")
    public String searchPesertaAdmin(SearchFromData searchFromData, Model model) {
        // handler form kosong
        model.addAttribute("searchForm", searchFromData);
        model.addAttribute("peserta", pesertaService.findByNamaContains(searchFromData.getKeyword()));
        return "daftar-peserta";
    }
}
