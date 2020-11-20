package com.cainco.bootcamp.system.services;

import com.cainco.bootcamp.system.dao.IProductoDao;
import com.cainco.bootcamp.system.dto.ProductoDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    private IProductoDao productoDao;

    public ProductoServiceImpl() {
    }

    public List<ProductoDTO> listarProductos() {
        List<ProductoDTO> productos = new ArrayList();
        int STATE_ENABLE = 1;
        this.productoDao.findByEstado(STATE_ENABLE).stream().forEach((prd) -> {
            ProductoDTO p = new ProductoDTO();
            p.idProducto = prd.getId();
            p.codigo = prd.getCodigo();
            p.nombre = prd.getNombre();
            p.precio_venta = prd.getPrecio_venta();
            p.descripcion = prd.getDescripcion();
            p.stock = prd.getStock();
            p.estado = prd.getEstado();
            productos.add(p);
        });
        return productos;
    }
}
