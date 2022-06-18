package dev.caio.study.queue.consumer.dto;

import java.io.Serializable;

public class ApplicationMessage implements Serializable {
    private String rotulo;
    private String mensagem;

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
