package EjercicioTrenes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tren {
    private List<Vagon> vagones = new ArrayList<>();
    private List<Locomotora> locomotoras = new ArrayList<>();

  public void agregarLocomotora( Locomotora unaLoco){
      this.getLocomotoras().add(unaLoco);

    }


    public void agregarVagon(Vagon unVagon) {
      this.getVagones().add(unVagon);
    }

    public Integer cuantosVagonesHayEnTuFormacion() {
        return this.getVagones().size();
    }
    public Integer cuantosPasajerosPuedeTransportarTuFormacion() {
        return getVagones().stream()
                .mapToInt(unaVagon -> unaVagon.capacidadDePasajeros())
                .sum();
    }
    public Integer vagonesLivianosTieneTuFormacion() {
        return (int) getVagones().stream()
                .filter(tren->tren.eresUnVagonLiviano())
                .count();
    }


    /*public void agregarATren(Vagon unVagon) {
        if (this.arrastreUtil() <= unVagon.pesoMaximo())
            this.vagones.add(unVagon);
    }*/

    public  Integer velocidadMaximaDeFormacion(){
        return getLocomotoras().stream()
                .mapToInt(locomotora -> locomotora.getVelocidadMaxima())
                .min()
                .getAsInt();

    }

    public Boolean esEficientetuFormacion(){
        return getLocomotoras().stream()
                .allMatch(locomotora -> locomotora.eresUnaLocomotoraEficiente());
    }


    public Integer arrastreUtilDeLocomotorasDeArray(){
        return getLocomotoras().stream()
                .mapToInt(locomotora->locomotora.arrastreUtil())
                .sum();
    }

    public Integer  pesoTotalDeVagonesDelArray (){
        return getVagones().stream()
                .mapToInt(vagon->vagon.pesoMaximo())
                .sum();
    }
    public Boolean puedeLaFormacionMoverse (){
        return arrastreUtilDeLocomotorasDeArray()>=pesoTotalDeVagonesDelArray();
    }

    public Integer cuantosKilosTeFaltanParaMoverte(){
        if (puedeLaFormacionMoverse()==true)
                return 0;
        else return pesoTotalDeVagonesDelArray()-arrastreUtilDeLocomotorasDeArray();
    }

    public Vagon vagonMasPesadosDeLaFormacion(){
        return  getVagones().stream()
                .max(Comparator.comparing(vagon -> vagon.pesoMaximo()))
                .get();
    }

    public Integer tamanioDeFormacion (){
        return getVagones().size()+ getLocomotoras().size();
    }

   public Integer  pesoTotalDeLocomotorasdelArray () {
       return getLocomotoras().stream()
               .mapToInt(loco -> loco.getPesoDeLocomotora())
               .sum();
   }

   public Integer pesoTotalDelTren(){
        return pesoTotalDeVagonesDelArray()+pesoTotalDeLocomotorasdelArray();
   }

    public Boolean eresUnaFormacionCompleja() {
        return this.tamanioDeFormacion() > 20 || this.pesoTotalDelTren() > 10000;

    }


    public List<Vagon> getVagones() {
        return vagones;
    }

    public void setVagones(List<Vagon> vagones) {
        this.vagones = vagones;
    }

    public List<Locomotora> getLocomotoras() {
        return locomotoras;
    }

    public void setLocomotoras(List<Locomotora> locomotoras) {
        this.locomotoras = locomotoras;
    }
}