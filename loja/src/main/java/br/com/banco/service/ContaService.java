package br.com.banco.service;

import br.com.banco.converter.ContaConverter;
import br.com.banco.dto.request.ContaRequest;
import br.com.banco.dto.request.DepositoRequest;
import br.com.banco.dto.request.TransferenciaRequest;
import br.com.banco.dto.response.ContaResponse;
import br.com.banco.dto.response.DepositoResponse;
import br.com.banco.dto.response.TransferenciaResponse;
import br.com.banco.entity.Conta;
import br.com.banco.exception.NotFoundExeception;
import br.com.banco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    ContaService contaService;

    @Autowired
    ContaConverter contaConverter;


    public List<ContaResponse> getAllContas() {

        List<Conta> contas = new ArrayList<>();
        contaRepository.findAll().forEach(contas::add);
        ;

        return contaConverter.convertToResponse(contas);
    }

    public ContaResponse getConta(Integer idConta) {

        Conta conta = contaRepository.findById(idConta).orElseThrow(() -> new NotFoundExeception(idConta));

        return contaConverter.convertToResponse(conta);
    }


    public ContaResponse addConta(ContaRequest contaRequest) {

        Conta conta = contaConverter.convertToEntity(contaRequest);

        return contaConverter.convertToResponse(contaRepository.save(conta));

    }

    public TransferenciaResponse transfereEntreContas(TransferenciaRequest transferenciaRequest) {

        Conta contaOrigem = contaRepository.findByNumeroConta(transferenciaRequest.getNumeroContaOrigem());
        Conta contaDestino = contaRepository.findByNumeroConta(transferenciaRequest.getNumeroContaDestino());

        //Verificar se o Saldo não ficará negativo após a transferncia
        if (contaOrigem.getSaldo() >= transferenciaRequest.getValorTransferencia()) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - transferenciaRequest.getValorTransferencia());
            contaDestino.setSaldo(contaDestino.getSaldo() + transferenciaRequest.getValorTransferencia());

            Conta contaAtualizada = contaRepository.save(contaOrigem);


            return new TransferenciaResponse("01", "Tranferencia realizada com sucesso!!!");

        } else {

            return new TransferenciaResponse("02", "Transferencia invalida, valor não pode ser superior ou menor ao saldo da conta!!!");
        }
    }

   public DepositoResponse depositoContas(DepositoRequest depositoRequest){
         Conta conta = contaRepository.findByNumeroConta(depositoRequest.getNumeroContaDeposito());

         //Verificar se o valor do Deposito é maior que 2000 Reais
         if (depositoRequest.getValorDeposito() <= 2000){
             conta.setSaldo(conta.getSaldo() + depositoRequest.getValorDeposito());

             Conta contaAtualizada = contaRepository.save(conta);
             return new DepositoResponse("01", "Deposito realizado com suceeso");
         } else {
             return new DepositoResponse("02", "Valor do Deposito não pode ser superior a 2000");
         }
    }
}
