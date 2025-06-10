package com.stackjab.libros.principal;

import com.stackjab.libros.model.Datos;
import com.stackjab.libros.model.DatosLibros;
import com.stackjab.libros.service.ConsumoApi;
import com.stackjab.libros.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    public void muestraElMenu(){
        var json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        // TOP 10 DE LOS LIBROS MÁS DESCARGADOS
        System.out.println("TOP 10 DE LOS LIBROS MÁS DESCARGADOS");
        datos.listaDeLibrosResultados().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDeDescarga).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

        // BUSQUEDA DE LIBROS POR NOMBRE
        System.out.println("Ingrese el nombre del libro que deseas buscar");
        var tituloLibro = teclado.nextLine();
        json = consumoApi.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.listaDeLibrosResultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()){
            System.out.println("Libro encontrado ");
            System.out.println(libroBuscado.get());
        }else {
            System.out.println("Libro no encontrado");
        }

        //TRABAJANDO CON ESTADÍSTICAS
        DoubleSummaryStatistics est = datos.listaDeLibrosResultados().stream()
                .filter(d -> d.numeroDeDescarga() >0)
                .collect(Collectors.summarizingDouble(DatosLibros::numeroDeDescarga));
        System.out.println("Cantidad media de descargas: " + est.getAverage());
        System.out.println("Cantidad máxima de descargas: " + est.getMax());
        System.out.println("Cantidad minima de descargas: "+ est.getMin());
        System.out.println("Cantidad de registros evaluados para calcular las estadísticas: " + est.getCount());
    }
}
