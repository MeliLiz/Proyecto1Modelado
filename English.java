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
        System.out.println("Welcomo to our virtual store");

    }

    /**
     * Método para dar fecha de entrega
     */
    @Override
    public void despedirse() {
        System.out.println("Good bye, see you soon");

    }

    /**
     * Método para mostrar menu de opciones
     */
    @Override
    public void completarCompra() {
        System.out.println("Your purchase has been successful");

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
                "You will receive your product by: " + diaEntrega + "/" + mesEntrega + "/" + "2022");
    }

    @Override
    public void mostrarMenuOpciones() {
        // TODO Auto-generated method stub

    }

    @Override
    public void anunciarOferta() {
        System.out.println("You are lucky, you have a discount available in your country");

    }

    @Override
    public void pedirCuentaBancaria() {
        System.out.println("Please enter your bank occount");
    }

    @Override
    public void compraSegura() {
        System.out.println("**Secure purchase**");
        
    }

    @Override
    public void porPagar(double porPagar) {
        System.out.println("You have to pay: $");
        
    }

    @Override
    public void errorCodigoProducto() {
        System.out.println("The product doesn't exist");
        
    }

    @Override
    public void errorInput() {
        System.out.println("You didn't enter a number");
        
    }

    @Override
    public void ofertaAplicada(String deptoOferta) {
        System.out.println("You got 30% off on "+deptoOferta);
    }

    @Override
    public void subtotal(double subtotal) {
        System.out.println("Subtotal: $"+subtotal);
        
    }

    @Override
    public void total(double total) {
        System.out.println("Total: $"+total);
        
    }
}
