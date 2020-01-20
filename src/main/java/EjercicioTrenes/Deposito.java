package EjercicioTrenes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Deposito {
    private List<Tren> trenes = new ArrayList<>();
    private List<Locomotora> locomotoras = new ArrayList<>();



    public List <Vagon> vagonesMasPesadosDelDeposito(){
        return getTrenes().stream()
                .map(tren ->tren.vagonMasPesadosDeLaFormacion())
                .collect(Collectors.toList());
    }

    public Boolean necesitasUnConductorExperimentado(){
        return getTrenes().stream()
                .anyMatch(tren -> tren.eresUnaFormacionCompleja());
    }

    public Locomotora locomotoraQueMuevaElTren(Tren unTren){
        return getLocomotoras().stream()
                .filter(locomotora -> locomotora.arrastreUtil()>= unTren.cuantosKilosTeFaltanParaMoverte())
                .findFirst()
                .orElseThrow(() -> new LocomotorasVaciaException("El ArrayList de Locomotoras esta vacio." +
                        "Agregar una LocomotoraTest"));
    }

    public void agregarLocomotora(Tren unTren) {
        // EXTRA: Podríamos chequear que la formación que se pasa como parámetro
        // pertenezca a este deposito.
        if (!trenes.contains(unTren)) {
            throw new ParametrosIncorrectosException(
                    "Error agregando locomotora a formación: " +
                            "la formación no pertenece al depósito.");
        }

        if (!unTren.puedeLaFormacionMoverse()) {
            Integer empujeFaltante = unTren.cuantosKilosTeFaltanParaMoverte();
            locomotoras.stream()
                    .filter(locomotora -> locomotora.arrastreUtil() >= empujeFaltante)
                    .findFirst()
                    .ifPresent(locomotora -> {
                       unTren.agregarLocomotora(locomotora);
                        locomotoras.remove(locomotora);
                    });
            // ifPresent ejecuta la acción que le pasemos por paréntesis
            // SOLO si el stream u optional al que le mandamos este mensaje
            // (en este caso el resultado de findFirst) NO es vacío.
            // En otras palabras, formacion.agregarLocomotora(locomotora)
            // se va a ejecutar SI y SOLO SI existe al menos una locomotora que cumpla
            // las condiciones para ser agregada a esta formación particular
        }
    }


    public void agregarLocomotoraParaQueFuncioneTren (Tren unTren){
        Locomotora locomotoraParaAgregar=locomotoraQueMuevaElTren(unTren);
        getLocomotoras().remove(locomotoraParaAgregar);
        unTren.agregarLocomotora(locomotoraParaAgregar);

    }


    public List<Tren> getTrenes() {
        return trenes;
    }

    public void setTrenes(List<Tren> trenes) {
        this.trenes = trenes;
    }

    public List<Locomotora> getLocomotoras() {
        return locomotoras;
    }

    public void setLocomotoras(List<Locomotora> locomotoras) {
        this.locomotoras = locomotoras;
    }
}