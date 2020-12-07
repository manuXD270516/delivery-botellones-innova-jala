package com.cainco.bootcamp.system.services;

import com.cainco.bootcamp.system.config.Validaciones;
import com.cainco.bootcamp.system.dao.IClienteDao;
import com.cainco.bootcamp.system.dao.IDetallePedidoDao;
import com.cainco.bootcamp.system.dao.IPedidoDao;
import com.cainco.bootcamp.system.dao.IProductoDao;
import com.cainco.bootcamp.system.dao.IRepartidorDao;
import com.cainco.bootcamp.system.dao.IZonaDao;
import com.cainco.bootcamp.system.dto.PedidoDTO;
import com.cainco.bootcamp.system.dto.ResponseDTO;
import com.cainco.bootcamp.system.entity.Cliente;
import com.cainco.bootcamp.system.entity.DetallePedido;
import com.cainco.bootcamp.system.entity.Pedido;
import com.cainco.bootcamp.system.entity.Producto;
import com.cainco.bootcamp.system.entity.Repartidor;
import com.cainco.bootcamp.system.entity.Zona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements IPedidoService {
    @Autowired
    private IPedidoDao pedidoDao;
    @Autowired
    private IDetallePedidoDao detallePedidoDao;
    @Autowired
    private IClienteDao clienteDao;
    @Autowired
    private IRepartidorDao repartidorDao;
    @Autowired
    private IZonaDao zonaDao;
    @Autowired
    private IProductoDao productoDao;

    @Autowired
    private Validaciones validaciones;

    public PedidoServiceImpl() {
    }

    public ResponseDTO addPedido(PedidoDTO pedido) {
        ResponseDTO response = new ResponseDTO();
        Pedido pedidoParaRegistro = new Pedido();
        Cliente cliente = new Cliente();
        DetallePedido detallePedido = new DetallePedido();
     
           
            cliente.setNombres(pedido.cliente.nombres);
            cliente.setApellidos(pedido.cliente.apellidos);
            cliente.setLatitud(pedido.cliente.latitud);
            cliente.setLongitud(pedido.cliente.longitud);
            cliente.setTelefono(pedido.cliente.telefono);
            cliente.setCi(pedido.cliente.ci);
        

       
        Optional<Repartidor> repartidorOptional = this.repartidorDao.findById(pedido.idRepartidor);
        if (repartidorOptional.isPresent()) {
            Repartidor repartidor = repartidorOptional.get();
            pedidoParaRegistro.setRepartidor(repartidor);
        } else {
            pedidoParaRegistro.setRepartidor(null);
        }

        Optional<Zona> zonaOptional = this.zonaDao.findById(pedido.idZona);
        if (zonaOptional.isPresent()) {
            Zona zona = zonaOptional.get();
            pedidoParaRegistro.setZona(zona);
        } else {
            pedidoParaRegistro.setZona(null);
        }

        pedidoParaRegistro.setDireccion(pedido.direccion);
        pedidoParaRegistro.setEstado(0);
        pedidoParaRegistro.setFecha_hora(pedido.fechaHora);
        pedidoParaRegistro.setTipo("Programado");

        pedidoParaRegistro = this.pedidoDao.save(pedidoParaRegistro);
        if (pedidoParaRegistro != null) {


            detallePedido.setCantidad(pedido.detalle.cantidad);
            detallePedido.setPrecio_venta(pedido.detalle.precioProducto);
            detallePedido.setImporte(pedido.detalle.cantidad * pedido.detalle.precioProducto);

            Optional<Producto> productoOptional = this.productoDao.findById(pedido.detalle.idProducto);
            if (productoOptional.isPresent()) {
                Producto producto = productoOptional.get();
                detallePedido.setProducto(producto);
            } else {
                detallePedido.setProducto(null);
            }

            detallePedido.setPedido(pedidoParaRegistro);
            this.detallePedidoDao.save(detallePedido);

            // Modificar si es mas de un item que se registre
            pedidoParaRegistro.setImporte_total(detallePedido.getImporte());
            pedidoDao.save(pedidoParaRegistro);
        }


        if (validaciones.validaCarnet(pedido.cliente.ci)) {
            response.estado = 200;
            response.mensaje = "Pedido registrado exitosamente";
            cliente=this.clienteDao.save(cliente);
            pedidoParaRegistro.setCliente(cliente);
            this.detallePedidoDao.save(detallePedido);
            this.pedidoDao.save(pedidoParaRegistro);
            
            
        } else {
            response.estado = 400;
            response.mensaje = "formato de carnet incorrecto";
        }


        return response;
    }

    @Override
    public List<PedidoDTO> listarPedidos() {
        List<PedidoDTO> pedidoDTOS = new ArrayList<>();


        pedidoDao.findAll()
                .forEach(pedido -> {
                    pedidoDTOS.add(PedidoDTO.convertir(pedido));
                });
        return pedidoDTOS;
    }
}
