package Tarea.AppStore.Metodos.Interfaz;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import Tarea.AppStore.Metodos.App.AppStore;

@SuppressWarnings("serial")
public class InterfazJuego extends JFrame
{
    private AppStore appStore;
    private Opciones opciones;
    private PanelJuego panelJuego1;
    private PanelJuego panelJuego2;
    private PanelJuego panelJuego3;
    private PanelJuego panelJuego4;
    public InterfazJuego( )
    {
        setTitle( "Google PlayStore" );
        setSize( 800, 500 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );


        appStore = new AppStore( );

        setLayout( new BorderLayout( ) );

        opciones = new Opciones( this );
        add(opciones, BorderLayout.SOUTH );

        JPanel panelCentro = new JPanel( );
        panelCentro.setLayout( new GridLayout( 2, 2 ) );

        panelJuego1 = new PanelJuego( this );
        panelJuego1.setBackground(Color.GRAY);
        panelCentro.add( panelJuego1 );
        panelJuego2 = new PanelJuego( this );
        panelJuego2.setBackground(Color.gray);
        panelCentro.add( panelJuego2 );
        panelJuego3 = new PanelJuego( this );
        panelJuego3.setBackground(Color.gray);
        panelCentro.add( panelJuego3 );
        panelJuego4 = new PanelJuego( this );
        panelJuego4.setBackground(Color.gray);
        panelCentro.add( panelJuego4 );

        add( panelCentro, BorderLayout.CENTER );

        setLocationRelativeTo( null );
        setResizable( false );

        actualizar( );
    }

    private void actualizar( )
    {
        panelJuego1.actualizarInfo( appStore.darJuego1( ) );
        panelJuego2.actualizarInfo( appStore.darJuego2( ) );
        panelJuego3.actualizarInfo( appStore.darJuego3( ) );
        panelJuego4.actualizarInfo( appStore.darJuego4( ) );
    }

    public void venderLicencias( String pNombreJuego )
    {
        String pCant = JOptionPane.showInputDialog( this, "Licencias a vender: ", "Vender licencias", JOptionPane.INFORMATION_MESSAGE );
        if( pCant != null )
        {
            try
            {
                int cantidad = Integer.parseInt( pCant );
                if( cantidad > 0 )
                {
                    boolean venta = appStore.venderLicenciasJuego( pNombreJuego, cantidad );
                    if( venta == true )
                    {
                        actualizar( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "No hay suficientes licencias.", "Vender licencias", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La cantidad ingresada debe ser mayor a cero.", "Vender licencias", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un valor numérico.", "Vender licencias", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    public void comprarLicencias( String pNombreJuego )
    {
        String pCant = JOptionPane.showInputDialog( this, "Cantidad de licencias a comprar:", "Comprar licencias", JOptionPane.INFORMATION_MESSAGE );
        if( pCant != null )
        {
            try
            {
                int cantidad = Integer.parseInt( pCant );
                if( cantidad > 0 )
                {
                    appStore.comprarLicenciasJuego( pNombreJuego, cantidad );
                    actualizar( );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La cantidad ingresada debe ser mayor a cero.", "Comprar licencias", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "Ingrese un numero.", "Comprar licencias", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    public void mostrarMasVendido( )
    {
        JOptionPane.showMessageDialog( this, "Juego mas vendido: " + appStore.darJuegoMasVendido( ), "Juego más vendido", JOptionPane.INFORMATION_MESSAGE );
    }

    public void mostrarDialogoDescuentos( )
    {
        Venta dialogo = new Venta( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    public void consultarDescuento( int pCantidadLicenciasJuego1, int pCantidadLicenciasJuego2, int pCantidadLicenciasJuego3, int pCantidadLicenciasJuego4 )
    {
        JOptionPane.showMessageDialog( this, appStore.calcularVentaPorVolumen( pCantidadLicenciasJuego1, pCantidadLicenciasJuego2, pCantidadLicenciasJuego3, pCantidadLicenciasJuego4 ), "Resultados", JOptionPane.INFORMATION_MESSAGE );
    }

    public void reqFuncOpcion1( )
    {
        String resultado = appStore.metodo1( );
        actualizar();
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 1", JOptionPane.INFORMATION_MESSAGE );
    }

    public void reqFuncOpcion2( )
    {
        String resultado = appStore.metodo2( );
        actualizar( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 2", JOptionPane.INFORMATION_MESSAGE );
    }

    public static void main( String[] pArgs )
    {
        try
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazJuego interfaz = new InterfazJuego( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }

}