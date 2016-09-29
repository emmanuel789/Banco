/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 *
 * @author Alumno
 */
public class login extends JFrame{
    
    JButton entrar, registro;
    
    public login(){
        super();
        setSize(300, 300);
        setTitle("login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        entrar.equals("entrar");
        registro.equals("registrarse");
    }
}
