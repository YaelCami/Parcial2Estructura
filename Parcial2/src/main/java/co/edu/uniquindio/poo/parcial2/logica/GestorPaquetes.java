package co.edu.uniquindio.poo.parcial2.logica;

import co.edu.uniquindio.poo.parcial2.estructuras.Cola;
import co.edu.uniquindio.poo.parcial2.modelo.Paquete;
import co.edu.uniquindio.poo.parcial2.modelo.TipoEntrega;

public class GestorPaquetes {
    private int capacidadRestante;

    public Cola<Paquete> seleccionarPaquetes(Cola<Paquete> pendientes, int capacidad) {
        Cola<Paquete> seleccionados = new Cola<>();
        capacidadRestante = capacidad;

        if (capacidad <= 0) {
            return seleccionados;
        }

        capacidadRestante = procesar(pendientes, seleccionados, TipoEntrega.URGENTE, capacidadRestante, pendientes.getTamanio());
        capacidadRestante = procesar(pendientes, seleccionados, TipoEntrega.NORMAL, capacidadRestante, pendientes.getTamanio());

        return seleccionados;
    }



    public int procesar (Cola<Paquete> pendientes, Cola<Paquete> seleccionados, TipoEntrega tipo, int capacidad, int n) {
        if (n == 0) {
            return capacidad;
        }

        Paquete p = pendientes.desencolar();

        if (p.getTipo() == tipo) {
            if (p.getPeso () <= capacidad) {
                seleccionados.encolar(p);
                capacidad = capacidad - p.getPeso();
                System.out.println(p + " -> Seleccionado");
            } else {
                pendientes.encolar(p);
                System.out.println(p + " -> No cabe, asi que queda PENDIENTE");
            }
        } else {
            pendientes.encolar(p);
        }
        return procesar(pendientes, seleccionados, tipo, capacidad, n - 1);
    }

    public void mostrar(Cola<Paquete> cola) {
        mostrar(cola, cola.getTamanio());
    }

    public void mostrar(Cola<Paquete> cola, int n) {
        if (n == 0) {
            return;
        }
        Paquete p = cola.desencolar();
        System.out.println(p);
        cola.encolar(p);
        mostrar(cola, n-1);
    }

    public int getCapacidadRestante() {
        return capacidadRestante;
    }

    public void probarEjercicio3() {
        Cola<Paquete> pendientes = new Cola<>();
        pendientes.encolar(new Paquete("P1", TipoEntrega.NORMAL, 4));
        pendientes.encolar(new Paquete("P2", TipoEntrega.URGENTE, 7));
        pendientes.encolar(new Paquete("P3", TipoEntrega.NORMAL, 3));
        pendientes.encolar(new Paquete("P4", TipoEntrega.URGENTE, 5));
        pendientes.encolar(new Paquete("P5", TipoEntrega.NORMAL, 6));
        pendientes.encolar(new Paquete("P6", TipoEntrega.URGENTE, 4));
        pendientes.encolar(new Paquete("P7", TipoEntrega.NORMAL, 2));

        System.out.println("=== EJERCICIO 3 ===");
        System.out.println("Cola inicial (frente -> final):");
        mostrar(pendientes);

        System.out.println("\nEvaluacion de paquetes (capacidad 14 kg):");
        Cola<Paquete> seleccionados = seleccionarPaquetes(pendientes, 14);

        System.out.println("\nCola retornada:");
        mostrar(seleccionados);

        System.out.println("\nPendientes despues de la seleccion:");
        mostrar(pendientes);

        System.out.println("\nCapacidad disponible: " + getCapacidadRestante() + " kg");
    }
}
