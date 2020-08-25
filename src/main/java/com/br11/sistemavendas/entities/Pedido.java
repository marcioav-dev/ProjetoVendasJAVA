package com.br11.sistemavendas.entities;

import com.br11.sistemavendas.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant dataHora;
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    public Pedido(){

    }

    public Pedido(Long id, Instant dataHora, PedidoStatus status, Usuario cliente) {
        this.id = id;
        this.dataHora = dataHora;
        setStatus(status);
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public void setDataHora(Instant dataHora) {
        this.dataHora = dataHora;
    }

    public PedidoStatus getStatus() {
        return PedidoStatus.valorCodigo(status);
    }

    public void setStatus(PedidoStatus status) {
        if (status != null) {
            this.status = status.getCodigo();
        }
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
