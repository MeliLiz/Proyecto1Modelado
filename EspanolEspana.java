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
        System.out.println("\nSea bienvenido a nuestra tienda virtual");
        System.out.println("El idioma de la tienda es ahora Español de España");
    }

    /**
     * Método para dar fecha de entrega
     */
    @Override
    public void despedirse() {
        System.out.println("\nGracias por su compra, sos bienvenido cuando quieras");

    }

    /**
     * Método para mostrar menu de opciones
     */
    @Override
    public void completarCompra() {
        System.out.println("\nSu compra ha sido completada, teneis su compra pronto");

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

        System.out.println("\nVos tendra su pedido el dia: " + diaEntrega + "/" + mesEntrega + "/" + "2022");
    }

    @Override
    public void mostrarMenuOpciones() {
        System.out.println("\nElija una opcion");
        System.out.println("1) Ver catalogo de productos");
        System.out.println("2) Comenzar compra");
        System.out.println("3) Salir");
    }

    @Override
    public void anunciarOferta() {
        System.out.println("\nSois afortunado, teneis una oferta disponible en su pais");

    }

    @Override
    public void pedirCuentaBancaria() {
        System.out.println("\nFavor de ingresar el numero de su cuenta de banco");
        
    }

    @Override
    public void compraSegura() {
        System.out.println("\n**Compra segura**");
        
    }

    @Override
    public void porPagar(double porPagar) {
        System.out.println("\nVos debe pagar: $"+porPagar);
        
    }

    @Override
    public void errorCodigoProducto() {
        System.out.println("\nEl producto que ha elegido no existe");
        
    }

    @Override
    public void errorInput() {
        System.out.println("\nNo ha ingresado un número válido");
        
    }

    @Override
    public void ofertaAplicada(String deptoOferta) {
        System.out.println("\nEnhorabuena!, se ha aplicado un descuento en "+deptoOferta);
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
        System.out.println("\nElija una opción");
        System.out.println("1) Añadir al carrito");
        System.out.println("2) Salir");
    }

    @Override
    public void ingresarCodigoProducto() {
        System.out.println("\nPor favor ingrese el codigo de barras del producto");
        System.out.println("Si ha terminado de poner productos en su carrito, ingrese \"-1\"");
    }

    @Override
    public void productoAgregadoAlCarrito(String nombreProducto) {
        System.out.println("\n"+nombreProducto+" ha sido añadido al carrito");
    }

    @Override
    public void menuFinalizarCompra() {
        System.out.println("\nElija una opción");
        System.out.println("1) Terminar compra");
        System.out.println("2) Salir");
    }

    @Override
    public void errorCuentaBancaria() {
        System.out.println("La cuenta bancaria que ha ingresado no es correcta. Su compra se cancelará");
    }
}