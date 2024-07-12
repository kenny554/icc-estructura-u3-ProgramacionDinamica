package Ejercicios.contorllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Un jugador está en la esquina superior izquierda (0,0) de un tablero m x n. En el tablero hay celdas
 * transitables (true) y no transitables (false). Encuentra un camino válido para ir a la esquina
 * inferior izquierda con el jugador, sabiendo que solo se puede mover hacia abajo y hacia la derecha.
 *
 * Ejemplo 1:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,false,false,true]
 *      [true,true,false,true]
 *      [true,true,false,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (0,2), (0,3), (1,3), (2,3), (3,3)]
 *
 * Ejemplo 2:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,true,true,true]
 *      [true,true,false,false]
 *      [true,true,true,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (1,1), (2,1), (3,1), (3,2), (3,3)]
 *
 */

/*
 * Un jugador está en la esquina superior izquierda (0,0) de un tablero m x n. En el tablero hay celdas
 * transitables (true) y no transitables (false). Encuentra un camino válido para ir a la esquina
 * inferior izquierda con el jugador, sabiendo que solo se puede mover hacia abajo y hacia la derecha.
 *
 * Ejemplo 1:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,false,false,true]
 *      [true,true,false,true]
 *      [true,true,false,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (0,2), (0,3), (1,3), (2,3), (3,3)]
 *
 * Ejemplo 2:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,true,true,true]
 *      [true,true,false,false]
 *      [true,true,true,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (1,1), (2,1), (3,1), (3,2), (3,3)]
 *
 */

public class Laberinto {
    // Método principal para obtener el camino en el laberinto
    public List<Celda> getPath(boolean[][] grid) {
        List<Celda> path = new ArrayList<>(); // Lista para almacenar el camino encontrado
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            // Si la cuadrícula es inválida, retornamos una lista vacía
            return new ArrayList<>();
        }

        // Mapa para almacenar si ya visité una celda y su resultado
        Map<Celda, Boolean> cache = new HashMap<>();

        // Llamada al método recursivo para encontrar el camino desde la posición (0, 0)
        if (getPath(grid, 0, 0, path, cache)) {
            return path; // Si se encontró un camino válido, retornamos el camino
        } else {
            return new ArrayList<>(); // Si no se encontró camino, retornamos una lista vacía
        }
    }

    // Método privado recursivo para encontrar el camino en el laberinto
    private boolean getPath(boolean[][] grid, int i, int j, List<Celda> path, Map<Celda, Boolean> cache) {
        // Verificar límites de la cuadrícula y si la celda es transitable
        if (i >= grid.length || j >= grid[0].length || !grid[i][j]) {
            return false; // Si la celda está fuera de los límites o no es transitable, retornamos falso
        }

        Celda punto = new Celda(i, j); // Crear objeto Celda para la posición actual
        if (cache.containsKey(punto)) {
            return cache.get(punto); // Si ya hemos calculado el resultado para esta celda, retornamos el resultado
                                     // almacenado
        }

        boolean isAtEnd = (i == grid.length - 1 && j == grid[0].length - 1); // Verificar si hemos llegado al final del
                                                                             // laberinto
        boolean success = false; // Variable para almacenar si se encontró un camino exitoso

        // Explorar hacia abajo y hacia la derecha recursivamente
        if (isAtEnd || getPath(grid, i + 1, j, path, cache) || getPath(grid, i, j + 1, path, cache)) {
            path.add(punto); // Si se encontró un camino válido hacia el final o desde las siguientes celdas,
                             // añadimos la celda actual al camino
            success = true; // Marcamos que se encontró un camino exitoso
        }

        cache.put(punto, success); // Almacenamos el resultado de la celda actual en el cache
        return success; // Retornamos si se encontró un camino exitoso desde esta celda
    }

    // Clase estática para representar una celda en el laberinto
    static class Celda {
        int x;
        int y;

        // Constructor de la clase Celda
        Celda(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Sobrescribimos el método toString para imprimir las coordenadas de la celda
        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}
