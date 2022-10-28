import java.io.Serializable;
/**
 * Clase que simula una cuenta de dinero
 * @see Serializable
 */
public class Cuenta implements Serializable{
    private double saldoDisponible;//Saldo disponible

    /**
     * Constructor de una cuenta
     */
    public Cuenta(){
        saldoDisponible=50000;//Saldo inicial 50000
    }

    /**
     * Metodo para depositar dinero a la cuenta
     * @param n
     * @return boolean false si no se pudo hacer el deposito, true si se realizó existosamente
     */
    public boolean depositar(double n){
        if(n<0){//No se puede depositar saldo negativo
            return false;
        }else{
            saldoDisponible+=n;
            return true;
        }
    }

    /**
     * Metodo para retirar dinero de la cuenta
     * @param n
     * @return boolean true si se realizó exitosamente, false si no se pudo
     */
    public boolean retirar(double n){
        if(n<0||n>saldoDisponible){//Si el numero es negativo o el saldo disponible no alcanza
            return false;
        }else{
            saldoDisponible-=n;
            return true;
        }
    }

    /**
     * Metodo para consultar el saldo disponible
     * @return
     */
    public double consultarSaldo(){
        return saldoDisponible;
    }

}
