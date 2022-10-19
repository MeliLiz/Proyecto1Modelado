import java.io.Serializable;
import java.util.ArrayList;

public class TiendaProxy implements Serializable, Servicio {

    Tienda tiendaReal;
    Idioma idioma;
    ArrayList<Producto> carrito;
    Integer idUsuario;

    public TiendaProxy(Tienda tienda){
        tiendaReal=tienda;
        carrito=new ArrayList<Producto>();
    }

    public void registrarse(Cliente cliente){
        tiendaReal.registrar(cliente);
    }

    @Override
    public Idioma iniciarSesion(Cliente cliente) {
        Idioma idiom=tiendaReal.iniciarSesion(cliente);
        if(idiom!=null){
            this.idioma=idiom;
            Integer id=tiendaReal.getIDCliente(cliente.getNombreUsuario(), cliente.getContrasena());
            idUsuario=id;
        }else{
            System.out.println("Nombre de usuario o contraseña no válidos");
        }
        return null;
    }

    @Override
    public void mostrarCatalogo() {
        tiendaReal.mostrarCatalogo();
        
    }

    @Override
    public void realizarCompra() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void salir() {
        tiendaReal.salir();
    }

    /**
     * Metodo para agregar un producto al carrito de compra
     * @param codigo el codigo de barras del producto 
     */
    public void agregarAlCarrito(String codigo){
        Producto producto=tiendaReal.getProducto(codigo);
        if(producto!=null){
            carrito.add(producto);
        }else{
            System.out.println("El codigo ingresado no corresponde a un producto en la tienda");
        }
    }

    public void cancelarCompra(){

    }

    public void mostrarTicket(){

    }
}
