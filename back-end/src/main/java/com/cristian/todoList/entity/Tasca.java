package com.cristian.todoList.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tasques")
public class Tasca {

    //Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //
    @Column(name ="titol", nullable = false, length = 100)
    private String titol;

    @Column(name = "descripcio" , length = 150)
    private String descripcio;

    @Column(name = "estado", nullable = false)
    private boolean feta=false;

    //constructor


    public Tasca(String titol, String descripcio){
        this.titol=titol;
        this.descripcio=descripcio;
    }

}
