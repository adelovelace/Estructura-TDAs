package ec.edu.espol.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PlataformaJugadores {

    public static LinkedList<Jugador> listJugadores = new LinkedList<>();
    public static ArrayList<Jugador> arrayListJugadores = new ArrayList<>();


    public static void main(String[] args) throws Exception {


        try {
            String filePath = "/Users/andrea/Documents/Espol/1T-2022/Estructura/Labs/LabListas/List/src/main/java/ec/edu/espol/util/jugadores.csv";


            String splitBy = ",";
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            br.readLine();
            String line = "";
            while ((line = br.readLine()) != null)
            //returns a Boolean value
            {
                String[] player = line.split(splitBy);

                Jugador jugador = new Jugador(player[0], player[1], player[2], Double.parseDouble(player[3].replace(" ", "")), Double.parseDouble(player[4].replace(" ", "")), Double.parseDouble(player[5].replace(" ", "")));


                arrayListJugadores.addLast(jugador);
                listJugadores.addLast(jugador);

                System.out.println("Name=" + player[0] + " Team" + player[1] + " Position" + player[2] + " heigh" + player[3] + " weight" + player[4] + " age" + player[5]);
            }

            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < listJugadores.size(); i++) {
            if (i % 2 == 0) {
                listJugadores.remove(i);
            }
        }


//        for (int i = 0; i < listJugadores.size(); i++) {
//            System.out.println("Nombre: " + listJugadores.get(i).getName() + "index:" + i);
//        }

        System.out.println("Aqui");
        for (int i = 0; i < arrayListJugadores.size(); i++) {
            if (i % 2 == 0) {
                arrayListJugadores.remove(i);
            }
        }


//        for (int i = 0; i < arrayListJugadores.size(); i++) {
//            System.out.println("Nombre: " + arrayListJugadores.get(i).getName() + "index:" + i);
//        }


    }

}

