package spmb.polstatstis.dto;

/* =========== ENSKAPSULASI INPUT KEYWORD ============= */
public class SearchFromData {

    private String keyword;

/* =================== Constructor ================= */
    public SearchFromData() {

    }

    public SearchFromData(String keyword) {
        this.keyword = keyword;
    }

/* =============== Getter dan Setter =============== */
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
