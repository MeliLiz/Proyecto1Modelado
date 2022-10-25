import java.util.Random;

/**
 * Clase para el idioma en Ingles
 */
public class English implements Idioma {
    /**
     * Método para completar Compra
     */
    @Override
    public void saludar() {
        System.out.println("\nWelcome to our virtual store");
        System.out.println("The language of the store now is English");
    }

    /**
     * Método para dar fecha de entrega
     */
    @Override
    public void despedirse() {
        System.out.println("\nGood bye, see you soon");

    }

    /**
     * Método para mostrar menu de opciones
     */
    @Override
    public void completarCompra() {
        System.out.println("\nYour purchase has been successful");

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

        System.out.println("\nYou will receive your product by: " + diaEntrega + "/" + mesEntrega + "/" + "2022");
    }

    @Override
    public void mostrarMenuOpciones() {
        System.out.println("\nChoose an option");
        System.out.println("1) See product catalog");
        System.out.println("2) Buy product");
        System.out.println("3) Quit");

    }

    @Override
    public void anunciarOferta() {
        System.out.println("\nYou are lucky, you have a discount available in your country");

    }

    @Override
    public void pedirCuentaBancaria() {
        System.out.println("\nPlease enter your bank occount");
    }

    @Override
    public void compraSegura() {
        System.out.println("\n**Secure purchase**");

    }

    @Override
    public void porPagar(double porPagar) {
        System.out.println("You have to pay: $" + porPagar);

    }

    @Override
    public void ingresarCodigoProducto() {
        System.out.println("\nPlease enter the barcode of the product");
        System.out.println("If you're done adding products to your cart, please enter \"-1\"");
    }

    @Override
    public void errorCodigoProducto() {
        System.out.println("\nThe product doesn't exist");

    }

    @Override
    public void errorInput() {
        System.out.println("\nYou didn't enter a valid number");

    }

    @Override
    public void ofertaAplicada(String deptoOferta) {
        System.out.println("\nYou got 30% off on " + deptoOferta);
    }

    @Override
    public void subtotal(double subtotal) {
        System.out.println("\nSubtotal: $" + subtotal);

    }

    @Override
    public void total(double total) {
        System.out.println("Total: $" + total);

    }

    @Override
    public void menuCarrito() {
        System.out.println("\nChoose an option");
        System.out.println("1) Add to cart");
        System.out.println("2) Leave");
    }

    @Override
    public void productoAgregadoAlCarrito(String nommbreProducto) {
        System.out.println("\n" + nommbreProducto + " has been added to your cart");
    }

    @Override
    public void menuFinalizarCompra() {
        System.out.println("\nChoose an option");
        System.out.println("1) Checkout");
        System.out.println("2) Leave");
    }

    @Override
    public void errorCuentaBancaria() {
        System.out.println("You entered an invalid number of bank account, your purchase will be cancelled");
    }
}
