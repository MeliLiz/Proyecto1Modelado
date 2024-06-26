/**
 * Interfaz para los diferentes idiomas del sistema
 */
public interface Idioma {
    /**
     * Método para saludar
     */
    public void saludar();

    /**
     * Método para despedirse
     */
    public void despedirse();

    /**
     * Método para completar Compra
     */
    public void completarCompra();

    /**
     * Método para dar fecha de entrega
     */
    public void darFechaDeEntrega();

    /**
     * Método para mostrar menu de opciones
     */
    public void mostrarMenuOpciones();

    /**
     * Método para enviar ofertas
     * @param deptoOferta el departamento de oferta
     */
    public void anunciarOferta(String deptoOferta);

    /**
     * Metodo para pedir la cuenta bancaria al usuario
     */
    public void pedirCuentaBancaria();

    /**
     * Metodo para indicar que hay un error con la cuenta bancaria del usuario
     */
    public void errorCuentaBancaria();

    /**
     * Metodo para anunciar la pantalla de compra segura
     */
    public void compraSegura();

    /**
     * Metodo para indicar el total a pagar
     */
    public void porPagar(double porPagar);

    /**
     * Metodo para indicar un error de codigo de barras de un producto
     */
    public void errorCodigoProducto();

    /**
     * Metodo para indicar un error en input
     */
    public void errorInput();

    /**
     * Método para indicar una oferta que se aplicó
     * @param deptoOferta
     */
    public void ofertaAplicada(String deptoOferta);

    /**
     * Metodo para indicar el subtotal de compra
     */
    public void subtotal(double subtotal);

    /**
     * Metodo para indicar el total de compra
     * @param total
     */
    public void total(double total);

    /**
     * Metodo para agregar un producto al carrito o salir
     */
    public void menuCarrito();

    /**
     * Metodo para indicar que el usuario debe ingresar el codigo de barras de un producto
     */
    public void ingresarCodigoProducto();

    /**
     * Metodo para indicar que un producto se añadió exitosamente al carrito de compra
     */
    public void productoAgregadoAlCarrito(String nombreProducto);

    /**
     * Metodo para mostrar un menu con opciones de finalizar compra o salir
     */
    public void menuFinalizarCompra();

    /**
     * Método para indicar que se está cerrando la sesión
     */
    public void saliendo();

    /**
     * Método para indicar que la cuenta del cliente no tiene saldo suficiente para realizar la compra
     */
    public void saldoInsuficiente();
}
