/**
 * Algoritmo di Dijkstra
 * 
 * @author Giorgio Justin Fasullo e Mezzanzanica Nicolo'
 * Classe: 4f
 */

/* --- Package ---*/
import java.util.*;

public class Graph {
    public static void dijkstra(Nodo nodoIniziale) {
        nodoIniziale.setWeight(0);
        Set<Nodo> nodiVisitati = new HashSet<>();
        PriorityQueue<Nodo> nodiDaVisitare = new PriorityQueue<>((a, b) -> a.getWeight() - b.getWeight());
        nodiDaVisitare.offer(nodoIniziale);
	
        // ciclo che si ripete nel caso rimangano ancora nodi da visitare
        while (!nodiDaVisitare.isEmpty()) {
            Nodo corrente = nodiDaVisitare.poll();
            nodiVisitati.add(corrente);
	    // controlla tutti i link di ciascun nodo aggiornando eventualmente il peso per arrivare ad uno dei nodi collegati partendo dal nodo corrente
            for (Map.Entry<Nodo, Integer> entry : corrente.getLinks().entrySet()) {
                Nodo vicino = entry.getKey();
                int distanza = corrente.weightTo(vicino);
                if (!nodiVisitati.contains(vicino) && distanza < vicino.getWeight()) {
                    vicino.setWeight(distanza);
                    vicino.setPrev(corrente);
                    nodiDaVisitare.offer(vicino);
                }
            }
        }
    }
}