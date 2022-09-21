package spmb.polstatstis.entity;

import javax.persistence.*;

/* =============== ENTITAS ROLE =============== */
/*
*	nama = nama role
*   
*   NOTE : 
*   - terdapat 2 role (Pengawas SPMB dan Panitia SPMB) 
*   - Pengawas SPMB : Create, Read, dan Searching
*   - Panitia SPMB  : CRUD dan Searching
*/
/* ============================================= */

@Entity
@Table(name = "roles")
public class Role {
    @Id
    // Autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long role_id;

    @Column(name = "name")
    private String name;

/* =================== Constructor ================= */
    public Role() {

    }

/* =============== Getter dan Setter =============== */
    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
