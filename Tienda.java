import java.util.Hashtable;
import java.util.Set;
import java.util.Random;
import java.io.Serializable;

/**
 * Clase para la tienda virtual
 */
public class Tienda implements SujetoObservable, Servicio, Serializable {

    private Catalogo catalogo;// El catalogo que tiene la tienda
    private Hashtable<Integer, Cliente> clientes;//Los clientes que la tienda tiene registrados
    private Integer ultimoIDRegistrado;//El contador de clientes registrados
    private String paisOferta;

    /**
     * Constructor con un parametro
     * 
     * @param idioma El idioma de la tienda
     */
    public Tienda() {
        this.catalogo = new Catalogo("");
        this.clientes = new Hashtable<Integer, Cliente>();
        ultimoIDRegistrado=0;
    }

    /**
     * Metodo para obtener el numero de clientes registrados
     * @return
     */
    public Integer getUltimoIDRegistrado(){
        return ultimoIDRegistrado;
    }

    /**
     * Metodo para aumentar el contador de clientes registrados
     */
    public void aumentarUltimoIDRegistrado(){
        ultimoIDRegistrado++;
    }

    /**
     * Metodo para iniciar sesion
     * @param cliente El cliente que quiere iniciar sesion
     * @return Idioma null
     */
    @Override
    public Idioma iniciarSesion(Cliente cliente) {
        String nombreUsuario=cliente.getNombreUsuario();
        Integer id=existeUsuario(nombreUsuario);
        String contrasena=cliente.getContrasena();
        if(id!=-1){
            if(verificarContrasena(id, contrasena)){
                Cliente usuario=clientes.get(id);
                String pais= usuario.getPaisCliente();
                return getIdioma(pais);
            }
        }
        return null;
        
    }

    /**
     * Metodo para generar una oferta para un pais
     */
    public void generarOferta(){
        Random random=new Random();
        int num=random.nextInt(4);
        String paisOferta="";
        if(num==0){
            paisOferta="España";
        }else if(num==1){
            paisOferta="Estados Unidos";
        }else if(num==2){
            paisOferta="México";
        }
        this.paisOferta=paisOferta;
    }

    /**
     * Metodo para registrar a un cliente en la tienda
     * @param observador El nuevo cliente de la tienda
     */
    @Override
    public void registrar(Cliente observador) {
        if (observador == null) {
            System.out.println("No se pueden tener clientes null. Favor de registrar un cliente valido");
        } else {
            clientes.put(observador.getIdCliente(), observador);
            aumentarUltimoIDRegistrado();
        }

    }

    /**
     * Metodo para remover a un cliente de los clientes registrados
     */
    @Override
    public void remover(Cliente observador) {
        if (observador == null) {
            System.out.println("No se puede remover un cliente null");
        } else {
            clientes.remove(observador.getIdCliente());
        }

    }

    /**
     * Método para notificar a los clientes correspondientes que hay una oferta disponible
     */
    @Override
    public void notificar() {
        Set<Integer> llaves = clientes.keySet();
        generarOferta();

        if(paisOferta!=""){
            for (Integer llave : llaves) {
                if(clientes.get(llave).getPaisCliente().equals(paisOferta)){
                    clientes.get(llave).actualizar();
                }else{
                    clientes.get(llave).setDeptoOferta("");
                }
            }
        }else{
            for (Integer llave : llaves) {
                clientes.get(llave).setDeptoOferta("");
            }
        }
    }

    /**
     * Metodo para mostrar el catálogo de la tienda
     */
    @Override
    public void mostrarCatalogo() {
        catalogo.imprimirCatalogo();
    }

    /**
     * Método para obtener el catálogo de la tienda
     * 
     * @return El catálogo de la tienda
     */
    public Catalogo getCatalogo() {
        return this.catalogo;
    }

    /**
     * Metodo para saber si existe un usuario en el registro de usuarios de la tienda
     * @param nombreUsuario El nombre del usuario buscado
     * @return Integer El id del usuario buscado, -1 si no existe el usuario
     */
    private Integer existeUsuario(String nombreUsuario){
        Set<Integer> llaves = clientes.keySet();

        for(Integer llave: llaves){
            if(clientes.get(llave).getNombreUsuario().equals(nombreUsuario)){
                return clientes.get(llave).getIdCliente();
            }
        }
        return -1;
    }

