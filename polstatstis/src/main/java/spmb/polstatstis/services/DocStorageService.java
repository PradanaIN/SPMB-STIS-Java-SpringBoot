package spmb.polstatstis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import spmb.polstatstis.entity.Doc;
import spmb.polstatstis.repository.DocRepository;

/* =============== DOKUMEN SERVICE =============== */
/*
*	Mengatur Service CRUD untuk Dokumen
*/
/* =============================================== */

@Service
public class DocStorageService {
    @Autowired
    private DocRepository docRepository;

    // Menyimpan dokumen ke database (upload)
    public Doc saveFile(MultipartFile file) {
        String docname = file.getOriginalFilename();
        try {
            Doc doc = new Doc(docname,file.getContentType(),file.getBytes());
            return docRepository.save(doc);
        }
        catch(Exception e) {
                e.printStackTrace();
            }
            return null;
    }
    
    // Mendapatkan dokumen dari database berdasarkan id (download)
    public Optional<Doc> getFile(Integer id) {
        return docRepository.findById(id);
    }

    // Menampilkan dokumen dari database
    public Iterable<Doc> getFiles(){
        return docRepository.findAll();
    }

    // Menghapus dokumen berdasarkan id
    public void deleteFiles(Integer id){
        docRepository.deleteById(id);
    }

    // Search nama dokumen berdasarkan keyword yang diinputkan
    public List<Doc> findBydocNameContains(String keyword) {
        return docRepository.findBydocNameContains(keyword);
    }
}
