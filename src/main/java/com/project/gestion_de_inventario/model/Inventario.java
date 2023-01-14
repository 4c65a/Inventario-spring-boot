package com.project.gestion_de_inventario.model;


import com.project.gestion_de_inventario.security.user.Usuario;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre_de_producto", nullable = false)
    @NotBlank(message = "Nombre de producto")
    @Size(max = 100)
    private String nombreDeProducto;

    @Column(name = "cantidad", nullable = false)
    @NotBlank(message = "Cantidad de productos")
    @Min(value = 0)
    private Long cantidad;

    @Column(name = "categoria", nullable = false)
    @NotBlank(message = "Categoria de productos")
    private CategoriasEnum categoria;

    @Column(name = "proveedores", nullable = false)
    @NotBlank(message = "Proveedores de productos")
    @Size(max = 100)
    private String proveedores;

    @Column(name = "precio_por_unidad", nullable = false)
    @NotBlank(message = "Precio por unidad (Valor de un solo producto)")
    @Min(value = 0)
    private Double precioPorUnidad;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