    /**
     * Metodo para saber si la contraseña de un usuario es correcta
     * @param idUsuario El id del usuario que se busca
     * @param contrasena La contraseña del usuario que se busca
     * @return boolean true si la contraseña coincide con la de usuario, false en otro caso
     */
    private boolean verificarContrasena(Integer idUsuario, String contrasena){
        Cliente cliente=clientes.get(idUsuario);
        if(cliente!=null){
            if(cliente.getContrasena().equals(contrasena)){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para verificar la cuenta de banco del usuario
     * @param idUsuario El id del usuario
     * @param cuenta El numero de cuenta de banco del usuario
     * @return boolean true si la cuenta de banco coincide, false en otro caso
     */
    public boolean verificarCuentaDeBanco(Integer idUsuario, int cuenta){
        Cliente cliente=clientes.get(idUsuario);
        if(cliente!=null){
            if(cliente.getnumCuentaBancariaCliente()==cuenta){
                return true;
            }
        }
        return false;
    }

    /**
     * Método para hacer el movimiento de compra en la cuenta del cliente
     * @param cantidad
     * @param idUsuario
     * @return
     */
    public boolean realizarCompra(double cantidad, Integer idUsuario){
        Cliente cliente=clientes.get(idUsuario);
        if(cliente.getCuentaBancaria().consultarSaldo()<cantidad){
            return false;
        }else{
            cliente.getCuentaBancaria().retirar(cantidad);
            return true;
        }
    }

    /**
     * Metodo para obtener a un cliente del registro de clientes
     * @param nombre El nombre del usuario buscado 
     * @param contrasena La contraseña del usuario buscado
     * @return Cliente El cliente buscado
     */
    private Cliente getCliente(String nombre, String contrasena){//////////////////////////////////////////////////////////////////////////////Revisar este metodo
        Set<Integer> llaves = clientes.keySet();

        for(Integer llave: llaves){
            if(clientes.get(llave).getNombreUsuario().equals(nombre)){
                int ID=clientes.get(llave).getIdCliente();
                if(clientes.get(ID).getContrasena().equals(contrasena)){
                    int id=clientes.get(llave).getIdCliente();
                    return clientes.get(id);
                }
            }
        }
        return null;
    }

    /**
     * Metodo para obtener el ID de un usuario buscado
     * @param nombre El nobre de usuario
     * @param contrasena La contraseña del usuario
     * @return Integer el ID del usuario, -1 si no existe el usuario
     */
    public Integer getIDCliente(String nombre, String contrasena){
        Cliente usuario=getCliente(nombre, contrasena);
        if(usuario!=null){
            return usuario.getIdCliente();
        }else{
            return -1;
        }
        
    }

    /**
     * Metodo para obtener un idioma de acuerdo a un pais
     * @param pais El pais de origen
     * @return Idioma El idioma correspondiente al pais
     */
    private Idioma getIdioma(String pais){
        Idioma idioma=null;
        if(pais.equals("Estados Unidos")){
            idioma=new English();
        }else if(pais.equals("España")){
            idioma=new EspanolEspana();
        }else{
            idioma=new EspanolLatino();
        }
        return idioma;
    }

    /**
     * Método para cambiar el catálogo de la tienda
     * 
     * @param catalogo El nuevo catálogo de la tienda
     */
    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }


    /**
     * Método para obtener los clientes de la tienda
     * 
     * @return Los clientes de la tienda
     */
    public Hashtable<Integer, Cliente> getClientes() {
        return this.clientes;
    }

    /**
     * Método para cambiar los clientes de la tienda
     * 
     * @param clientes Los nuevos clientes de la tienda
     */
    public void setCatalogo(Hashtable<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Metodo para obtener un producto del catalogo
     * @param codigo El codigo de barras del producto
     * @return El producto que se busca, null si el producto no esta en el catalogo
     */
    public Producto getProducto(String codigo){
        Producto producto=catalogo.buscarProducto(codigo);
        return producto;
    }

    /**
     * Metodo para obtener el departamento que tiene oferta
     * @param idUsuario El id del usuario del que queremos saber su oferta (si tiene)
     * @return String El departamento que tiene oferta
     */
    public String getDeptoOferta(int idUsuario){
        Cliente cliente=clientes.get(idUsuario);
        if(cliente!=null){
            return cliente.getDeptoOferta();
        }
        return null;
    }

    /**
     * M+etodo para obtener el país que obtuvo oferta de la tienda
     * @return String El país que tiene oferta disponible
     */
    public String getPaisOfertaTienda(){
        return paisOferta;
    }

}