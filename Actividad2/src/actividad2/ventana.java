
package actividad2;

/**
 *
 * @author Alejandro Emmanuel Rangel Mendez y Luis Diego Jiménez Delgado
 *grupo: 5IM6

 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ventana extends JFrame implements ItemListener {
    private JTextField entrada ,salida;
    private JButton covertir;
    private JLabel titulo, mensaje, entradaTitulo, salidaTitulo;
    private JRadioButton fibonacci, factorial;
    private ButtonGroup grupo;
    private boolean opcionSeleccionada = true;
    
    //Se crean ventanas  y los campos
    public ventana(){
        JFrame window = new JFrame();
        window.setLayout(null);
        window.setBounds(100,100,400,600);
        window.setLayout(null);
        //window.setBackground(new Color(0,0,0,124));
        window.setResizable(false);
        
        titulo = new JLabel("<html> <font color = black size = 4 face= 'Calisto MT'>Soy un titulo ");
        titulo.setSize(350,40);
        titulo.setLocation(25, 10);
        window.add(titulo);
        
        
        salida = new JTextField();
        salida.setSize(250,20);
        salida.setLocation(125,100);
        salida.enable(false);
        window.add(salida);
        KeyListener B;
        //Key listener para ambos text field
        B = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String event = "" + (e.getKeyChar());
                if (!(event.equals("1") || event.equals("0") || event.equals("2") || event.equals("3") || event.equals("4") ||  event.equals("5") || event.equals("6") || event.equals("7") ||  event.equals("8") || event.equals("9") ||   e.getKeyCode() == 8)){
                    System.out.println(e.getKeyCode());
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
               String event = "" + (e.getKeyChar());
                if (!(event.equals("1") || event.equals("0") || event.equals("2") || event.equals("3") || event.equals("4") ||  event.equals("5") || event.equals("6") || event.equals("7") ||  event.equals("8") || event.equals("9") ||   e.getKeyCode() == 8)){
                    System.out.println(e.getKeyCode());
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String event = "" + (e.getKeyChar());
                if (!(event.equals("1") || event.equals("0") || event.equals("2") || event.equals("3") || event.equals("4") ||  event.equals("5") || event.equals("6") || event.equals("7") ||  event.equals("8") || event.equals("9") ||   e.getKeyCode() == 8)){
                    System.out.println(e.getKeyCode());
                    e.consume();
                }
            }
        };
        salida.addKeyListener(B);
        
        entrada = new JTextField();
        entrada.setSize(250,20);
        entrada.enable(true);
        entrada.setLocation(125,150);
        window.add(entrada);

        entrada.addKeyListener(B);
        covertir = new JButton("Convertir");
        covertir.setSize(80,20);
        covertir.setLocation(160, 230);
        window.add(covertir);
        covertir.addActionListener((ActionEvent e) -> {
            //actionEvent que define y llama los eventos;
            if (opcionSeleccionada){
                //Llama el metodo de factoral
                String numero =  entrada.getText();
                Factorial factorial = new Factorial();
                int numberToSend = Integer.parseInt(numero);
                numero = Integer.toString(factorial.convertir(numberToSend));
                salida.setText(numero);
            }
            //Llama el metodo de fibonnacci
            else {
                String numero =  entrada.getText();
                Serie fibonacci = new Serie();
                int numberToSend = Integer.parseInt(numero);
                numero = fibonacci.series(numberToSend);
                salida.setText(numero);
            }
        });
        
        mensaje = new JLabel("");
        mensaje.setSize(350,20);
        mensaje.setLocation(25,400);
        window.add(mensaje);
        
        entradaTitulo = new JLabel("Entrada:");
        entradaTitulo.setLocation(25,150);
        entradaTitulo.setSize(100,20);
        window.add(entradaTitulo);
        
        salidaTitulo = new JLabel("Salida:");
        salidaTitulo.setLocation(25,100);
        salidaTitulo.setSize(100,20);
        window.add(salidaTitulo);
        
        grupo = new ButtonGroup();
      
        fibonacci  = new JRadioButton("<html><font color = black size = 4 face= 'Calisto MT'>Factorial",true);
        fibonacci.setBounds(00, 270, 190, 20);
        window.add(fibonacci);
        grupo.add(fibonacci);
        fibonacci.addItemListener(this);
        
        factorial  = new JRadioButton("<html><font color = black size = 4 face= 'Calisto MT'>Fibonacci ",false);
        factorial.setBounds(00, 320, 190, 20);
        window.add(factorial);
        grupo.add(factorial);
        factorial.addItemListener(this);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.setVisible(true);        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //metodo de los radio botones que me genera las opciones
        if (e.getSource() instanceof JRadioButton){
            if (e.getStateChange() == ItemEvent.SELECTED){
                mensaje.setText("");
                if(e.getItemSelectable() == fibonacci ){
                   entrada.setText("");
                   opcionSeleccionada = true;
                }
                else
                if(e.getItemSelectable() == factorial ){
                        salida.setText("");
                        opcionSeleccionada = false;
                    }
            }
        }
        else {
            System.out.println("Fatal error");
        
        }
    }
}

