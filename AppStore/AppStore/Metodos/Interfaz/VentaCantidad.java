package Tarea.AppStore.Metodos.Interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VentaCantidad extends JPanel implements ActionListener
{
    public static final String ACEPTAR = "ACEPTAR";
    public static final String CANCELAR = "CANCELAR";
    private JLabel lblJuego1;
    private JLabel lblJuego2;
    private JLabel lblJuego3;
    private JLabel lblJuego4;
    private JLabel lblTitulo;
    private JTextField txtJuego1;
    private JTextField txtJuego2;
    private JTextField txtJuego3;
    private JTextField txtJuego4;
    private JButton botonAceptar;
    private JButton botonCancelar;
    private Venta dialogo;
    public VentaCantidad(Venta pDialogo )
    {
        dialogo = pDialogo;
        lblJuego1 = new JLabel( "The Room" );
        lblJuego2 = new JLabel( "Human Fall Flat" );
        lblJuego3 = new JLabel( "NBA 2K23" );
        lblJuego4 = new JLabel( "Rainbow Six Mobile" );
        lblTitulo = new JLabel( "Licencias que desea comprar: " );
        txtJuego1 = new JTextField( );
        txtJuego2 = new JTextField( );
        txtJuego3 = new JTextField( );
        txtJuego4 = new JTextField( );
        botonAceptar = new JButton( "Aceptar" );
        botonAceptar.addActionListener( this );
        botonAceptar.setActionCommand( ACEPTAR );
        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.addActionListener( this );
        botonCancelar.setActionCommand( CANCELAR );

        setLayout( new BorderLayout( ) );
        JPanel panelTitulo = new JPanel( );
        panelTitulo.setLayout( new BorderLayout( ) );
        panelTitulo.add( lblTitulo, BorderLayout.NORTH );
        panelTitulo.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "" ) ) );
        add( panelTitulo, BorderLayout.NORTH );

        JPanel panelDatos = new JPanel( );
        panelDatos.setLayout( new GridLayout( 5, 2, 5, 10 ) );
        panelDatos.add( lblJuego1 );
        panelDatos.add( txtJuego1 );
        panelDatos.add( lblJuego2 );
        panelDatos.add( txtJuego2 );
        panelDatos.add( lblJuego3 );
        panelDatos.add( txtJuego3 );
        panelDatos.add( lblJuego4 );
        panelDatos.add( txtJuego4 );
        panelDatos.add( botonAceptar );
        panelDatos.add( botonCancelar );
        panelDatos.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "" ) ) );

        add( panelDatos, BorderLayout.CENTER );
    }
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( ACEPTAR ) )
        {
            try
            {
                String strCantidadJuego1 = txtJuego1.getText( );

                if( strCantidadJuego1.equals( "" ) )
                    strCantidadJuego1 = "0";

                int cantidadJuego1 = Integer.parseInt( strCantidadJuego1 );
                if( cantidadJuego1 < 0 )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar una cantidad mayor a 0.", "Ventas por cantidad", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    String strCantidadJuego2 = txtJuego2.getText( );

                    if( strCantidadJuego2.equals( "" ) )
                        strCantidadJuego2 = "0";

                    int cantidadJuego2 = Integer.parseInt( strCantidadJuego2 );
                    if( cantidadJuego2 < 0 )
                    {
                        JOptionPane.showMessageDialog( this, "Debe ingresar una cantidad mayor a 0.", "Ventas por cantidad", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        String strCantidadJuego3 = txtJuego3.getText( );

                        if( strCantidadJuego3.equals( "" ) )
                            strCantidadJuego3 = "0";

                        int cantidadJuego3 = Integer.parseInt( strCantidadJuego3 );
                        if( cantidadJuego3 < 0 )
                        {
                            JOptionPane.showMessageDialog( this, "Debe ingresar una cantidad mayor a 0.", "EVentas por cantidad", JOptionPane.ERROR_MESSAGE );
                        }
                        else
                        {
                            String strCantidadJuego4 = txtJuego4.getText( );

                            if( strCantidadJuego4.equals( "" ) )
                                strCantidadJuego4 = "0";

                            int cantidadJuego4 = Integer.parseInt( strCantidadJuego4 );
                            if( cantidadJuego4 < 0 )
                            {
                                JOptionPane.showMessageDialog( this, "Debe ingresar una cantidad mayor a 0.", "Ventas por cantidad", JOptionPane.ERROR_MESSAGE );
                            }
                            else
                            {
                                dialogo.aceptar( cantidadJuego1, cantidadJuego2, cantidadJuego3, cantidadJuego4 );
                            }
                        }
                    }
                }
            }
            catch( NumberFormatException e1 )
            {
                JOptionPane.showMessageDialog( this, "Error, debe ingresar valores numéricos.", "Ventas por cantidad", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dialogo.cancelar( );
        }
    }

}
