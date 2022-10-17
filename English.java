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
        System.out.println("Your purchase it's been succefull");

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
                "You will have your product the day: " + diaEntrega + "/" + mesEntrega + "/" + "2022");
    }

    @Override
    public void mostrarMenuOpciones() {
        // TODO Auto-generated method stub

    }

    @Override
    public void enviarOfertas() {
        System.out.println("You are lucky, you have an offer available in yout country");

    }
}
