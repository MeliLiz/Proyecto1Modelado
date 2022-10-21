import java.util.Random;

/**
 * Clase para el idioma de Español de España
 */
public class EspanolEspana implements Idioma {
    /**
     * Método para completar Compra
     */
    @Override
    public void saludar() {
        System.out.println("Sea bienvenido a nuestra tienda virtual");
        System.out.println("El idioma de la tienda es ahora Español de España");
    }

    /**
     * Método para dar fecha de entrega
     */
    @Override
    public void despedirse() {
        System.out.println("Gracias por su compra, sos bienvenido cuando quieras");

    }

    /**
     * Método para mostrar menu de opciones
     */
    @Override
    public void completarCompra() {
        System.out.println("Su compra ha sido completada, teneis su compra pronto");

    }

    /**
     * Método para enviar ofertas
     */
    @Override
    public void darFechaDeEntrega() {
        Random numeroRandom = new Random(); // para generar un numero Randomx
        int diaEntrega = numeroRandom.nextInt(30); // nuemro random para el dia de entrega
        diaEntrega++; // para que el rango sea de 1 - 31

        int mesEntrega = numeroRandom.nextInt(12); // nuemro random para el mes de entrega
        mesEntrega++; // para que el rango sea de 1 - 12

        System.out.println(
                "Vos tendra su pedido el dia: " + diaEntrega + "/" + mesEntrega + "/" + "2022");
    }

    @Override
    public void mostrarMenuOpciones() {
        System.out.println("Elija una opcion");
        System.out.println("1) Ver catalogo de productos");
        System.out.println("2) Comenzar compra");
        System.out.println("3) Salir");
    }

    @Override
    public void anunciarOferta() {
        System.out.println("Sois afortunado, teneis una oferta disponible en su pais");

    }

    @Override
    public void pedirCuentaBancaria() {
        System.out.println("Favor de ingresar el numero de su cuenta de banco");
        
    }

    @Override
    public void compraSegura() {
        System.out.println("**Compra segura**");
        
    }

    @Override
    public void porPagar(double porPagar) {
        System.out.println("Vos debe pagar: $");
        
    }

    @Override
    public void errorCodigoProducto() {
        System.out.println("El producto que ha elegido no existe");
        
    }

    @Override
    public void errorInput() {
        System.out.println("No ha ingresado un número válido");
        
    }

    @Override
    public void ofertaAplicada(String deptoOferta) {
        System.out.println("Enhorabuena!, se ha aplicado un descuento en "+deptoOferta);
    }

    @Override
    public void subtotal(double subtotal) {
        System.out.println("Subtotal: $"+subtotal);
        
    }

    @Override
    public void total(double total) {
        System.out.println("Total: $"+total);
        
    }

    @Override
    public void menuCarrito() {
        System.out.println("Elija una opción");
        System.out.println("1) Añadir al carrito");
        System.out.println("2) Salir");
    }

    @Override
    public void ingresarCodigoProducto() {
        System.out.println("Por favor ingrese el codigo de barras del producto");
        System.out.println("Si ha terminado de poner productos en su carrito, ingrese \"-1\"");
    }

    @Override
    public void productoAgregadoAlCarrito(String nombreProducto) {
        System.out.println(nombreProducto+" ha sido añadido al carrito");
    }

    @Override
    public void menuFinalizarCompra() {
        System.out.println("Elija una opción");
        System.out.println("1) Terminar compra");
        System.out.println("2) Salir");
    }
}