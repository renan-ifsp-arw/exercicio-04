package br.edu.ifsp.dw2.exercicio04.resource;

import br.edu.ifsp.dw2.exercicio04.domain.Cliente;
import br.edu.ifsp.dw2.exercicio04.serice.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> listar(){
        Optional<List<Cliente>> clientes = clienteService.listar();
        return clientes.isPresent() ? ResponseEntity.ok(clientes.get()) : ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Optional<Cliente>> cliente = clienteService.getById(id);
        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody Cliente cliente){
        Optional<Cliente> clienteSalvo = clienteService.salvar(cliente);
        return clienteSalvo.isPresent() ? ResponseEntity.ok(clienteSalvo.get()) : ResponseEntity.noContent().build();
    }
}
