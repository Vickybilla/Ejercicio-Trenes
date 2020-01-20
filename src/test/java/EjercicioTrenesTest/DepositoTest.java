package EjercicioTrenesTest;


import EjercicioTrenes.Deposito;
import EjercicioTrenes.Locomotora;
import EjercicioTrenes.ParametrosIncorrectosException;
import EjercicioTrenes.Tren;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DepositoTest {

    private Deposito deposito;
    private List<Tren> trenes;
    private List<Locomotora> locomotoras;
    private Tren f1;
    private Tren f2;
    private Tren f3;
    private Locomotora l1;
    private Locomotora l2;
    private Locomotora l3;

    @BeforeEach
    void setUp() {
        deposito = new Deposito();
        trenes = new ArrayList<>();
        locomotoras = new ArrayList<>();
        f1 = mock(Tren.class);
        f2 = mock(Tren.class);
        f3 = mock(Tren.class);
        l1 = mock(Locomotora.class);
        l2 = mock(Locomotora.class);
        l3 = mock(Locomotora.class);

        trenes.add(f1);
        trenes.add(f2);
        trenes.add(f3);
        locomotoras.add(l1);
        locomotoras.add(l2);
        locomotoras.add(l3);
        deposito.setTrenes(trenes);
        deposito.setLocomotoras(locomotoras);
    }

    @Test
    void necesitaConductorExperimentado() {
        // Alguna de sus trenes es compleja:
        when(f1.eresUnaFormacionCompleja()).thenReturn(true);
        when(f2.eresUnaFormacionCompleja()).thenReturn(true);
        when(f3.eresUnaFormacionCompleja()).thenReturn(false);
        assertTrue(deposito.necesitasUnConductorExperimentado());

        // Nignuna de sus trenes es compleja:
        when(f1.eresUnaFormacionCompleja()).thenReturn(false);
        when(f2.eresUnaFormacionCompleja()).thenReturn(false);
        when(f3.eresUnaFormacionCompleja()).thenReturn(false);
        assertFalse(deposito.necesitasUnConductorExperimentado());
    }

    @Test
    void agregarLocomotora() {
        // Enviamos por parámetro una formación que no está en el depósito:
       Tren formacionFueraDeDeposito = mock(Tren.class);
        assertThrows(ParametrosIncorrectosException.class,
                () -> deposito.agregarLocomotora(formacionFueraDeDeposito));

        // Hay locomotora libre para agregar que cumple con las condiciones:
        when(f1.puedeLaFormacionMoverse()).thenReturn(false);
        when(f1.cuantosKilosTeFaltanParaMoverte()).thenReturn(1000);
        when(l1.arrastreUtil()).thenReturn(1500);
        deposito.agregarLocomotora(f1); // Llamamos normalmente al método que queremos probar
        verify(f1).agregarLocomotora(eq(l1)); //Checkeamos que se llame al método que queremos que llegue

        // No hay locomotora libre para agregar:
        setUp(); // IMPORTANTE!! Hay que volver a settear
        when(f1.puedeLaFormacionMoverse()).thenReturn(false);
        when(f1.cuantosKilosTeFaltanParaMoverte()).thenReturn(1500);
        when(l1.arrastreUtil()).thenReturn(1000);
        when(l2.arrastreUtil()).thenReturn(900);
        when(l3.arrastreUtil()).thenReturn(500);
        deposito.agregarLocomotora(f1); // Llamamos normalmente al método que queremos probar
        verify(f1, never()).agregarLocomotora(any(Locomotora.class));
        // Con never() indicamos que nunca tiene que llegar a ese método

        // La locomotora puede moverse:
        setUp(); // IMPORTANTE!! Hay que volver a settear
        when(f1.puedeLaFormacionMoverse()).thenReturn(true);
        deposito.agregarLocomotora(f1);
        verify(f1, never()).agregarLocomotora(any(Locomotora.class));
    }
}

