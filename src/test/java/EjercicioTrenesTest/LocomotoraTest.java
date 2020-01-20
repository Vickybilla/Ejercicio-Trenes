package EjercicioTrenesTest;


import EjercicioTrenes.Locomotora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocomotoraTest {

    private Locomotora locomotora;

    @Test
    void arrastreUtil() {
        // Cuando el peso de la locomotora es menor al maximo arrastre,
        // se devuelve la diferencia del primero con el segundo
        locomotora = new Locomotora(1000, 12000, 80);
        assertEquals(locomotora.arrastreUtil(), 12000-1000);

        // Si el peso es mayor o igual al arrastre, se devuelve 0
        locomotora.setPesoMaximoQuePuedeArrastrar(500);
        assertEquals(locomotora.arrastreUtil(), 0);
    }

    @Test
    void esEficiente() {
        // Cuando el maximo arrastre supera a 5 veces el peso de la locomotora:
        locomotora = new Locomotora(1000, 6000, 80);
        assertTrue(locomotora.eresUnaLocomotoraEficiente());

        // Cuando el maximo arrastre es menor a 5 veces el peso de la locomotora:
        locomotora.setPesoMaximoQuePuedeArrastrar(4000);
        assertFalse(locomotora.eresUnaLocomotoraEficiente());

        // Cuando el maximo arrastre es igual a 5 veces el peso de la locomotora (caso borde):
        locomotora.setPesoMaximoQuePuedeArrastrar(5000);
        assertTrue(locomotora.eresUnaLocomotoraEficiente());
    }
}
