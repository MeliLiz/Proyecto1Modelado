import java.util.Random;

/**
 * Clase para el idioma en Ingles
 * @see Idioma
 */
public class English implements Idioma {

    /**
     * Método para mostrar un saludo
     */
    @Override
    public void saludar() {
        System.out.println("\nWelcome to our virtual store");
        System.out.println("The language of the store now is English");
    }

    /**
     * Método para mostrar una despedida de la tienda
     */
    @Override
    public void despedirse() {
        System.out.println("\nGood bye, see you soon");

    }

    /**
     * Método para mostrar que la compra fue exitosa
     */
    @Override
    public void completarCompra() {
        System.out.println("\nYour purchase has been successful");

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

        System.out.println("\nYou will receive your product by: " + diaEntrega + "/" + mesEntrega + "/" + "2022");
    }

    /**
     * Metodo para mostrar el menu de opciones de la tienda
     */
    @Override
    public void mostrarMenuOpciones() {
        System.out.println("\nChoose an option");
        System.out.println("1) See product catalog");
        System.out.println("2) Buy product");
        System.out.println("3) Quit");

    }

    /**
     * Metodo para mostrar que el cliente tiene disponible una oferta
     * @param deptoOferta El departamento de oferta
     */
    @Override
    public void anunciarOferta(String deptoOferta) {
        System.out.println("\nYou are lucky, you have a discount available in your country: "+deptoOferta);

    }

    /**
     * Metodo para solicitar el numero de la cuenta bancaria del cliente
     */
    @Override
    public void pedirCuentaBancaria() {
        System.out.println("\nPlease enter your bank occount");
    }

    /**
     * Metodo para mostrar un mensaje de compra segura
     */
    @Override
    public void compraSegura() {
        System.out.println("\n**Secure purchase**");

    }

    /**
     * Metodo para indicar la cantidad a pagar
     */
    @Override
    public void porPagar(double porPagar) {
        System.out.println("You have to pay: $" + porPagar);

    }

    /**
     * Metodo para indicar que se debe ingresar el codigo de barrras del producto
     */
    @Override
    public void ingresarCodigoProducto() {
        System.out.println("\nPlease enter the barcode of the product");
        System.out.println("If you're done adding products to your cart, please enter \"-1\"");
    }

    /**
     * Metodo para indicar que el producto escogido no existe en la tienda
     */
    @Override
    public void errorCodigoProducto() {
        System.out.println("\nThe product doesn't exist");

    }

    /**
     * Metodo para indicar que no se ingreso un numero
     */
    @Override
    public void errorInput() {
        System.out.println("\nYou didn't enter a valid number");

    }

    /**
     * Metodo para indicar que se aplico una oferta
     */
    @Override
    public void ofertaAplicada(String deptoOferta) {
        System.out.println("\nYou got 30% off on " + deptoOferta);
    }

    /**
     * Metodo para indicar el subtotal de la compra
     */
    @Override
    public void subtotal(double subtotal) {
        System.out.println("\nSubtotal: $" + subtotal);

    }

    /**
     * Metodo para indicar el total de compra
     */
    @Override
    public void total(double total) {
        System.out.println("Total: $" + total);

    }

    /**
     * Metodo para mostrar el menu para añadir un producto al carrito o salir
     */
    @Override
    public void menuCarrito() {
        System.out.println("\nChoose an option");
        System.out.println("1) Add to cart");
        System.out.println("2) Leave");
    }

    /**
     * Metodo áta indicar que un producto se añadió al carrito
     */
    @Override
    public void productoAgregadoAlCarrito(String nommbreProducto) {
        System.out.println("\n" + nommbreProducto + " has been added to your cart");
    }

    /**
     * Metodo para mostrar un menu de finalizar compra o salir
     */
    @Override
    public void menuFinalizarCompra() {
        System.out.println("\nChoose an option");
        System.out.println("1) Checkout");
        System.out.println("2) Leave");
    }

    /**
     * Metodo para indicar que la cuenta bancaria ingresada es incorrecta
     */
    @Override
    public void errorCuentaBancaria() {
        System.out.println("You entered an invalid number of bank account, your purchase will be cancelled");
    }

    /**
     * Metodo para indicar que se está cerrando la sesión
     */
    @Override
    public void saliendo() {
        System.out.println("Logging out...");
    }

    /**
     * Método para indicar que no hay saldo suficiente en la cuenta del usuario
     */
    @Override
    public void saldoInsuficiente() {
        System.out.println("You don't have enough money in your bank account. Your purchase will be cancelled.");
    }
}
