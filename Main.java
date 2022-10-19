import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    Scanner scanner=new Scanner(System.in);

    public void registro(){
        
        int opcion=0;
        while(true){
            System.out.println("Ingresa una opcion");
            System.out.println("1) Registrarse");
            System.out.println("2)Iniciar sesión");
            try {
                opcion=scanner.nextInt();
                if(opcion<3&&opcion>0){
                    break;
                }else{
                    System.out.println("Opcion no valida");
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }  
        }
        if(opcion==1){
            
        }else{

        }
        
    }
    public static void main(String[] args) {
        
    }
}
