package EjercicioTrenes;

public class TrenesMain {
    public static void main(String[] args) {
        Locomotora locomotora1= new Locomotora(1000,5000,80);
        Locomotora locomotora2=new Locomotora(2000,7000,90);
        Locomotora locomotora3=new Locomotora(2500,10000,120);
        Locomotora locomotora4=new Locomotora(1800,8000,160);

        VagonPasajero vagonDePasajero1=new VagonPasajero(2.5,5);
        VagonPasajero vagonDePasajero2=new VagonPasajero(3.0,6);
        VagonPasajero vagonDePasajero3=new VagonPasajero(2.5,7);
        VagonPasajero vagonDePasajero4=new VagonPasajero(2.5,8);
        VagonPasajero vagonDePasajero5=new VagonPasajero(3.5,9);
        VagonPasajero vagonDePasajero6=new VagonPasajero(4.5,10);
        VagonPasajero vagonDePasajero7=new VagonPasajero(2.5,4);
        VagonPasajero vagonDePasajero8=new VagonPasajero(2.5,5);
        VagonPasajero vagonDePasajero9=new VagonPasajero(2.5,5);

        VagonCarga vagonDeCarga1=new VagonCarga(300);
        VagonCarga vagonDeCarga2=new VagonCarga(600);
        VagonCarga vagonDeCarga3=new VagonCarga(1000);
        VagonCarga vagonDeCarga4=new VagonCarga(700);
        VagonCarga vagonDeCarga5=new VagonCarga(800);
        VagonCarga vagonDeCarga6=new VagonCarga(900);
        VagonCarga vagonDeCarga7=new VagonCarga(3000);
        VagonCarga vagonDeCarga8=new VagonCarga(1200);
        VagonCarga vagonDeCarga9=new VagonCarga(1300);
        VagonCarga vagonDeCarga10=new VagonCarga(850);
        VagonCarga vagonDeCarga11=new VagonCarga(950);
        VagonCarga vagonDeCarga12=new VagonCarga(400);

        Tren tren1=new Tren ();
        tren1.agregarLocomotora(locomotora1);
        tren1.agregarLocomotora(locomotora2);
        tren1.agregarVagon(vagonDeCarga1);
        tren1.agregarVagon(vagonDeCarga3);
        tren1.agregarVagon(vagonDePasajero1);
        tren1.agregarVagon(vagonDePasajero4);


        System.out.println(vagonDePasajero2.pesoMaximo());
        System.out.println(tren1.puedeLaFormacionMoverse());
        System.out.println(tren1.cuantosKilosTeFaltanParaMoverte());







    }
}
