import java.io.IOException;

public class Fase3_Experimentos {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Experimento A: ");
        Temperatura tempA = new Temperatura();
        Thread hiloA = new Thread(tempA, "sensor-TempA");
        hiloA.start();

        System.out.println("Informe sin esperar: ");
        tempA.informe();

        hiloA.join();
        System.out.println("Informe tras esperar: ");
        tempA.informe();



        System.out.println("Experimento B: ");
        ProgramadorRiego riegoB = new ProgramadorRiego();
        long inicioB = System.currentTimeMillis();
        riegoB.run();

        long finB = System.currentTimeMillis();
        long totalB = finB - inicioB;

        System.out.println("Tiempo total del Experimento B: " + totalB + "ms");
        System.out.println("Estado de riegoB: " + riegoB.getState());





        System.out.println("Experimento C: ");
        ProgramadorRiego riegoC = new ProgramadorRiego();
        riegoC.start();
        riegoC.join();


        try  {

            System.out.println("Intento de start() sobre hilo terminado ");
            riegoC.start();

        } catch(Exception e) {

            System.out.println("Error: " + e.toString());

        }


    }
}
