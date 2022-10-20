import java.util.Random;

/**
 * Clase para el idioma Español Latino
 */
public class EspanolLatino implements Idioma {

    /**
     * Método para completar Compra
     */
    @Override
    public void saludar() {
        System.out.println("Bienvenido a nuestra tienda virtual");

    }

    /**
     * Método para dar fecha de entrega
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
                "La fecha de entrega de su pedido sera el dia: " + diaEntrega + "/" + mesEntrega + "/" + "2022");
    }

    @Override
    public void mostrarMenuOpciones() {
        // TODO Auto-generated method stub

    }

    @Override
    public void anunciarOferta() {
        System.out.println("Usted tiene una oferta disponible en su pais");

    }

    @Override
    public void pedirCuentaBancaria() {
        System.out.println("Por favor ingrese su numero de cuenta bancaria");
    }

    @Override
    public void compraSegura() {
        System.out.println("**Compra segura**");
        
    }

    @Override
    public void porPagar(double porPagar) {
        System.out.println("Pir pagar: $");
        
    }

    @Override
    public void errorCodigoProducto() {
        System.out.println("No existe un producto con ese codigo");
        
    }

    @Override
    public void errorInput() {
        System.out.println("No ingresó un número");
        
    }

    @Override
    public void ofertaAplicada(String deptoOferta) {
        System.out.println("Se ha aplicado un descuento del 30% en "+deptoOferta);
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
