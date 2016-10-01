/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 *
 * @author Alumno
 */
public class Cajero extends JFrame {

    JTextField texto;
    double monto=100;
    String movimiento;
    JPanel numeros, movimientos;
    
    public Cajero() {
        super();
        setSize(500, 300);
        setTitle("Cajero");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());

        texto = new JTextField("0", 20);
        texto.setBorder(new EmptyBorder(4, 4, 4, 4));
        texto.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        texto.setHorizontalAlignment(JTextField.RIGHT);
        texto.setEditable(false);
        texto.setBackground(Color.orange);
        panel.add("North", texto);

        numeros = new JPanel();
        numeros.setLayout(new GridLayout(4, 3));
        numeros.setBorder(new EmptyBorder(4, 4, 4, 4));

        for (int n = 9; n >= 0; n--) {
            nuevoBotonNumerico("" + n);
        }

        nuevoBotonNumerico(".");

        panel.add("Center", numeros);

        movimientos = new JPanel();
        movimientos.setLayout(new GridLayout(6, 1));
        movimientos.setBorder(new EmptyBorder(4, 4, 4, 4));

        nuevoBotonMovimiento("Abonar");
        nuevoBotonMovimiento("Retirar");
        nuevoBotonMovimiento("Salir");
        nuevoBotonMovimiento("Mostrar monto");

        panel.add("East", movimientos);

        validate();
    }

    private void nuevoBotonMovimiento(String movimiento) {
        JButton mov = new JButton(movimiento);
        mov.setForeground(Color.darkGray);
        
        mov.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent eve){
                JButton mov=(JButton) eve.getSource();
                movPulsado(mov.getText());
            }
        });
        movimientos.add(mov);
    }
    
    private void nuevoBotonNumerico(String digito){
        JButton num=new JButton();
        num.setText(digito);
        num.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseReleased(MouseEvent evt){
                JButton num = (JButton) evt.getSource();
                numpulsado(num.getText());
            }
        });
        numeros.add(num);
    }
    
    private void numpulsado(String digito){
        if(texto.getText().equals("0")){
            texto.setText(digito);
        } else {
            texto.setText(texto.getText() + digito);
        }
    }
    
    private void movPulsado(String movimiento){
        if(movimiento.equals("Salir")){
            int rep=JOptionPane.showConfirmDialog(null, "¿Desea donar a los niños desausiados de africa?","donacion", JOptionPane.YES_NO_OPTION);
            if (rep==0){
                monto=monto-5;
            }
            dispose();
        } else if (movimiento.equals("Abonar")){
            monto=monto+new Double(texto.getText());
            texto.setText("");
        } else if (movimiento.equals("Retirar")){
            monto=monto-new Double(texto.getText());
            texto.setText("");
        } else if (movimiento.equals("Mostrar monto")){
           JOptionPane.showMessageDialog(null, "Tu monto es de:"+monto);
        }
    }
}
