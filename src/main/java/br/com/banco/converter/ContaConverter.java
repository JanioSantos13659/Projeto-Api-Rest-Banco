package br.com.banco.converter;

import br.com.banco.dto.request.ContaRequest;
import br.com.banco.dto.response.ContaResponse;
import br.com.banco.entity.Cliente;
import br.com.banco.entity.Conta;
import br.com.banco.exception.NotFoundExeception;
import br.com.banco.repository.ClienteRepository;
import br.com.banco.repository.ContaRepository;
import br.com.banco.service.ContaService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class ContaConverter {

    @Autowired
    ContaService contaService;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ContaConverter contaConverter;

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    Converter converter;

    @Autowired
    ClienteConverter clienteConverter;

    public Conta convertToEntity(ContaRequest contaRequest) {

        Cliente cliente = clienteRepository.findById(contaRequest.getIdCliente()).orElseThrow(() -> new NotFoundExeception(contaRequest.getIdCliente()));

        Conta conta = new Conta();
        conta.setBanco(contaRequest.getBanco());
        conta.setDigito(contaRequest.getDigito());
        conta.setNumeroConta(contaRequest.getNumeroConta());
        conta.setCliente(cliente);

        return conta;
    }

    public ContaResponse convertToResponse(Conta conta) {

        ContaResponse contaResponse = new ContaResponse();

        contaResponse.setIdConta(conta.getIdConta());
        contaResponse.setSaldo(conta.getSaldo());
        contaResponse.setNumeroConta(conta.getNumeroConta());
        contaResponse.setBanco(conta.getBanco());
        contaResponse.setDigito(conta.getDigito());
        contaResponse.setCliente(clienteConverter.convertToCliente(conta.getCliente()));

        return contaResponse;
    }

    public List<ContaResponse> convertToResponse(List<Conta> contas) {

        List<ContaResponse> list = contas.stream()
                .map(entity -> convertToResponse(entity))
                .collect(Collectors.toList());

        return list;
    }

}
