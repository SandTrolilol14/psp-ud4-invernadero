public class Fase2_Concurrente {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Inicio de la Fase 2 (Concurrente)");
        long inicio = System.currentTimeMillis();

        Temperatura temp = new Temperatura();
        Humedad hum = new Humedad();
        Luz luz = new Luz();
        ProgramadorRiego riego = new ProgramadorRiego();

        Thread hiloTemp = new Thread(temp, "sensor-Temperatura");
        Thread hiloHum = new Thread(hum, "sensor-Humedad");
        Thread hiloLuz = new Thread(luz, "sensor-Luz");

        hiloTemp.start();
        hiloHum.start();
        hiloLuz.start();
        riego.start();

        // Obliga a main a esperar a que termien los informes
        hiloTemp.join();
        hiloHum.join();
        hiloLuz.join();
        riego.join();

        System.out.println("Informes: ");
        temp.informe();
        hum.informe();
        luz.informe();
        riego.informe();

        long fin = System.currentTimeMillis();

        long tiempoTotal = fin - inicio;
        System.out.println("Tiempo total: " + tiempoTotal + "ms");

    }
}
