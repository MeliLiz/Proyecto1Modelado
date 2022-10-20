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
        // TODO Auto-generated method stub

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
        System.out.println("No ha ingresado un número");
        
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
}