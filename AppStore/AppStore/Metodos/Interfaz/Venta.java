package Tarea.AppStore.Metodos.Interfaz;
import javax.swing.JDialog;
import java.awt.*;

@SuppressWarnings("serial")
public class Venta extends JDialog
{
    private VentaCantidad ventaCantidad;
    private InterfazJuego principal;
    public Venta(InterfazJuego pPrincipal )
    {
        principal = pPrincipal;

        setTitle( "Consultar venta por cantidad" );
        setSize( 400, 240 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
        this.getContentPane().setBackground(Color.orange);

        ventaCantidad = new VentaCantidad( this );

        add(ventaCantidad);

        setModal( true );
        setLocationRelativeTo( pPrincipal );
        setResizable( false );
    }
    public void cancelar( )
    {
        dispose( );
    }
    public void aceptar( int pCantidadLicenciasJuego1, int pCantidadLicenciasJuego2, int pCantidadLicenciasJuego3, int pCantidadLicenciasJuego4 )
    {
        principal.consultarDescuento( pCantidadLicenciasJuego1, pCantidadLicenciasJuego2, pCantidadLicenciasJuego3, pCantidadLicenciasJuego4 );
        dispose( );
    }

}
