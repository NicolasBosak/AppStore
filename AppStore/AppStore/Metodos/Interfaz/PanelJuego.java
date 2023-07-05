package Tarea.AppStore.Metodos.Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Tarea.AppStore.Metodos.App.Juegos;
@SuppressWarnings("serial")
public class PanelJuego extends JPanel implements ActionListener
{
    private static final String BOTON_COMPRAR = "Comprar";
    private static final String BOTON_VENDER = "Vender";
    private InterfazJuego principal;
    private Juegos juegos;
    private JLabel lblCategoriaJuego;
    private JLabel lblPrecioJuego;
    private JLabel lblTamanhoJuego;
    private JLabel lblDisponibles;
    private JLabel lblVendidas;
    private JTextField txtCategoriaJuego;
    private JTextField txtPrecioJuego;
    private JTextField txtTamanhoJuego;
    private JTextField txtDisponibles;
    private JTextField txtVendidas;
    private JLabel lblImagen;
    private JButton botonVender;
    private JButton botonComprar;
    public PanelJuego( InterfazJuego pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );

        JPanel panelDatosJuego = new JPanel( );
        add( panelDatosJuego, BorderLayout.CENTER );
        panelDatosJuego.setBackground(Color.gray);

        panelDatosJuego.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setBorder( new TitledBorder( "Juego"));

        panelDatosJuego.setLayout( new GridLayout( 5, 1, 0, 5 ) );

        lblCategoriaJuego = new JLabel( "Categoría: ");
        txtCategoriaJuego = new JTextField( 10 );
        txtCategoriaJuego.setEditable( false );
        panelDatosJuego.add( lblCategoriaJuego );
        panelDatosJuego.add( txtCategoriaJuego );

        lblTamanhoJuego = new JLabel( "Tamaño en KB: " );
        txtTamanhoJuego = new JTextField( 10 );
        txtTamanhoJuego.setEditable( false );
        panelDatosJuego.add( lblTamanhoJuego );
        panelDatosJuego.add( txtTamanhoJuego );

        lblPrecioJuego = new JLabel( "Precio: " );
        txtPrecioJuego = new JTextField( 10 );
        txtPrecioJuego.setEditable( false );
        panelDatosJuego.add( lblPrecioJuego );
        panelDatosJuego.add( txtPrecioJuego );

        lblDisponibles = new JLabel( "Disponibles: " );
        txtDisponibles = new JTextField( 10 );
        txtDisponibles.setEditable( false );
        panelDatosJuego.add( lblDisponibles );
        panelDatosJuego.add( txtDisponibles );

        lblVendidas = new JLabel( "Vendidas: " );
        txtVendidas = new JTextField( 10 );
        txtVendidas.setEditable( false );
        panelDatosJuego.add( lblVendidas );
        panelDatosJuego.add( txtVendidas );

        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new GridLayout( 1, 2 ) );

        botonComprar = new JButton( "Comprar" );
        botonComprar.setActionCommand( BOTON_COMPRAR );
        botonComprar.setBackground(Color.WHITE);
        botonComprar.addActionListener( this );
        panelSur.add( botonComprar );

        botonVender = new JButton( "Vender" );
        botonVender.setActionCommand( BOTON_VENDER );
        botonVender.setBackground(Color.green);
        botonVender.addActionListener( this );
        panelSur.add( botonVender );

        add( panelSur, BorderLayout.SOUTH );

        lblImagen = new JLabel( );
        add( lblImagen, BorderLayout.WEST );

    }
    public void actualizarInfo( Juegos pJuegos)
    {
        juegos = pJuegos;
        setBorder( new TitledBorder( pJuegos.darNombre( ) ) );

        switch( pJuegos.darCategoria( ) )
        {
            case ACCION:
            {
                txtCategoriaJuego.setText( "Acción" );
                break;
            }
            case DEPORTE:
            {
                txtCategoriaJuego.setText( "Deporte" );
                break;
            }
            case ROMPECABEZAS:
            {
                txtCategoriaJuego.setText( "Rompecabezas" );
                break;
            }
        }
        txtPrecioJuego.setText( pJuegos.darPrecio( ) + "" );
        txtTamanhoJuego.setText( pJuegos.darTamanio( ) + "" );
        txtDisponibles.setText( pJuegos.darCantidadLicencias( ) + "" );
        txtVendidas.setText( pJuegos.darCantidadVendidas( ) + "" );

        ImageIcon icono = new ImageIcon( "./data/imagenes/" + pJuegos.darRutaImagen( ) );
        lblImagen.setIcon( icono );
        lblImagen.setBorder( new TitledBorder( "" ) );
    }
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( comando.equals( BOTON_VENDER ) )
        {
            principal.venderLicencias( juegos.darNombre( ) );
        }
        else if( comando.equals( BOTON_COMPRAR ) )
        {
            principal.comprarLicencias( juegos.darNombre( ) );
        }
    }

}
