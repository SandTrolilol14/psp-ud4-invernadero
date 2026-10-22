public class Fase1_Secuencial {
    public static void main(String[] args) {

        System.out.println("Inicio de la Fase 1 (Secuencial)");
        long inicio = System.currentTimeMillis();

        Temperatura temp = new Temperatura();
        Humedad hum = new Humedad();
        Luz luz = new Luz();
        ProgramadorRiego riego = new ProgramadorRiego();

        temp.run();
        hum.run();
        luz.run();
        riego.run();

        System.out.println("Informes:");
        temp.informe();
        hum.informe();
        luz.informe();
        riego.informe();

        long fin = System.currentTimeMillis();

        long tiempoTotal = fin - inicio;
        System.out.println("Tiempo total: " + tiempoTotal + "ms");

    }
}
