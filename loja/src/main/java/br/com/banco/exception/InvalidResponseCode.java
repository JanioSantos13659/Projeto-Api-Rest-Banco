package br.com.banco.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum InvalidResponseCode {

        notFound(404, "Registro inexistente - ID: ");


        private Integer responseCode;
        private String mensagem;

        InvalidResponseCode(Integer responseCode, String descricao) {
            this.responseCode = responseCode;
            this.mensagem = descricao;
        }

        public Integer getResponseCode() {
            return responseCode;
        }

        public String getMensagem() {
            return mensagem;
        }

    }


