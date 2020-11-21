package com.cainco.bootcamp.system.services;

import com.cainco.bootcamp.system.dto.ClienteDTO;
import java.util.List;

public interface IClienteService {
    List<ClienteDTO> listarClientes();
}
