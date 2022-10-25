import java.util.Random;

/**
 * Clase para el idioma de Español de España
 */
public class EspanolEspana implements Idioma {

    /**
     * Método para mostrar un saludo
     */
    @Override
    public void saludar() {
        System.out.println("\nSea bienvenido a nuestra tienda virtual");
        System.out.println("El idioma de la tienda es ahora Español de España");
    }

    /**
     * Método para mostrar una despedida
     */
    @Override
    public void despedirse() {
        System.out.println("\nGracias por su compra, sos bienvenido cuando quieras");

    }

    /**
     * Método para indicar que se completó una compra
     */
    @Override
    public void completarCompra() {
        System.out.println("\nSu compra ha sido completada, teneis su compra pronto");

    }

    /**
     * Método para mostrar la fecha estimada de entrega
     */
    @Override
    public void darFechaDeEntrega() {
        Random numeroRandom = new Random(); // para generar un numero Randomx
        int diaEntrega = numeroRandom.nextInt(30); // nuemro random para el dia de entrega
        diaEntrega++; // para que el rango sea de 1 - 31

        int mesEntrega = numeroRandom.nextInt(12); // nuemro random para el mes de entrega
        mesEntrega++; // para que el rango sea de 1 - 12

        System.out.println("\nVos tendra su pedido el dia: " + diaEntrega + "/" + mesEntrega + "/" + "2022");
    }

    /**
     * Metodo para mostrar el menu de opciones de catalogo de la tienda
     */
    @Override
    public void mostrarMenuOpciones() {
        System.out.println("\nElija una opcion");
        System.out.println("1) Ver catalogo de productos");
        System.out.println("2) Comenzar compra");
        System.out.println("3) Salir");
    }

    /**
     * Metodo para anunciar una oferta (si la hay disponible para el cliente)
     */
    @Override
    public void anunciarOferta() {
        System.out.println("\nSois afortunado, teneis una oferta disponible en su pais");

    }

    /**
     * Metodo para pedir el numero de cuenta bancaria del cliente
     */
    @Override
    public void pedirCuentaBancaria() {
        System.out.println("\nFavor de ingresar el numero de su cuenta de banco");
        
    }

    /**
     * Metodo para mostrar un mensaje de compra segura
     */
    @Override
    public void compraSegura() {
        System.out.println("\n**Compra segura**");
        
    }

    /**
     * Metodo para indicar la cantidad a pagar
     */
    @Override
    public void porPagar(double porPagar) {
        System.out.println("\nVos debe pagar: $"+porPagar);
        
    }

    /**
     * Metodo para indicar que el codigo de barras del producto ingresado no es correcto
     */
    @Override
    public void errorCodigoProducto() {
        System.out.println("\nEl producto que ha elegido no existe");
        
    }

    /**
     * Metodo para indicar que no se ingresó un número
     */
    @Override
    public void errorInput() {
        System.out.println("\nNo ha ingresado un número válido");
        
    }

    /**
     * Metodo para indicar que se aplicó una oferta en la compra
     */
    @Override
    public void ofertaAplicada(String deptoOferta) {
        System.out.println("\nEnhorabuena!, se ha aplicado un descuento en "+deptoOferta);
    }

    /**
     * Metodo para indicar el subtotal de la compra realizada
     */
    @Override
    public void subtotal(double subtotal) {
        System.out.println("Subtotal: $"+subtotal);
        
    }

    /**
     * Metodo para indicar el total de la compra
     */
    @Override
    public void total(double total) {
        System.out.println("Total: $"+total);
        
    }

    /**
     * Metodo para mostrar el menu para agregar productos al carrito o salir
     */
    @Override
    public void menuCarrito() {
        System.out.println("\nElija una opción");
        System.out.println("1) Añadir al carrito");
        System.out.println("2) Salir");
    }

    /**
     * Metodo para pedir que se ingrese el codigo de barras de un producto
     */
    @Override
    public void ingresarCodigoProducto() {
        System.out.println("\nPor favor ingrese el codigo de barras del producto");
        System.out.println("Si ha terminado de poner productos en su carrito, ingrese \"-1\"");
    }

    /**
     * Metodo para informar que se agregó un producto al carrito
     */
    @Override
    public void productoAgregadoAlCarrito(String nombreProducto) {
        System.out.println("\n"+nombreProducto+" ha sido añadido al carrito");
    }

    /**
     * Método para mostrar un menu para finalizar una compra o salir
     */
    @Override
    public void menuFinalizarCompra() {
        System.out.println("\nElija una opción");
        System.out.println("1) Terminar compra");
        System.out.println("2) Salir");
    }

    /**
     * Metodo para indicar que el numero de cuenta bancaria es incorrecto
     */
    @Override
    public void errorCuentaBancaria() {
        System.out.println("La cuenta bancaria que ha ingresado no es correcta. Su compra se cancelará");
    }

    /**
     * Método para indicar que se está cerrando la sesión
     */
    @Override
    public void saliendo() {
        System.out.println("Saliendo de sesión...");
    }
}