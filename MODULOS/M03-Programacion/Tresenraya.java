import java.util.Scanner;


public class Tresenraya {
    public static void main(String[] args) {
        char[][] tablero = new char[3][3]; // Creamos la matriz que representará el tablero
        Scanner scanner = new Scanner(System.in);
        char jugadorActual = 'X'; // El jugador que inicia el juego es X
        boolean juegoTerminado = false; // Variable para controlar si el juego ha terminado
        boolean mostrarBienvenida = true;
        //mostramos la bienvenida
        if (mostrarBienvenida) {
            System.out.println("¡Bienvenido al juego de Tres en Raya!");
            System.out.println("Instrucciones: Cada jugador elige las X o las O, y en su turno debe poner una, intentando conseguir 3 seguidas en una línea vertical, horizontal o diagonal. Una vez se llenan todos los espacios se termina la partida, finalizando en tablas si ninguno consigue enlazar tres de sus fichas seguidas.");

            mostrarBienvenida = false;
        }
        
         
        // Inicializamos el tablero 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }

        // Comenzamos el juego
        while (!juegoTerminado) {
            // Mostramos el tablero actual
            mostrarTablero(tablero);

            // Pedimos al jugador actual que seleccione una posición
            System.out.print("Jugador " + jugadorActual + ", seleccione una posición (fila,columna): ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();

            // Verificamos que la posición seleccionada sea válida
            if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
                System.out.println("Posición inválida. Seleccione una posición dentro del rango (0-2).");
                continue; // Continuamos con el siguiente ciclo del bucle while
            }

            // Verificamos que la posición seleccionada esté vacía
            if (tablero[fila][columna] != ' ') {
                System.out.println("Posición ocupada. Seleccione otra posición.");
                continue; // Continuamos con el siguiente ciclo del bucle while
            }

            // Colocamos la ficha del jugador actual en la posición seleccionada
            tablero[fila][columna] = jugadorActual;

            // Verificamos si el jugador actual ha ganado
            if (haGanadoporlinea(jugadorActual, tablero)) {
                mostrarTablero(tablero);
                System.out.println("¡Jugador " + jugadorActual + " ha ganado por linia!");
                juegoTerminado = true;
                
                
            } else {
                // Verificamos si el juego ha terminado en empate
                if (esEmpate(tablero)) {
                    mostrarTablero(tablero);
                    System.out.println("¡Empate!");
                    juegoTerminado = true;
                } else{
                    // Verificamos si el juego  ha ganado por columna
                    if (haGanadoporcolumna(jugadorActual, tablero)) {
                        mostrarTablero(tablero);
                        System.out.println("¡Jugador " + jugadorActual + " ha ganado por columna!");
                        juegoTerminado = true;
                    }
                    else{
                        // Verificamos si el juego  ha ganado por diagonal
                        if (haGanadopordiagonal(jugadorActual, tablero)) {
                            mostrarTablero(tablero);
                            System.out.println("¡Jugador " + jugadorActual + " ha ganado por diagonal!");
                            juegoTerminado = true;
                        }
                        else{
                            // Verificamos s el juego ha ganado por linia 
                            if (haGanadoporlinea(jugadorActual, tablero)) {
                                mostrarTablero(tablero);
                                System.out.println("¡Jugador " + jugadorActual + " ha ganado por linia!");
                                juegoTerminado = true;
                            }
                
                
                          else {
                    // Cambiamos al siguiente jugador
                    jugadorActual = jugadorActual == 'X' ? 'O' : 'X';
                }
            }
        }
    }}
}
    }
// En este caso recorre las linias = (i) y si el jugador coincide en dichas posiciones ha ganado por linia 
    private static boolean haGanadoporlinea(char jugadorActual, char[][] tablero) {
        for (int i = 0; i < 3;) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {
                return false;
            }
        return false;
        }
        return false;
    }

        // Verificar líneas verticales
        // este metodo recorre las columnas 0, 1 y 2 y si el jugador coincide gana por columna 
        public static boolean haGanadoporcolumna(char jugador, char[][] tablero) {  
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == jugador && tablero[1][j] == jugador && tablero[2][j] == jugador) {
                return true;
            }
        }
        return false;
    }
    
        // Verificar diagonal de derecha a izquierda
        //Este metodo menciona que si el jugador coincide en las posiciones 00,11,22 sera ganador por diagonal
        public static boolean haGanadopordiagonal(char jugador, char[][] tablero) {  

        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
            return true;
        }
    
        // Verificar diagonal de izquierda a derecha
        // y este lo mismo pero coincidiendo las posiciones de la otra diagonal 
        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
            return true;
        }

        
        
    
        return false; // Si no se cumple ninguna de las condiciones anteriores, el jugador no ha ganado
    }






    

    // Función para mostrar el tablero actual
    private static boolean esEmpate(char[][] tablero) {
        return false;
    }

    public static void mostrarTablero(char[][] tablero) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

   
   
        
    

}

