package Tarea.AppStore.Metodos.App;

import java.awt.*;

public class Juegos
{
    public enum Categoria
    {
        ROMPECABEZAS,DEPORTE,ACCION
    }

    private String nombre;
    private Categoria categoria;
    private int precio;
    private int tamanio;
    private int cantidadLicencias;
    private int cantidadVendidas;
    private String rutaImagen;
    private int unidades;
    public Juegos(String pNombre, Categoria pCategoria, int pPrecio, int pTamanio, int pCantidadLicencias, String pRutaImagen )
    {
        nombre = pNombre;
        categoria = pCategoria;
        precio = pPrecio;
        tamanio = pTamanio;
        cantidadLicencias = pCantidadLicencias;
        rutaImagen = pRutaImagen;
        cantidadVendidas = 0;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public void sumarUnidades(int unidadesAdicionales) {
        unidades += unidadesAdicionales;
    }

    public String darNombre( )
    {
        return nombre;
    }
    public Categoria darCategoria( )
    {
        return categoria;
    }
    public int darPrecio( )
    {
        return precio;
    }
    public int darTamanio( )
    {
        return tamanio;
    }
    public int darCantidadLicencias( )
    {
        return cantidadLicencias;
    }
    public int darCantidadVendidas( )
    {
        return cantidadVendidas;
    }
    public String darRutaImagen( )
    {
        return rutaImagen;
    }
    public void comprarLicencias( int pCantidad )
    {
        cantidadLicencias += pCantidad;
    }
    public boolean venderLicencias( int pCantidad ){
        boolean respuesta = false;
        if( cantidadLicencias >= pCantidad )
        {
            cantidadLicencias -= pCantidad;
            cantidadVendidas += pCantidad;
            respuesta = true;
        }
        return respuesta;
    }
}