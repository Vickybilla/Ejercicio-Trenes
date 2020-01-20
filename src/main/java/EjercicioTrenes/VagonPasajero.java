package EjercicioTrenes;

public class VagonPasajero implements Vagon {
        private Integer largo;
        private Double anchoUtil;



        public VagonPasajero (Double ancho,Integer largo){
            this.largo=largo;
            this.anchoUtil= ancho;
        }

        public Integer capacidadDePasajeros2() {
            if (getAnchoUtil() > 2.5){
                return (getLargo()*8);
            }
            else return getLargo()*10;
        }

    public Integer capacidadDePasajeros() {
        // Usamos el operador ternario para calcular la cantidad de pasjeros
        return (anchoUtil <= 2.5)
                ? largo.intValue() * 8
                : largo.intValue() * 10;
        // Cuando aplicamos inValue() a un Double extraemos la parte entera del número decimal
        // Esto nos sirve para efectivamente devolver un Integer que es el tipo que corresponde
        // (NUNCA podríamos tener 3.8 o 9.5 pasajeros)
    }

    public Integer pesoMaximo(){
        return this.capacidadDePasajeros()*80;
    }

    public Boolean eresUnVagonLiviano(){
        return this.pesoMaximo()<2500;
    }




//el metodo de abajo lo hice al pepe por leer mal el enunciado, pero sirve para futuros casos
    //en los que tenga que pasar de Double a Int
   // public Integer pesoMaximo(VagonPasajero unVagon){
    //  return Double.valueOf(pesoMaximoEnDouble(unVagon)).intValue();
   // }

    public Integer getLargo() {
        return largo;
    }

    public Double getAnchoUtil() {
        return anchoUtil;
    }
}
