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
    public void enviarOfertas() {
        System.out.println("Usted tiene una oferta disponible en su pais");

    }

}
