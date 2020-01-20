package EjercicioTrenes;

public class VagonCarga implements Vagon {
    private Integer pesoDeCargaMaximo;

    public Integer pesoMaximo(){
        return pesoDeCargaMaximo+160;
    }


    public VagonCarga(Integer pesoDeCargaMaximo){
        this.pesoDeCargaMaximo=pesoDeCargaMaximo;
    }
    public Integer capacidadDePasajeros() {
       return 0;
    }
    public Boolean eresUnVagonLiviano(){
        return this.pesoMaximo()<2500;
    }

}
