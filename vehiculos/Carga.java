
package actividadT09.vehiculos;

import actividad07.ejercicio01.cuentaCorriente.Utilidades;

/**
 *
 * @author Candela
 */

//Crea en el package actividadT09.vehiculos una clase Carga que herede de Vehiculo 
public class Carga extends Vehiculo{
    //Atributos propios de la clase
    //El PMA (el peso máximo autorizado en toneladas)
    private double pma;
    private double sumaABase;
    private double precioXDiaCarga;
    private double precioTotalAcumuladoCarga;
    
    /****************************************************************************/
    //constructor
    public Carga (String mat, String mode,int pla,double pma){
        super(mat, mode, pla);
        this.pma=pma;
      
    }
   /*****************************************************************************/
    //Metodos heredados de la clase Vehiculo sobreescritos

    //Una función pideDatos() que sobrescriba la función heredada de Vehiculo  
    //y que pida y  establezca todos los  datos de Carga;
    @Override
     public void pideDatos(){
         super.pideDatos();
         this.pma=Utilidades.pideDouble(" pma: ");
         
     }
    
    //Una función getPrecioTotalAlquilerPorDias() que sobrescriba la función
    //heredada de Vehiculo y retorne el precio del alquiler teniendo presente
    //que al precio base se le suma  1.5 € * PMA (PMA = peso máximo autorizado en toneladas).
   
     @Override
    public double getPrecioTotalAlquilerPorDias() {
    double agregoPorTonelada=this.getsumaABase();
    precioTotalAcumuladoCarga=super.getPrecioTotalAlquilerPorDias()+agregoPorTonelada;
       
      return precioTotalAcumuladoCarga;
    } 
   
    //Sobrescribe toString() para que retorne información de todos los datos de Carga,
    //incluido su precio total de alquiler por días y PMA.
    @Override
     public String toString(){
         String informacion= super.toString();
         return informacion +" PMA: "+ this.getPma() +" Precio de alquiler por dia sumando extras: "+this.getprecioXDia()
                 + " Total de dias que se alquila: "+ super.getNumeroDias()+ " Precio total de alquiler por todos los dias: "+this.getPrecioTotalAlquilerPorDias();
    }
  
    /****************************************************************************/
    //Metodos propios
     
    public double getsumaABase(){
        sumaABase=1.5*pma;
        return sumaABase;
    }
    //metodo que calcula el precio por dia del vehiculo de carga
    public double getprecioXDia(){
       double extra= getsumaABase();
       precioXDiaCarga=super.getprecioBaseXdia()+extra;
       return precioXDiaCarga;
    }
  
    //getters y setters

    public double getPma() {
        return pma;
    }

    public void setPma(double pma) {
        this.pma = pma;
    }
    
    
}
