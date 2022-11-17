package main.modelos;

import main.Repositorio.ProductoRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductoTest {

    @Autowired
    private ProductoRepository repositorio;

    @Test
    @Rollback
    @Order(1)
    public void testGuardarProducto() {
        TipoProducto tipoProducto = new TipoProducto(6, "cositas");
        Marca marca = new Marca(6,"Saturno");
        Producto producto = new Producto(1, 1001, "helado rico", tipoProducto,marca, 200.00, 200.00, false);
        Producto productoGuardado = repositorio.save(producto);

        assertNotNull(productoGuardado);
    }

    @Test
    @Order(2)
    public void testBuscarProductoPorNombre() {
        String nombre = "Crocante";
        Producto producto = repositorio.findByName(nombre);

        assertThat(producto.getDescripcion()).isEqualTo(nombre);
    }

    @Test
    @Order(3)
    public void testBuscarProductoPorNombreNoExistente() {
        String nombre = "Mayonesa";
        Producto producto = repositorio.findByName(nombre);

        assertNull(producto);
    }

    @Test
    @Order(4)
    public void testListarProductos() {
        List<Producto> productos = (List<Producto>) repositorio.findAll();
        assertThat(productos).size().isGreaterThan(0); //compruba si el tamaño de la lista es mayor a 0
    }

    @Test
    @Rollback
    @Order(5)
    public void testEliminarProducto() {
        Integer id = 3;
        boolean esExistenteAntesDeEliminar = repositorio.findById(id).isPresent();
        repositorio.deleteById(id);
        boolean esNoExistenteDespuesDeEliminar = repositorio.findById(id).isPresent();

        assertTrue(esExistenteAntesDeEliminar);
        assertFalse(esNoExistenteDespuesDeEliminar);
    }
}
