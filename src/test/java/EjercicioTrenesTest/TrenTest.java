package EjercicioTrenesTest;


import EjercicioTrenes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrenTest {

    private Tren tren;
    private List<Locomotora> locomotoras;
    private List<Vagon> vagones;
    private Locomotora l1;
    private Locomotora l2;
    private Locomotora l3;
    private VagonPasajero v1;
    private VagonPasajero v2;
    private VagonCarga v3;

    @BeforeEach
    void setUp() {
        tren = new Tren();
        locomotoras = new ArrayList<>();
        vagones = new ArrayList<>();

        l1 = mock(Locomotora.class);
        l2 = mock(Locomotora.class);
        l3 = mock(Locomotora.class);
        v1 = mock(VagonPasajero.class);
        v2 = mock(VagonPasajero.class);
        v3 = mock(VagonCarga.class);
        locomotoras.add(l1);
        locomotoras.add(l2);
        locomotoras.add(l3);
        vagones.add(v1);
        vagones.add(v2);
        vagones.add(v3);

        tren.setLocomotoras(locomotoras);
        tren.setVagones(vagones);
    }

    @Test
    void cuantosPasajerosPuedeTransportarTuFormacion() {
        when(v1.capacidadDePasajeros()).thenReturn(200);
        when(v2.capacidadDePasajeros()).thenReturn(300);
        when(v3.capacidadDePasajeros()).thenReturn(0);
        assertEquals(tren.cuantosPasajerosPuedeTransportarTuFormacion(), 500);
    }

    @Test
    void cantidadVagonesLivianos() {
        //Si hay algún vagón liviano se devuelve la cantidad:
        when(v1.eresUnVagonLiviano()).thenReturn(true);
        when(v2.eresUnVagonLiviano()).thenReturn(false);
        when(v3.eresUnVagonLiviano()).thenReturn(false);
        assertEquals(tren.vagonesLivianosTieneTuFormacion(), 1);

        //Si no hay ningún vagón liviano:
        when(v1.eresUnVagonLiviano()).thenReturn(false);
        when(v2.eresUnVagonLiviano()).thenReturn(false);
        when(v3.eresUnVagonLiviano()).thenReturn(false);
        assertEquals(tren.vagonesLivianosTieneTuFormacion(), 0);
    }

    @Test
    void velocidadMaxima() {
        when(l1.getVelocidadMaxima()).thenReturn(80);
        when(l2.getVelocidadMaxima()).thenReturn(60);
        when(l3.getVelocidadMaxima()).thenReturn(100);
        assertEquals(tren.velocidadMaximaDeFormacion(), 60);
    }

    @Test
    void esEficiente() {
        // Todas las locomotoras son eficientes:
        when(l1.eresUnaLocomotoraEficiente()).thenReturn(true);
        when(l2.eresUnaLocomotoraEficiente()).thenReturn(true);
        when(l3.eresUnaLocomotoraEficiente()).thenReturn(true);
        assertTrue(tren.esEficientetuFormacion());

        // Al menos una locomotora NO es eficiente:
        when(l1.eresUnaLocomotoraEficiente()).thenReturn(true);
        when(l2.eresUnaLocomotoraEficiente()).thenReturn(false);
        assertFalse(tren.esEficientetuFormacion());
    }

    @Test
    void puedeMoverse() {
        // Arrastre util total mayor al peso total de los vagones
        when(v1.pesoMaximo()).thenReturn(1000);
        when(v2.pesoMaximo()).thenReturn(1000);
        when(v3.pesoMaximo()).thenReturn(900);
        when(l1.arrastreUtil()).thenReturn(5000);
        when(l2.arrastreUtil()).thenReturn(4000);
        when(l3.arrastreUtil()).thenReturn(4000);
        assertTrue(tren.puedeLaFormacionMoverse());

        // Arrastre util total menor al peso total de los vagones
        when(v1.pesoMaximo()).thenReturn(1000);
        when(v2.pesoMaximo()).thenReturn(1000);
        when(v3.pesoMaximo()).thenReturn(900);
        when(l1.arrastreUtil()).thenReturn(500);
        when(l2.arrastreUtil()).thenReturn(400);
        when(l3.arrastreUtil()).thenReturn(400);
        assertFalse(tren.puedeLaFormacionMoverse());

        // Arrastre util total igual al peso total de los vagones
        when(v1.pesoMaximo()).thenReturn(1000);
        when(v2.pesoMaximo()).thenReturn(1000);
        when(v3.pesoMaximo()).thenReturn(900);
        when(l1.arrastreUtil()).thenReturn(1000);
        when(l2.arrastreUtil()).thenReturn(1000);
        when(l3.arrastreUtil()).thenReturn(900);
        assertTrue(tren.puedeLaFormacionMoverse());
    }

    @Test
    void cuantosKilosTeFaltanParaMoverte() {
        // Arrastre util total mayor al peso total de los vagones
        when(v1.pesoMaximo()).thenReturn(1000);
        when(v2.pesoMaximo()).thenReturn(1000);
        when(v3.pesoMaximo()).thenReturn(900);
        when(l1.arrastreUtil()).thenReturn(5000);
        when(l2.arrastreUtil()).thenReturn(4000);
        when(l3.arrastreUtil()).thenReturn(4000);
        assertEquals(tren.cuantosKilosTeFaltanParaMoverte(), 0);

        // Arrastre util total menor al peso total de los vagones
        when(v1.pesoMaximo()).thenReturn(1000);
        when(v2.pesoMaximo()).thenReturn(1000);
        when(v3.pesoMaximo()).thenReturn(900);
        when(l1.arrastreUtil()).thenReturn(500);
        when(l2.arrastreUtil()).thenReturn(400);
        when(l3.arrastreUtil()).thenReturn(400);
        assertEquals(tren.cuantosKilosTeFaltanParaMoverte(), 2900 - 1300);
    }

    @Test
    void vagonMasPesadoDeLaFormacion() {
        when(v1.pesoMaximo()).thenReturn(1000);
        when(v2.pesoMaximo()).thenReturn(1500);
        when(v3.pesoMaximo()).thenReturn(900);
        assertEquals(tren.vagonMasPesadosDeLaFormacion(), v2);
    }

    @Test
    void esCompleja() {
        // Más de 20 unidades:
        for(int i=0; i<20; i++) {
            tren.agregarLocomotora(mock(Locomotora.class));
        } //Agregamos 20 locomotoras para tener más de 20 unidades
        assertTrue(tren.eresUnaFormacionCompleja());

        // Peso total mayor a 10000:
        // (Seteamos la lista de locomotoras como estaba antes
        // para volver a tener 6 unidades en total)
        setUp();
        when(v1.pesoMaximo()).thenReturn(1000);
        when(v2.pesoMaximo()).thenReturn(1500);
        when(v3.pesoMaximo()).thenReturn(1500);
        when(l1.getPesoDeLocomotora()).thenReturn(2000);
        when(l2.getPesoDeLocomotora()).thenReturn(2000);
        when(l3.getPesoDeLocomotora()).thenReturn(3000);
        assertTrue(tren.eresUnaFormacionCompleja());

        // Ninguno de los dos anteriores:
        when(v1.pesoMaximo()).thenReturn(500);
        when(v2.pesoMaximo()).thenReturn(500);
        when(v3.pesoMaximo()).thenReturn(500);
        when(l1.getPesoDeLocomotora()).thenReturn(1000);
        when(l2.getPesoDeLocomotora()).thenReturn(2000);
        when(l3.getPesoDeLocomotora()).thenReturn(1000);
        assertFalse(tren.eresUnaFormacionCompleja());
    }
}
