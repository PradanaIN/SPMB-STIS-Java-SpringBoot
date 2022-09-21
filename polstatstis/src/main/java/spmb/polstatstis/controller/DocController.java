package spmb.polstatstis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import spmb.polstatstis.dto.SearchFromData;
import spmb.polstatstis.entity.Doc;
import spmb.polstatstis.services.DocStorageService;

/* ============= DOKUMEN CONTROLLER ============= */
/*
*	Mengontrol akses dan proses Dokumen
*/
/* ============================================== */

@Controller
public class DocController {

	@Autowired 
	private DocStorageService docStorageService;

	// Navigasi ke halaman laporan dan menampilkan semua daftar laporan
	@GetMapping("/daftar-laporan")
	public String get(Model model) {
        model.addAttribute("searchForm", new SearchFromData());
		Iterable<Doc> docs = docStorageService.getFiles();
		model.addAttribute("docs", docs);
		return "daftar-laporan";
	}
	
	// Mengatur proses upload file ke database
	@PostMapping("/uploadFiles")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile file: files) {
			docStorageService.saveFile(file);
			
		}
		return "redirect:/daftar-laporan";
	}

	// Mengatur proses download file dari database berdasarkan id
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId){
		Doc doc = docStorageService.getFile(fileId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
				.body(new ByteArrayResource(doc.getData()));
	}

	// Hapus file laporan berdasarkan id
    @GetMapping("/deleteFile/{id}")
    public String delete(@PathVariable("id") Integer id) {
        docStorageService.deleteFiles(id);
        return "redirect:/daftar-laporan";
    }

    // Mengontrol searching nama file berdasarkan keyword yang diinputkan
    @PostMapping("/search-laporan")
    public String searchlaporanAdmin(SearchFromData searchFromData, Model model) {
        // handler form kosong
        model.addAttribute("searchForm", searchFromData);
        model.addAttribute("docs", docStorageService.findBydocNameContains(searchFromData.getKeyword()));
        return "daftar-laporan";
    }
}
