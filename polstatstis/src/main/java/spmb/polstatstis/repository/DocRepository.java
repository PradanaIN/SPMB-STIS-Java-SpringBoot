package spmb.polstatstis.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import spmb.polstatstis.entity.Doc;

public interface DocRepository  extends CrudRepository<Doc,Integer>{

    // Searching berdasarkan nama dokumen
    List<Doc> findBydocNameContains(String keyword);
}