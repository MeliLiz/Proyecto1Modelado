import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que simula la copia de la tienda que usa el usuario
 */
public class TiendaProxy implements Serializable, Servicio {

    private Tienda tiendaReal;
    private Idioma idioma;
    private ArrayList<Producto> carrito;
    private Integer idUsuario;
    private String deptoOferta;
    private Scanner scanner=new Scanner(System.in);
    private Scanner scanner2=new Scanner(System.in);
 
    /**
     * Constructor
     * @param tienda
     */
    public TiendaProxy(Tienda tienda){
        tiendaReal=tienda;
        carrito=new ArrayList<Producto>();;
    }

    /**
     * Método para iniciar sesión
     * @param cliente El cliente que quiere iniciar sesión
     */
    @Override
    public Idioma iniciarSesion(Cliente cliente) {
        Idioma idiom=tiendaReal.iniciarSesion(cliente);//La tienda real inicia sesion y regresa el idioma correspondiente del cliente dependiendo de su país de orígen. Es null si no existe el cliente
        if(idiom!=null){
            this.idioma=idiom;//Asignamos el idioma de la tienda virtual dependiendo del idioma del cliente
            Integer id=tiendaReal.getIDCliente(cliente.getNombreUsuario(), cliente.getContrasena());//Obtenemos el id del cliente
            idUsuario=id;//la tienda virtual guarda el id del cliente
            deptoOferta=tiendaReal.getDeptoOferta(idUsuario);//se obtiene la oferta del usuario (si es que tiene una oferta disponible)
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

    /**
     * Método para mostrar el menú de opciones para mostrar el catalogo, comprar o salir
     */
    private void menu(){

        int respuesta=0;
        while(true){
            idioma.mostrarMenuOpciones();
            try {
                respuesta=scanner.nextInt();
                if(respuesta<4&&respuesta>0){
                    break;
                }else{
                    idioma.errorInput();
                }
            } catch (InputMismatchException e) {
                idioma.errorInput();
                scanner.next();
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
    private void comenzarCompra(){
        tiendaReal.mostrarCatalogo();
        int respuestaUsuario=0;
        while(true){
            idioma.menuCarrito();//Se dan opciones de añadir al carrito o salir
            try {
                respuestaUsuario=scanner.nextInt();
                if(respuestaUsuario>0&&respuestaUsuario<3){
                    break;
                }else{
                    idioma.errorInput();
                }
            } catch (InputMismatchException e) {
                idioma.errorInput();
                scanner.next();
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

    /**
     * Metodo paramostrar opciones de finalizar compra o salir
     */
    private void finalizarCompra(){
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
                scanner.next();
            }
        }
        if(respuesta==1){
            realizarCompra(); 
        }else{
            salir();
        }
    }

    /**
     * Método para mostrar el catálogo de la tienda
     */
    @Override
    public void mostrarCatalogo() {
        tiendaReal.mostrarCatalogo();
    }

    /**
     * Método para mostrar la cantidad a pagar y hacer una compra segura
     */
    private void realizarCompra() {
        System.out.println("ID: "+idUsuario);
        String deptoOferta=tiendaReal.getDeptoOferta(idUsuario);//Obtenemos la oferta (si es que tiene) del usuario
        double suma=0;
        //sumamos el precio de los productos (considerando los descuentos en los productos correspondientes)
        if(carrito.size()>0){
            for (Producto producto : carrito) {
                if(producto.getDepartamento().equals(deptoOferta)){
                    suma+=producto.getPrecio()-(0.30*producto.getPrecio());
                }else{
                    suma+=producto.getPrecio();
                }
            }
        }
        idioma.porPagar(suma);//mostramos la cantidad por pagar
        idioma.compraSegura();
        Scanner scanner=new Scanner(System.in);
        int numCuenta;
        while(true){
            idioma.pedirCuentaBancaria();
            try {
                numCuenta=scanner.nextInt();
                //La tienda real verifica que el numero de cuenta bancaria sea correcto
                boolean verificado=tiendaReal.verificarCuentaDeBanco(idUsuario, numCuenta);
                if(verificado){//si la cuenta bancaria es correcta
                    //la tienda real verifica que haya dinero suficiente en la cuenta de banco del usuario
                    verificado=tiendaReal.realizarCompra(suma, idUsuario);
                    if(verificado){//Si hay dinero suficiente, se completa la compra
                        idioma.completarCompra();
                        mostrarTicket();
                        idioma.darFechaDeEntrega();
                    }else{
                        idioma.saldoInsuficiente();
                    }
                    break;
                }else{//Si el numero de cuenta bancaria no es correcto
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

    /**
     * Metodo para indicar que se cierra la sesión del usuario
     */
    private void salir() {
        idioma.saliendo();
    }

    /**
     * Metodo para agregar un producto al carrito de compra
     * @param codigo el codigo de barras del producto 
     */
    private void agregarAlCarrito(String codigo){
        Producto producto=tiendaReal.getProducto(codigo);
        if(producto!=null){
            carrito.add(producto);
        }else{
           idioma.errorCodigoProducto();
        }
    }

    /**
     * Metodo para cancelar una compra/ salir de sesión
     */
    private void cancelarCompra(){
        idioma.saliendo();
    }

    /**
     * Método para mostrar el ticket de compra
     */
    private void mostrarTicket(){
        String deptoOferta=tiendaReal.getDeptoOferta(idUsuario);//Obtenemos la oferta del cliente (si tiene una)
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
