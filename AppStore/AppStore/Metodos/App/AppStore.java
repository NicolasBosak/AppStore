package Tarea.AppStore.Metodos.App;
import Tarea.AppStore.Metodos.App.Juegos.Categoria;

import java.awt.*;
import javax.swing.*;
import static java.awt.Color.*;

public class AppStore
{
    public final static int CANT_MIN_ROMPECABEZAS = 25;
    public final static int CANT_MIN_DEPORTE = 20;
    public final static int CANT_MIN_ACCION = 15;
    public final static double DESCUENTO_1 = 0.20;
    public final static double DESCUENTO_2 = 0.15;
    private Juegos juegos1;
    private Juegos juegos2;
    private Juegos juegos3;
    private Juegos juegos4;
    public AppStore( ){
        juegos1 = new Juegos( "The Room", Categoria.ROMPECABEZAS, 2, 650, 50, "Room.png" );
        juegos2 = new Juegos( "Human Fall Flat", Categoria.ROMPECABEZAS, 3, 1250, 20, "Human.png" );
        juegos3 = new Juegos( "NBA 2K23", Categoria.DEPORTE, 6, 4890, 80, "NBA.jpg" );
        juegos4 = new Juegos( "Rainbow Six Mobile", Categoria.ACCION, 5, 950, 40, "Rainbow.png" );

        if (juegos3.getCategoria() == Categoria.DEPORTE) {
            OBSEQUIO_DEPORTIVOS obsequioDeportivos = new OBSEQUIO_DEPORTIVOS();
            juegos3.sumarUnidades(obsequioDeportivos.obtenerUnidadesObsequio());
        }
    }
    private class OBSEQUIO_DEPORTIVOS {
        private int unidadesObsequio;

        public OBSEQUIO_DEPORTIVOS() {
            this.unidadesObsequio = 2;
        }

        public int obtenerUnidadesObsequio() {
            return unidadesObsequio;
        }
    }
    public Juegos darJuego1( )
    {
        return juegos1;
    }
    public Juegos darJuego2( )
    {
        return juegos2;
    }
    public Juegos darJuego3( )
    {
        return juegos3;
    }
    public Juegos darJuego4( )
    {
        return juegos4;
    }
    public boolean venderLicenciasJuego( String pNombreJuego, int pCantidad )
    {
        boolean respuesta = false;
        if( buscarJuego( pNombreJuego ) != null )
        {
            respuesta = buscarJuego( pNombreJuego ).venderLicencias( pCantidad );
        }
        return respuesta;
    }
    public void comprarLicenciasJuego( String pNombreJuego, int pCantidad )
    {
        if( buscarJuego( pNombreJuego ) != null )
        {
            buscarJuego( pNombreJuego ).comprarLicencias( pCantidad );
        }
    }
    public String darJuegoMasVendido( )
    {
        String masVendido = "Ninguno";
        int cantidadMasVendida = 0;
        if( juegos1.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juegos1.darNombre( );
            cantidadMasVendida = juegos1.darCantidadVendidas( );
        }
        if( juegos2.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juegos2.darNombre( );
            cantidadMasVendida = juegos2.darCantidadVendidas( );
        }
        if( juegos3.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juegos3.darNombre( );
            cantidadMasVendida = juegos3.darCantidadVendidas( );
        }
        if( juegos4.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juegos4.darNombre( );
            cantidadMasVendida = juegos4.darCantidadVendidas( );
        }

        return masVendido;
    }
    public Juegos buscarJuego(String pNombreJuego )
    {
        Juegos buscado = null;
        if( pNombreJuego.equals( juegos1.darNombre( ) ) )
        {
            buscado = juegos1;
        }
        else if( pNombreJuego.equals( juegos2.darNombre( ) ) )
        {
            buscado = juegos2;
        }
        else if( pNombreJuego.equals( juegos3.darNombre( ) ) )
        {
            buscado = juegos3;
        }
        else if( pNombreJuego.equals( juegos4.darNombre( ) ) )
        {
            buscado = juegos4;
        }

        return buscado;
    }
    public String calcularVentaPorVolumen( int pCantidadLicenciasJuego1, int pCantidadLicenciasJuego2, int pCantidadLicenciasJuego3, int pCantidadLicenciasJuego4 )
    {
        int cantRompecab = 0;
        int cantDeporte = 0;
        int cantAccion = 0;

        switch( juegos1.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego1;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego1;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego1;
                break;
            }
        }
        switch( juegos2.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego2;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego2;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego2;
                break;
            }
        }
        switch( juegos3.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego3;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego3;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego3;
                break;
            }
        }
        switch( juegos4.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego4;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego4;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego4;
                break;
            }
        }

        double totalVenta = ( juegos1.darPrecio( ) * pCantidadLicenciasJuego1 ) + ( juegos2.darPrecio( ) * pCantidadLicenciasJuego2 ) + ( juegos3.darPrecio( ) * pCantidadLicenciasJuego3 ) + ( juegos4.darPrecio( ) * pCantidadLicenciasJuego4 );
        double descuento = 0;

        if( cantRompecab >= CANT_MIN_ROMPECABEZAS )
        {
            descuento = totalVenta * DESCUENTO_1;
        }
        else if( cantDeporte >= CANT_MIN_DEPORTE && cantAccion >= CANT_MIN_ACCION )
        {
            descuento = totalVenta * DESCUENTO_2;
        }
        else
        {
            descuento = 0;
        }

        double totalConDescuento = totalVenta - descuento;

        String mensaje = "El precio total de la venta sería: $" + totalVenta + ".\n" + "El descuento sería de: $" + descuento + "\n" + "El precio con descuento sería: $" + totalConDescuento + ".";

        return mensaje;
    }
    public String metodo1( )
    {
        return "Respuesta 1";
    }
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}