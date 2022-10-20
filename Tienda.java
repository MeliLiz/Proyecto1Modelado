import java.util.Hashtable;
import java.util.Set;
import java.util.Random;

/**
 * Clase para la tienda virtual
 */
public class Tienda implements SujetoObservable, Servicio {

    private Catalogo catalogo;
    private Hashtable<Integer, Cliente> clientes;

    /**
     * Constructor con un parametro
     * 
     * @param idioma El idioma de la tienda
     */
    public Tienda() {
        this.catalogo = new Catalogo("");
        this.clientes = new Hashtable<Integer, Cliente>();
    }

    @Override
    public Idioma iniciarSesion(Cliente cliente) {
        String nombreUsuario=cliente.getNombreUsuario();
        Integer id=existeUsuario(nombreUsuario);
        String contrasena=cliente.getContrasena();
        if(id!=-1){
            if(verificarContrasena(id, contrasena)){
                Cliente usuario=getCliente(nombreUsuario, contrasena);
                String pais= usuario.getPaisCliente();
                notificar();
                return getIdioma(pais);
            }
        }
        return null;
        
    }

    /**
     * Metodo para generar una oferta para un pais
     */
    public String generarOferta(){
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
        return paisOferta;
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
        }

    }

    @Override
    public void remover(Cliente observador) {
        if (observador == null) {
            System.out.println("No se puede remover un cliente null");
        } else {
            clientes.remove(observador.getIdCliente());
        }

    }

    @Override
    public void notificar() {
        Set<Integer> llaves = clientes.keySet();
        String paisOferta=generarOferta();

        if(paisOferta!=""){
            for (Integer llave : llaves) {
                if(clientes.get(llave).getPaisCliente().equals(paisOferta)){
                    clientes.get(llave).actualizar();
                }
            }
        }
    }

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
        Set<Integer> llaves = clientes.keySet();

        for(Integer llave: llaves){
            if(clientes.get(llave).getIdCliente()==idUsuario){
                if(clientes.get(llave).getContrasena().equals(contrasena)){
                    return true;
                }    
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
        Set<Integer> llaves = clientes.keySet();

        for(Integer llave: llaves){
            if(clientes.get(llave).getIdCliente()==idUsuario){
                if(clientes.get(llave).getCuentaBancariaCliente()==cuenta){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo para obtener a un cliente del registro de clientes
     * @param nombre El nombre del usuario buscado 
     * @param contrasena La contraseña del usuario buscado
     * @return Cliente El cliente buscado
     */
    private Cliente getCliente(String nombre, String contrasena){
        Set<Integer> llaves = clientes.keySet();

        for(Integer llave: llaves){
            if(clientes.get(llave).getNombreUsuario()==nombre){
                if(clientes.get(llave).getContrasena()==contrasena){
                    return clientes.get(llave);
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
        }else if(idioma.equals("España")){
            idioma=new EspanolEspana();
        }else{
            idioma=new EspanolLatino();
        }
        return idioma;
    }

    @Override
    public void salir() {
        // Escribir archivo
        
    }

    @Override
    public void realizarCompra() {
        
        
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

    public String getDeptoOferta(int idUsuario){
        Set<Integer> llaves = clientes.keySet();

        for(Integer llave: llaves){
            if(clientes.get(llave).getIdCliente()==idUsuario){
                return clientes.get(llave).getDeptoOferta();
            }
        }
        return null;
    }

}