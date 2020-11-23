package com.cainco.bootcamp.system;

import com.cainco.bootcamp.system.dao.IClienteDao;
import com.cainco.bootcamp.system.dao.IPedidoDao;
import com.cainco.bootcamp.system.dao.IZonaDao;
import com.cainco.bootcamp.system.dto.ClienteDTO;
import com.cainco.bootcamp.system.dto.DetallePedidoDTO;
import com.cainco.bootcamp.system.dto.PedidoDTO;
import com.cainco.bootcamp.system.dto.ResponseDTO;
import com.cainco.bootcamp.system.entity.Cliente;
import com.cainco.bootcamp.system.entity.Pedido;
import com.cainco.bootcamp.system.entity.Zona;
import com.cainco.bootcamp.system.services.IPedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class UnitTestsMethods {

    @Mock
    private IZonaDao zonaDao;

    @Mock
    private IClienteDao clienteDao;

    @Mock
    private IPedidoDao pedidoDao;


    @Mock
    private IPedidoService pedidoService;


    @InjectMocks
    private CasosUsoZonas casosUsoZonas;

    @InjectMocks
    private CasosUsoClientes casosUsoClientes;

    @InjectMocks
    private CasosUsoPedidos casosUsoPedidos;


    @BeforeEach
    public void inicializar() {
        //this.casosUsoZonas = new CasosUsoZonas()
    }


    @Test
    void verificarRegistroZonas() {

        Zona zona = new Zona();
        zona.setNombre("Av. Virgen de cotoca");
        zona.setEstado(1);

        Mockito.when(zonaDao.save(Mockito.any(Zona.class)))
                .thenReturn(zona);

        Zona zonaRegistrada = casosUsoZonas.verificarZonaRegistrada(zona);

        assertThat(zonaRegistrada.getNombre()).isEqualTo(zona.getNombre());

    }

    @Test
    void verificarNombreCompletoClienteRegistrado() {
        Cliente cliente = new Cliente();
        cliente.setNombres("Andrew");
        cliente.setApellidos("Garfield");
        cliente.setCi("1111");
        cliente.setTelefono("75324851");
        cliente.setLatitud(12.1);
        cliente.setLongitud(14.1);

        Mockito.when(clienteDao.save(Mockito.any(Cliente.class)))
                .thenReturn(cliente);

        Mockito.when(clienteDao.findByCi(cliente.getCi()))
                .thenReturn(cliente);

        casosUsoClientes.registrarCliente(cliente);
        Cliente clienteBuscado = casosUsoClientes.obtenerClientePorCI(cliente.getCi());


        String nombreCompletoEsperado = "Andrew Garfield";

        assertThat(clienteBuscado.getNombreCompleto())
                .isEqualTo(nombreCompletoEsperado);

    }

    @Test
    public void verificarImporteTotalPedido() {

        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.direccion = "Av chiriguano";
        pedidoDTO.idRepartidor = 1;
        pedidoDTO.idZona = 1;
        pedidoDTO.fechaHora = LocalDateTime.now();

        Cliente cliente = new Cliente();

        cliente.setCi("123456");
        cliente.setNombres("Flavio");
        cliente.setApellidos("Arteaga");
        //cliente.setTelefono("74441781");
        cliente.setNit("111AAA");
        cliente.setLatitud(12.031313);
        cliente.setLongitud(-12.031313);

        Mockito.when(clienteDao.findByCi(cliente.getCi()))
                .thenReturn(cliente);

        Cliente clienteBuscado = casosUsoClientes.obtenerClientePorCI(cliente.getCi());

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.idCliente = 1;
        clienteDTO.nombres = clienteBuscado.getNombres();
        clienteDTO.apellidos = clienteBuscado.getApellidos();
        clienteDTO.telefono = clienteBuscado.getTelefono();
        clienteDTO.latitud = clienteBuscado.getLatitud();
        clienteDTO.longitud = clienteBuscado.getLongitud();
        clienteDTO.nit = clienteBuscado.getNit();

        pedidoDTO.cliente = clienteDTO;

        DetallePedidoDTO detallePedidoDTO = new DetallePedidoDTO();
        detallePedidoDTO.cantidad = 3;
        detallePedidoDTO.idProducto = 1; //
        detallePedidoDTO.precioProducto = 20; // Hardcoded

        pedidoDTO.detalle = detallePedidoDTO;

        double importeTotalEsperado = detallePedidoDTO.cantidad * detallePedidoDTO.precioProducto;
        ResponseDTO r = new ResponseDTO();
        r.estado = 100;
        r.mensaje = "Pedido registrado exitosamente";

        Mockito.when(pedidoService.addPedido(Mockito.any(PedidoDTO.class)))
                .thenReturn(r);

        r = casosUsoPedidos.registrarPedido(pedidoDTO);

        Pedido pedidoEjemplo = new Pedido();
        pedidoEjemplo.setImporte_total(60);
        Mockito.when(pedidoDao.findTopByOrderByIdDesc())
                .thenReturn(pedidoEjemplo);

        Pedido ultimoPedidoRegistado = casosUsoPedidos.buscarUltimoPedido();

        assertThat(ultimoPedidoRegistado.getImporte_total())
                .isEqualTo(importeTotalEsperado);


    }


}

