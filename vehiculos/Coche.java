
package actividadT09.vehiculos;

import actividadT09.Utilidades;

/**
 *
 * @author Candela
 */
    //Crea en el package actividadT09.vehiculos una clase Coche que herede de Vehiculo
    public class Coche extends Vehiculo{
   //Variables de clase propias
    private double sumaABase;
    private double precioFinal;
    private String gama;
    private double precioDia;
//    private int numeroDiasQueSeAlquila;
     //La gama del Coche ( A, B , C , D)
    /****************************************************************************/    
    //constructor: llama al constructor de la super clase Vehiculo y le agrega la inicializacion de los atributos propios de la clase
    public Coche(String mat, String mode,int pla,String gama){
        super(mat, mode, pla);
        this.gama=gama;
        
    }
    /****************************************************************************/
    //Metodos heredados de la clase abstracta Vehiculo, sobreescritos

    //Una función pideDatos() que sobrescriba la función heredada de Vehiculo
    //y que pida y  establezca todos los  datos de Coche;
    @Override
    public void pideDatos(){
        super.pideDatos();
        gama=Utilidades.pideFrase("Gama? ");
    }

    //Una función getPrecioTotalAlquilerPorDias() que sobrescriba la función heredada
    //de Vehiculo y retorne el precio del alquiler teniendo presente que al
    //precio base se le suma la cantidad de 1.5 € por plaza y día.
    @Override
    public double getPrecioTotalAlquilerPorDias() {
        double sumaABase= this.getPrecioSumaABase();
        precioFinal=super.getPrecioTotalAlquilerPorDias()+ sumaABase;
      return precioFinal;
    }

    //Sobrescribe toString() para que retorne todos los datos del Coche, 
    //incluido su precio total de alquiler por días y la gama.
    @Override
    public String toString(){
        String informacion= super.toString();
        return informacion +" Gama: "+ this.getGama()+ " Precio por dia de alquiler sumando extras: "+this.getPrecioDia()
                + " Total de dias que se alquila: "+ super.getNumeroDias()+" Precio total por todos los dias: "+ this.getPrecioTotalAlquilerPorDias();
    }
        
   /*****************************************************************************/
   //Metodos Propios
  
    //funcion que calcula el precio unitario por dia del coche  
     public double getPrecioDia(){
       int plazas=super.getNumeroPlazas();
       double basePlaza= plazas*1.5;
       precioDia= super.getprecioBaseXdia()+ basePlaza;
       return precioDia;
   }
       
    //funcion que calcula el agregado de precio al base en funcion al numero de plazas y dias
    public double getPrecioSumaABase() {
        double precioPlazas= (super.getNumeroPlazas()*1.5);
        sumaABase= (precioPlazas*super.getNumeroDias());
        
        return sumaABase;
    }
 
    //getters setters
    public void setGama(String gama) {
        this.gama = gama;
    }

      public String getGama(){
       
        return gama;
    }
   
}
