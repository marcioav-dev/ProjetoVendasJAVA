package com.br11.sistemavendas.enums;

public enum PedidoStatus {

    AGUARDANDO(0),
    PGTO_ACEITO(1),
    ENVIADO(2),
    ENTREGUE(3),
    CANCELADO(4);

    private int codigo;

    private PedidoStatus(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public static PedidoStatus valorCodigo(int codigo){
        for (PedidoStatus valor : PedidoStatus.values()){
            if (valor.getCodigo() == codigo){
                return valor;
            }
        }
        throw new IllegalArgumentException("Codigo Invalido");
    }
}
