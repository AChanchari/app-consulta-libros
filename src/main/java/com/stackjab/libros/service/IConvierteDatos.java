package com.stackjab.libros.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);

}
