package com.cainco.bootcamp.system.services;

import com.cainco.bootcamp.system.dto.ProductoDTO;
import java.util.List;

public interface IProductoService {
    List<ProductoDTO> listarProductos();
}
