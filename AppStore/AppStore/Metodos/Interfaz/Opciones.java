package Tarea.AppStore.Metodos.Interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Opciones extends JPanel implements ActionListener
{
    private static final String MAS_VENDIDO = "MasVendido";
    private static final String PROMO_VOLUMEN = "PromoVolumen";
    private static final String OPCION_1 = "OPCION_1";
    private static final String OPCION_2 = "OPCION_2";
    private InterfazJuego principal;
    private JButton botonMasVendido;
    private JButton botonPromocion;
    private JButton btnOpcion1;
    private JButton btnOpcion2;
    public Opciones(InterfazJuego pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 2, 2 ) );

        botonMasVendido = new JButton( "Juego más vendido" );
        botonMasVendido.setActionCommand( MAS_VENDIDO );
        botonMasVendido.setBackground(Color.ORANGE);
        botonMasVendido.addActionListener( this );
        add( botonMasVendido );

        botonPromocion = new JButton( "Descuentos por cantidad" );
        botonPromocion.setActionCommand( PROMO_VOLUMEN );
        botonPromocion.setBackground(Color.YELLOW);
        botonPromocion.addActionListener( this );
        add( botonPromocion );

        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );
    }

    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( MAS_VENDIDO ) )
        {
            principal.mostrarMasVendido( );
        }
        else if( comando.equals( PROMO_VOLUMEN ) )
        {
            principal.mostrarDialogoDescuentos( );
        }
        else if( comando.equals( OPCION_1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( comando.equals( OPCION_2 ) )
        {
            principal.reqFuncOpcion2( );
        }
    }

}
