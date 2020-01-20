package EjercicioTrenesTest;

import EjercicioTrenes.VagonPasajero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VagonPasajeroTest {

    private static final Integer LARGO_DEFAULT = 10;
    private VagonPasajero vagonPasajero;

    @Test
    void cantidadPasajerosMaxima() {
        //Cuando el ancho útil es menor a 2.5 metros:
        vagonPasajero = new VagonPasajero(2.0, LARGO_DEFAULT);
        assertEquals(vagonPasajero.capacidadDePasajeros(), 80);

        //Cuando el ancho útil es mayor a 2.5 metros:
        vagonPasajero = new VagonPasajero(3.0,LARGO_DEFAULT);
        assertEquals(vagonPasajero.capacidadDePasajeros(), 100);

        //Cuando el ancho útil es igual a 2.5 metros (caso borde):
        vagonPasajero = new VagonPasajero(2.5,LARGO_DEFAULT);
        assertEquals(vagonPasajero.capacidadDePasajeros(), 80);
    }
}

