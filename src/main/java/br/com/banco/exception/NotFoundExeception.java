package br.com.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExeception extends  RuntimeException {

        public Integer codigo = InvalidResponseCode.notFound.getResponseCode();
        public String mensagem = InvalidResponseCode.notFound.getMensagem();

        public NotFoundExeception(Integer id) {
            this.mensagem = this.mensagem + id;
        }
    }

