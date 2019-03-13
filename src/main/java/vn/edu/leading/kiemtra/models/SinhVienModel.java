package vn.edu.leading.kiemtra.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "qlsv_sinh_vien")
public class SinhVienModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String ten;

    private Integer tuoi;

    @Column(name = "que_quan")
    private String queQuan;
}
