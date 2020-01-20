package EjercicioTrenes;

public class Locomotora {
    private Integer pesoDeLocomotora;
    private Integer pesoMaximoQuePuedeArrastrar;
    private Integer velocidadMaxima;


    public Locomotora(Integer pesoDeLocomotora, Integer pesoMaximoQuePuedeArrastrar, Integer velocidadMaxima) {
        this.setPesoDeLocomotora(pesoDeLocomotora);
        this.setPesoMaximoQuePuedeArrastrar(pesoMaximoQuePuedeArrastrar);
        this.setVelocidadMaxima(velocidadMaxima);
    }



    public Boolean eresUnaLocomotoraEficiente(){
      return (this.arrastreUtil()>=getPesoDeLocomotora()*5);
    }

    public Integer arrastreUtil() {
        return this.getPesoMaximoQuePuedeArrastrar() - getPesoDeLocomotora();

    }

   /* public void agregarAFormaciondeLocomotora(Vagon unVagon) {
        if (this.arrastreUtil() <= unVagon.pesoMaximo())
            this.tren.add(unVagon);
    }*/


    public Integer getPesoDeLocomotora() {
        return pesoDeLocomotora;
    }

    public Integer getPesoMaximoQuePuedeArrastrar() {
        return pesoMaximoQuePuedeArrastrar;
    }

    public Integer getVelocidadMaxima() {
        return velocidadMaxima;
    }


    public void setPesoDeLocomotora(Integer pesoDeLocomotora) {
        this.pesoDeLocomotora = pesoDeLocomotora;
    }

    public void setPesoMaximoQuePuedeArrastrar(Integer pesoMaximoQuePuedeArrastrar) {
        this.pesoMaximoQuePuedeArrastrar = pesoMaximoQuePuedeArrastrar;
    }

    public void setVelocidadMaxima(Integer velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
}
