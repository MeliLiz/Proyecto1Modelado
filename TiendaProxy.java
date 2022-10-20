import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que simula la copia de la tienda que usa el usuario
 */
public class TiendaProxy implements Serializable, Servicio {

    Tienda tiendaReal;
    Idioma idioma;
    ArrayList<Producto> carrito;
    Integer idUsuario;
    String deptoOferta;
 
    /**
     * Constructor
     * @param tienda
     */
    public TiendaProxy(Tienda tienda){
        tiendaReal=tienda;
        carrito=new ArrayList<Producto>();;
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
            deptoOferta=tiendaReal.getDeptoOferta(idUsuario);
            if(deptoOferta!=""){
                idioma.anunciarOferta();
            }
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
        String deptoOferta=tiendaReal.getDeptoOferta(idUsuario);
        double suma=0;
        if(carrito.size()>0){
            for (Producto producto : carrito) {
                if(producto.getDepartamento().equals(deptoOferta)){
                    suma+=producto.getPrecio()-(0.30*producto.getPrecio());
                }else{
                    suma+=producto.getPrecio();
                }
            }
        }
        idioma.porPagar(suma);
        idioma.compraSegura();
        Scanner scanner=new Scanner(System.in);
        int numCuenta;
        while(true){
            idioma.pedirCuentaBancaria();
            try {
                numCuenta=scanner.nextInt();
                boolean verificado=tiendaReal.verificarCuentaDeBanco(idUsuario, numCuenta);
                if(verificado){
                    idioma.completarCompra();
                    mostrarTicket();
                    break;
                }else{
                    cancelarCompra();
                    break;
                }
            } catch (InputMismatchException e) {
                idioma.errorInput();
            }
        }
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
           idioma.errorCodigoProducto();
        }
    }

    public void cancelarCompra(){

    }

    public void mostrarTicket(){
        String deptoOferta=tiendaReal.getDeptoOferta(idUsuario);
        if(deptoOferta!=""){
            idioma.ofertaAplicada(deptoOferta);
        }
        double pagado=0;
        double subtotal=0;
        if(carrito.size()>0){
            for (Producto producto : carrito) {
                double precio=producto.getPrecio();
                System.out.println("$"+precio+"     "+producto.getNombre());
                if(producto.getDepartamento().equals(deptoOferta)){
                    pagado+=precio-(0.30*precio);
                }else{
                    pagado+=precio;
                }
                subtotal+=precio;
            }
        }
        idioma.subtotal(subtotal);
        idioma.total(pagado);
        idioma.despedirse();
        salir();

    }
}
