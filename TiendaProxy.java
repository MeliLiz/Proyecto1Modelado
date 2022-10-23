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
    Scanner scanner=new Scanner(System.in);
    Scanner scanner2=new Scanner(System.in);
 
    /**
     * Constructor
     * @param tienda
     */
    public TiendaProxy(Tienda tienda){
        tiendaReal=tienda;
        carrito=new ArrayList<Producto>();;
    }


    @Override
    public Idioma iniciarSesion(Cliente cliente) {
        Idioma idiom=tiendaReal.iniciarSesion(cliente);
        if(idiom!=null){
            this.idioma=idiom;
            Integer id=tiendaReal.getIDCliente(cliente.getNombreUsuario(), cliente.getContrasena());
            idUsuario=id;
            deptoOferta=tiendaReal.getDeptoOferta(idUsuario);
            idioma.saludar();
            if(deptoOferta!=""){
                idioma.anunciarOferta();
            }
            menu();
        }else{
            System.out.println("Nombre de usuario o contraseña no válidos");
        }
        return null;
    }

    public void menu(){
        idioma.mostrarMenuOpciones();
        
        int respuesta=0;
        while(true){
            try {
                respuesta=scanner.nextInt();
                if(respuesta<4&&respuesta>0){
                    break;
                }else{
                    idioma.errorInput();
                }
            } catch (InputMismatchException e) {
                idioma.errorInput();
            }
        }
        switch (respuesta) {
            case 1:
                mostrarCatalogo();
                menu();
                break;
            case 2:
                comenzarCompra();
                break;
            case 3:
                salir();
                break;
        
            default:
                break;
        }
    }

    /**
     * Metodo para comenzar a realizar una compra
     */
    public void comenzarCompra(){
        tiendaReal.mostrarCatalogo();
        idioma.menuCarrito();
        int respuestaUsuario=0;
        while(true){
            try {
                respuestaUsuario=scanner.nextInt();
                if(respuestaUsuario>0&&respuestaUsuario<3){
                    break;
                }else{
                    idioma.errorInput();
                }
            } catch (InputMismatchException e) {
                idioma.errorInput();
            }
        }
        String codigoDeBarras="";
        if(respuestaUsuario==1){
            do{
                idioma.ingresarCodigoProducto();
                codigoDeBarras=scanner2.nextLine();
                Producto producto=tiendaReal.getProducto(codigoDeBarras);
                if(producto!=null){
                    agregarAlCarrito(codigoDeBarras);
                    idioma.productoAgregadoAlCarrito(producto.getNombre());
                }else{
                    if(!codigoDeBarras.equals("-1")){
                        idioma.errorCodigoProducto();
                    }
                }
            }while(!codigoDeBarras.equals("-1"));
            finalizarCompra();
            
        }else{
            salir();
        }
    }

    public void finalizarCompra(){
        idioma.menuFinalizarCompra();
        int respuesta=0;
        while (true) {
            try {
                respuesta=scanner.nextInt();
                if(respuesta>0&&respuesta<3){
                    break;
                }else{
                    idioma.errorInput();
                }
            } catch (InputMismatchException e) {
                idioma.errorInput();
            }
        }
        if(respuesta==1){
            realizarCompra(); 
        }else{
            salir();
        }
    }

    @Override
    public void mostrarCatalogo() {
        tiendaReal.mostrarCatalogo();
        
    }

    @Override
    public void realizarCompra() {
        System.out.println("ID: "+idUsuario);
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
                    idioma.darFechaDeEntrega();
                    break;
                }else{
                    idioma.errorCuentaBancaria();
                    cancelarCompra();
                    break;
                }
            } catch (InputMismatchException e) {
                idioma.errorInput();
            }
        }
        salir();
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
