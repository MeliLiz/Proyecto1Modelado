import java.io.Serializable;

/**
 * Clase para el cliente
 */
public class Cliente implements Observador, Serializable {

    private String nombreUsuario;
    private String contrasena;
    private String nombreCliente;
    private int telefono;
    private String direccion;
    private int numCuentaBancaria;
    private String pais;
    private int ID;
    private double totalCompra;
    private Tienda tienda;
    private String deptoOferta;
    private Cuenta cuentaBancaria;

    /**
     * Constructor para clientes provisionales
     * 
     * @param nombreUsuario
     * @param contrasena
     */
    public Cliente(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    /**
     * Constructor con parametros
     * 
     * @param nombreUsuario  El nombre del usuario
     * @param contrasena     La constraseña del usurio
     * @param nombreCliente  El nombre del coliente
     * @param telefono       El telfono del cliente
     * @param direccion      La dirección del cliente
     * @param numCuentaBancaria La cuenta bancaria del cliente
     * @param pais           El país donde se encuentra el cliente
     * @param ID             El ID del cliente
     */
    public Cliente(String nombreUsuario, String contrasena, String nombreCliente, int telefono, String direccion, int numCuentaBancaria, String pais, int ID, Tienda tienda) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.numCuentaBancaria = numCuentaBancaria;
        this.pais = pais;
        this.ID = ID;
        this.totalCompra = 0;
        this.tienda = tienda;
        this.deptoOferta = "";
        cuentaBancaria=new Cuenta();
        tienda.registrar(this);//Al crear un cliente, la tienda lo registra automaticamente como un observador
        if(pais.equals(tienda.getPaisOfertaTienda())){
            this.actualizar();
        }
    }

    /**
     * Método que regresa el nombre de usuario del cliente
     * 
     * @return El nombre de usuario del cliente
     */
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    /**
     * Método para cambiar el nombre de usuario del cliente
     * 
     * @param nombreUuario El nuevo nombre de usuario del cliente
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Método que regresa la contraseña del cliente
     * 
     * @return La contraseña del cleinte
     */
    public String getContrasena() {
        return this.contrasena;
    }

    /**
     * Método para cambiar la contraseña del cliente
     * 
     * @param contrasena La nueva contraseña del cliente
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Método que regresa el nombre del cliente
     * 
     * @return El nombre del cliente
     */
    public String getNombreCliente() {
        return this.nombreCliente;
    }

    /**
     * Método para cambiar el nombre del cliente
     * 
     * @param nombreCliente El nuevo nombre del cliente
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * Método que regresa el telefono del cliente
     * 
     * @return El telefono del cliente
     */
    public int getTelefonoCliente() {
        return this.telefono;
    }

    /**
     * Método para cambiar el telefono del cliente
     * 
     * @param telefono El nuevo telefono del cliente
     */
    public void setTelefonoCliente(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Método que regresa la direccion del cliente
     * 
     * @return La direccion del cliente
     */
    public String getDireccionCliente() {
        return this.direccion;
    }

    /**
     * Método para cambiar el nombre del cliente
     * 
     * @param direccion El nuevo nombre del cliente
     */
    public void setDireccionCliente(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método para obtener la cuenta bancaria del cliente
     * @return
     */
    public Cuenta getCuentaBancaria(){
        return cuentaBancaria;
    }

    /**
     * Método que regresa la cuenta bancaria del cliente
     * 
     * @return La cuenta bancaria del cliente
     */
    public int getnumCuentaBancariaCliente() {
        return this.numCuentaBancaria;
    }

    /**
     * Método para cambiar la cuenta bancaria
     * 
     * @param numCuentaBancaria La nueva cuenta bancaria del cliente
     */
    public void setnumCuentaBancariaCliente(int numCuentaBancaria) {
        this.numCuentaBancaria = numCuentaBancaria;
    }

    /**
     * Método que regresa el pais del cliente
     * 
     * @return El pais del cliente
     */
    public String getPaisCliente() {
        return this.pais;
    }

    /**
     * Método para cambiar el pais del cliente
     * 
     * @param pais El nuevo pais del cliente
     */
    public void setPaisCliente(String pais) {
        this.pais = pais;
    }

    /**
     * Método que regresa el ID del cliente
     * 
     * @return El Id del cliente
     */
    public int getIdCliente() {
        return this.ID;
    }

    /**
     * Método para cambiar el ID del cliente
     * 
     * @param ID El nuevo ID del cliente
     */
    public void setPaisCliente(int ID) {
        this.ID = ID;
    }

    /**
     * Método que regresa el total de compra del cliente
     * 
     * @return El total de compra del cliente
     */
    public double getTotalCompraCliente() {
        return this.totalCompra;
    }

    /**
     * Método para cambiar el total de compra del cliente
     * 
     * @param totalCompra El nuevo total de compra del cliente
     */
    public void setTotalCompraCliente(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    /**
     * Método que regresa la tienda del cliente
     * 
     * @return La tienda del cliente
     */
    public Tienda getTiendaProxyCliente() {
        return this.tienda;
    }

    /**
     * Método para cambiar la tienda del cliente
     * 
     * @param tienda La nueva tienda del cliente
     */
    public void setPaisCliente(Tienda tienda) {
        this.tienda = tienda;
    }

    /**
     * Método que regresa la deptoOferta disponible del cliente
     * 
     * @return La deptoOferta disponible del cliente
     */
    public String getDeptoOferta() {
        return this.deptoOferta;
    }

    /**
     * Método para la deptoOferta disponible del cliente
     * 
     * @param deptoOferta La nueva deptoOferta disponible del cliente
     */
    public void setDeptoOferta(String deptoOferta) {
        this.deptoOferta = deptoOferta;
    }

    /**
     * 
     * Método para actualizar al Cliente
     */
    @Override
    public void actualizar() {
        if (pais.equals("México") || pais.equals("Mexico")) {
            deptoOferta = "Alimenticios";
        } else if (pais.equals("España")) {
            deptoOferta = "Electrodomésticos";
        } else if (pais.equals("Estados Unidos")) {
            deptoOferta = "Electrónica";
        }
    }

    /**
     * Metodo para obtener una representacion en cadena del cliente
     */
    @Override
    public String toString() {
        return nombreCliente + " " + pais;
    }  
}  
               