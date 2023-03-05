package tech.ada.exemplos.salao.beleza.estoque.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("Produto")
public class Produto {
    @Id
    @Column("id")
    private Long id;
    private String nome;
    private String marca;
    private String unidade;
    private double quantidadeDaUnidade;


    private String identificador;

    private long unidadeEstoque;
}
