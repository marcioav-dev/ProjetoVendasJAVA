package com.br11.sistemavendas.entities;

import com.br11.sistemavendas.entities.keys.PedidoItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class PedidoItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PedidoItemPK id = new PedidoItemPK();
    private Integer qtde;
    private double valor;

    public PedidoItem(){

    }

    public PedidoItem(Pedido pedido, Produto produto, Integer qtde, double valor) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.qtde = qtde;
        this.valor = valor;
    }

    @JsonIgnore
    public Pedido getPedido(){
        return id.getPedido();
    }

    public void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    public void setProdutoo(Produto produto){
        id.setProduto(produto);
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoItem that = (PedidoItem) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Double getSubTotal(){
        return valor * qtde;
    }
}
