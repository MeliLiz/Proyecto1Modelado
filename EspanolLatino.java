import java.util.Random;

/**
 * Clase para el idioma Español Latino
 */
public class EspanolLatino implements Idioma {

    /**
     * Método para mostrar un saludo
     */
    @Override
    public void saludar() {
        System.out.println("Bienvenido a nuestra tienda virtual");
        System.out.println("El idioma de la tienda ahora es Español latino");
    }

    /**
     * Método para mostrar una despedida
     */
    @Override
    public void despedirse() {
        System.out.println("Hasta luego, gracias por su compra");

    }

    /**
     * Método para mostrar menu de opciones
     */
    @Override
    public void completarCompra() {
        System.out.println("Su compra se completado con exito");

    }

    /**
     * Método para dar una fecha estimada de entrega
     */
    @Override
    public void darFechaDeEntrega() {
        Random numeroRandom = new Random(); // para generar un numero Randomx
        int diaEntrega = numeroRandom.nextInt(30); // nuemro random para el dia de entrega
        diaEntrega++; // para que el rango sea de 1 - 31

        int mesEntrega = numeroRandom.nextInt(12); // nuemro random para el mes de entrega
        mesEntrega++; // para que el rango sea de 1 - 12

        System.out.println(
                "La fecha de entrega de su pedido sera el dia: " + diaEntrega + "/" + mesEntrega + "/" + "2022");
    }

    /**
     * Método para mostrar el menu de opciones del catalogo de la tienda
     */
    @Override
    public void mostrarMenuOpciones() {
        System.out.println("Seleccione una opcion");
        System.out.println("1) Ver catalogo de la tienda");
        System.out.println("2) Realizar compra");
        System.out.println("3) Cerrar sesión");
    }

    /**
     * Método para informar de una oferta disponible
     */
    @Override
    public void anunciarOferta() {
        System.out.println("Usted tiene una oferta disponible en su pais");

    }

    /**
     * Método para pedir el número cuenta bancaria del usuario
     */
    @Override
    public void pedirCuentaBancaria() {
        System.out.println("Por favor ingrese su numero de cuenta bancaria");
    }

    /**
     * Método para mostrar un mensaje de compra segura
     */
    @Override
    public void compraSegura() {
        System.out.println("**Compra segura**");
        
    }

    /**
     * Método para indicar el monto a pagar por la compra
     */
    @Override
    public void porPagar(double porPagar) {
        System.out.println("Pir pagar: $"+porPagar);
        
    }

    /**
     * Método para indicar que el codigo de barras ingresado no es valido
     */
    @Override
    public void errorCodigoProducto() {
        System.out.println("No existe un producto con ese codigo");
        
    }

    @Override
    public void errorInput() {
        System.out.println("No ingresó un número válido");
        
    }

    /**
     * Metodo para informar de una oferta aplicada
     */
    @Override
    public void ofertaAplicada(String deptoOferta) {
        System.out.println("Se ha aplicado un descuento del 30% en "+deptoOferta);
    }

    /**
     * Metodo para indicar el subtotal de compra
     */
    @Override
    public void subtotal(double subtotal) {
        System.out.println("Subtotal: $"+subtotal);
        
    }

    /**
     * Método para indicar el total de compra
     */
    @Override
    public void total(double total) {
        System.out.println("Total: $"+total);
        
    }

    /**
     * Metodo para mostrar un menu con opciones de añadir un producto al carrito o salir
     */
    @Override
    public void menuCarrito() {
        System.out.println("Seleccione una opción");
        System.out.println("1) Agregar producto al carrito");
        System.out.println("2) Salir");
    }

    /**
     * Metodo para pedir el codigo de barras del producto
     */
    @Override
    public void ingresarCodigoProducto() {
        System.out.println("Favor de ingresar el codigo de barras del producto");
        System.out.println("Si ya terminó de poner productos en su carrito, ingrese \"-1\"");
    }

    /**
     * Metodo para indicar que se agregó un producto al carrito de compra
     */
    @Override
    public void productoAgregadoAlCarrito(String nombreProducto) {
        System.out.println(nombreProducto+" se agregó al carrito");
    }

    /**
     * Metodo para mostrar un menú para finalizar una compra o salir
     */
    @Override
    public void menuFinalizarCompra() {
        System.out.println("Seleccione una opción");
        System.out.println("1) Finalizar compra");
        System.out.println("2) Salir");
    }

    /**
     * Método para indicar un error en el número de cuenta bancaria ingresada
     */
    @Override
    public void errorCuentaBancaria() {
        System.out.println("La cuenta bancaria ingresada no es correcta. Su compra se cancelará.");
    }

    /**
     * Método para indicar que se está cerrando la sesión
     */
    @Override
    public void saliendo() {
        System.out.println("Cerrando sesión...");
    }

    /**
     * Método para indicar que no hay saldo suficiente en la cuenta para realizar la compra
     */
    @Override
    public void saldoInsuficiente() {
        System.out.println("No hay saldo suficiente en su cuenta. Su compra se cancelará");
    }
}
