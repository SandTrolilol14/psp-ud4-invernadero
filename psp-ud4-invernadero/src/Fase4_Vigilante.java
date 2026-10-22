public class Fase4_Vigilante {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Inicio de la Fase 4 (Vigilante)");

        Temperatura temp = new Temperatura();
        Humedad hum = new Humedad();
        Luz luz = new Luz();
        ProgramadorRiego riego = new ProgramadorRiego();

        Thread hiloTemp = new Thread(temp, "sensor-Temeratura");
        Thread hiloHum = new Thread(hum, "sensor-Hum");
        Thread hiloLuz = new Thread(luz, "sensor-Luz");


        System.out.println("Estado antes de start()");
        System.out.println("Temp: " + hiloTemp.getState() + "\n" +
                           "Hum: " + hiloHum.getState() + "\n" +
                           "Luz: " + hiloLuz.getState() + "\n" +
                           "Riego: " + riego.getState());


        Thread vigilante = new Thread(() -> {
            while(true){

                System.out.printf("[VIGILANTE] Temp: %s | Hum: %s | Luz: %s | Riego: %s\n",
                        hiloTemp.getState(), hiloHum.getState(), hiloLuz.getState(), riego.getState());

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    break;
                }

            }
        });

        vigilante.setDaemon(true);

        vigilante.start();
        hiloTemp.start();
        hiloHum.start();
        hiloLuz.start();
        riego.start();

        hiloTemp.join();
        hiloHum.join();
        hiloLuz.join();
        riego.join();

        System.out.println("Estado tras join():");
        System.out.println("Temp: " + hiloTemp.getState() + "\n" +
                "Hum: " + hiloHum.getState() + "\n" +
                "Luz: " + hiloLuz.getState() + "\n" +
                "Riego: " + riego.getState());


        System.out.println("Main listo, el vigilante muere solo al acabar");

    }
}
