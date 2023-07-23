package com.pruebaTecnica.ticketsApp.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity @Getter @Setter
@Table(name = "tickets", catalog = "public")
public class Ticket {
    @Id
    @Column(name = "Id", insertable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Identificador de la tabla")
    private Long id;
    @Basic
    @Column(name = "UserName", length = 100, nullable = false)
    @Comment("Nombre de usuario")
    private String user;
    @Basic
    @Column(name = "CreatedAt", nullable = false)
    @Comment("Fecha de creacion del ticket")
    private OffsetDateTime createdAt;
    @Basic
    @Column(name = "UpdatedAt")
    @Comment("Fecha de actualizacion del ticket")
    private OffsetDateTime updatedAt;
    @Basic
    @Column(name = "Status", nullable = false)
    @Comment("Estado en el que se encuentra un ticket; abierto(1) cerrado(0)")
    private Boolean status;
}
