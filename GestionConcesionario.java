
package actividadT09;

import actividadT09.seguros.Seguro;
import actividadT09.vehiculos.Carga;
import actividadT09.vehiculos.Coche;
import actividadT09.vehiculos.*;

/**
 *
 * @author Candela
 */
public class GestionConcesionario {
    //declaro las variables fuera del main asi las puedo usar en algun metodo que cree
    //Un array de nombre “seguros” con dos seguros distintos
    private static Seguro seguro1;
    private static Seguro seguro2;
    private static Seguro[] seguros;
    
    // Un array de nombre “flota” con dos coches y dos vehículos de carga 
    private static Coche coche1;
    private static Coche coche2;
    private static Carga carga1;
    private static Carga carga2;
    private static Vehiculo []flota;
    
    //array alquiler del tipo IAlquilable para contener lo que el usuario quiera alquilar
    private static IAlquilable[]alquiler;
    private static int longitud;
      private static int opcion;
    private static int opcionInterna;
   private static int opcionVehiculo;
     private static int posArrayAlquiler=0;
     private static int opcionSeguro;
     private static int pos;
     private static int diasAlquiler;
    
    
    public static void main(String[] args) {
    //inicializo las variables
  
    
    seguro1=new Seguro("Veritas", "seguro accesible contra todo riesgo y terceros");
    seguro2=new Seguro("Confia","seguro contra terceros de rapida gestion");
    seguros=new Seguro[2];
    seguros[0]=seguro1;
    seguros[1]=seguro2;
    
    
    coche1=new Coche("CCCC9999", "Zonda familiar", 7, "A");
    coche2=new Coche("AAAA8888","Rutero",4,"B");
    carga1=new Carga("BBBB7777", "Liviano", 2, 2);
    carga2=new Carga("DDDD5555", "pesoPesado", 2, 20);
    flota=new Vehiculo[4];
    flota[0]=coche1;
    flota[1]=coche2;
    flota[2]=carga1;
    flota[3]=carga2;
    
    //inicializo el array alquilable asi puedo entrar a la opcion 4 
    alquiler=new IAlquilable[longitud];
    
    do{
        do {
    mostrarMenu();
    opcion= Utilidades.pideEntero("Introduce un valor entre 0 y 5");
    if (opcion<0||opcion>5){
          System.out.println("*****************************************************");
        System.out.println("Debes introducir un numero entre 0 y 5!!!!");
    }
    
        }while(opcion<0||opcion>5);
   
        switch(opcion){
            case 1:
               mostrarFlota();
                break;
            case 2:
                mostrarSeguros();
                break;
            case 3:
                setArrayAlquiler();
                break;
            case 4:
                setDiasAlquilerEnArray();
                break;
            case 5:

                mostrarAlquiler();
                break;
            case 0:System.out.println("Fin");
                return;
                
        }
            
            
            
        }while (opcion!=0);
    
    
    
    
    }
    
    public static void mostrarMenu(){
    System.out.println("-----------------------------------------------------------");
    System.out.println("-------Que quieres hacer?----------------------------------");
    System.out.println("1- Mostrar la informacion de la flota");
    System.out.println("2- Mostrar la informacion de los seguros");
    System.out.println("3- Reiniciar el alquiler indicando el total de vehiculos y seguros que se quiere alquilar");
    System.out.println("4- Establecer el numero de dias de alquiler");
    System.out.println("5- Mostrar el alquiler");
    System.out.println("0- Fin");
    }
    
    public static void mostrarFlota(){
         System.out.println("----------Nuestra flota de vehiculos disponibles---------- ");
                int i=0;
                for(Vehiculo e:flota){
                    System.out.println(i+"- Vehiculo "+e.toString());
                    i++;
                }
    }
   
  
    
    
    public static void mostrarSeguros(){
          System.out.println("----------Nuestros seguros disponibles----------------");
                int o=0;
                for(Seguro e:seguros){
                    System.out.println(o+ "- "+e.toString());
                    o++;
                }
    }
    
    
    public static void setArrayAlquiler(){
        System.out.println("-----------------------------------------------------------");
        longitud=0;
        posArrayAlquiler=0;
        longitud=Utilidades.pideEntero("Dime cuantos seguros/vehiculos quieres alquilar: ");
                
                alquiler=new IAlquilable[longitud];
                 
                pos=1;
                for(IAlquilable e:alquiler){
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Proceso de alquiler. Alquilando el "+pos+ " seguro o coche de "+longitud);
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("1- Añadir vehiculo al alquiler");
                    System.out.println("2- Añadir seguro al alquiler");
                    do{
                    opcionInterna=Utilidades.pideEntero("Elige una opcion: ");
                    if (opcionInterna<1||opcionInterna>2){
                        System.out.println("*******************************************************");
                        System.out.println("Debes elegir un numero entre 1 y 2!!!");
                    }
                    }while (opcionInterna<1||opcionInterna>2);
                    switch(opcionInterna){
                        case 1:
                           mostrarFlota();
                          
                           do{
                                System.out.println("-----------------------------------------------------------");
                           opcionVehiculo=Utilidades.pideEntero("Elige un vehiculo: ");
                           if (opcionVehiculo<0||opcionVehiculo>flota.length-1){
                                System.out.println("*******************************************************");
                               System.out.println("Debes elegir una opcion entre las que te di!!!");
                           }
                           }while(opcionVehiculo<0||opcionVehiculo>flota.length-1);
                           
                           alquiler[posArrayAlquiler]=flota[opcionVehiculo];
                           posArrayAlquiler++;
                            
                            break;
                        case 2:
                            mostrarSeguros();
                            do{
                                 System.out.println("-----------------------------------------------------------");
                            opcionSeguro=Utilidades.pideEntero("Elige un seguro: ");
                            if(opcionSeguro<0||opcionSeguro>seguros.length-1){
                                System.out.println("*******************************************************");
                                  System.out.println("Debes elegir una opcion entre las que te di!!!");
                            }
                            
                            }while(opcionSeguro<0||opcionSeguro>seguros.length-1);
                            alquiler[posArrayAlquiler]=seguros[opcionSeguro];
                            posArrayAlquiler++;
                            
                            break;
                    }
                    pos++;
                }
                
    }
    
    public static void setDiasAlquilerEnArray(){
        do{
              System.out.println("-----------------------------------------------------------");
               diasAlquiler=Utilidades.pideEntero("Cuantos dias dura el alquiler. Entre 1 y 30 dias?: ");
                if(diasAlquiler<1||diasAlquiler>30){
                    System.out.println("*******************************************************");
                     System.out.println("Debes elegir una opcion entre las que te di!!!");
                    
                }
                }while(diasAlquiler<1||diasAlquiler>30);
                for(IAlquilable e:alquiler){
                e.setNumeroDias(diasAlquiler);
                }
                System.out.println("Gracias");
    }
    
    public static void mostrarAlquiler(){
          System.out.println("-----------------------------------------------------------");
         System.out.println("Alquiler Actual");
                for(IAlquilable e:alquiler){
                    System.out.println(e.toString());
                    
                }
    }
    
}
