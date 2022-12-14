package spmb.polstatstis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/* =============== ENTITAS FILE DOKUMEN =============== */
/*
*	docNama = memproses nama file  
*	docType = memproses tipe file 
*	byte = memproses ukuran file 
*/
/* ==================================================== */

@Entity
@Table(name="docs")
public class Doc {
	@Id
	// Autoincrement
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String docName;
	private String docType;
	@Lob
	private byte[] data;

/* =================== Constructor ================= */
	public Doc() {

	}

	public Doc(String docName, String docType, byte[] data) {
		super();
		this.docName = docName;
		this.docType = docType;
		this.data = data;
	}

/* =============== Getter dan Setter =============== */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
