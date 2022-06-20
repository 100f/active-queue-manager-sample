package dev.caio.study.queue.producer.dto;

public class MensagemDTO {
    private String mensagem;

    public MensagemDTO(String rotulo, String mensagem) {
        this.mensagem = mensagem;
    }
    public String getMensagem() { return mensagem; }

}
