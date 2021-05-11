
package actividadT09.vehiculos;

import actividad07.ejercicio01.cuentaCorriente.Utilidades;

/**
 *
 * @author Candela
 */
//Crea en el package actividadT09.vehiculos una clase abstracta Vehiculo que implemente IAlquilable 

public abstract class Vehiculo implements IAlquilable {
//Variables de clase
//como mínimo ha de almacenar:
//La matrícula, modelo, numero de plazas, numero de dias que se alquila(por defecto 0)
private String matricula;
private String modelo;
private int numeroPlazas;
private int numeroDiasQueSeAlquila;
private double precioTotal;
//El precio base de alquiler por cada día establecido en 50€  y que no se pueda modificar. 
private final double precioBaseAlquilerPorDia;
/********************************************************************************/
    //Constructor
    public Vehiculo(String matri,String mode,int plazas){
    matricula=matri;
    modelo=mode;
    numeroPlazas=plazas;
    this.precioBaseAlquilerPorDia=50;
    this.numeroDiasQueSeAlquila=1;
    
    }
    /****************************************************************************/
    //Metodos heredados de la interface IAlquilable
    @Override
   public void setNumeroDias(int dias) {
        numeroDiasQueSeAlquila=dias;
        
    }
   
    //Una función getPrecioTotalAlquilerPorDias() que muestre por consola
    //el coste total multiplicando el número de días por el precio base.
    @Override
    public double getPrecioTotalAlquilerPorDias() {
   
        precioTotal= numeroDiasQueSeAlquila*precioBaseAlquilerPorDia;
      return precioTotal;
    }
    
    /****************************************************************************/
    //Metodos Propios
    
      //getters y setters

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    
    public double getprecioBaseXdia(){
        return precioBaseAlquilerPorDia;
    }
    
     
    public int getNumeroPlazas(){
        return numeroPlazas;
    }
    
    public void setNumeroPlazas(int plazas){
        numeroPlazas=plazas;
    }
    
      public int getNumeroDias(){
        return numeroDiasQueSeAlquila;
    }
      /**************************************************************************/
    //Otro metodos propios
    
    //Una función pideDatos() que pida y establezca todos los  datos de Vehiculo;
    public void pideDatos(){
       this.modelo=Utilidades.pideFrase("Cual es el modelo?: ");
       this.matricula=Utilidades.pideFrase("cual es la matricula?:");
       this.numeroPlazas=Utilidades.pideEntero("cuantas plazas tiene?: ");
        
    }
  

   //Sobrescribe toString() para que retorne los datos del Vehiculo,
    //incluido su precio total de alquiler por días.
    public String toString(){
        String informacion="Modelo: "+this.getModelo()+ " Matricula: "+this.getMatricula()+" Numero de Plazas: "+this.getNumeroPlazas()
                +" Precio base de alquiler por dia: "+ this.precioBaseAlquilerPorDia;
      
        return informacion ;
    }
    
    
    
  
}
