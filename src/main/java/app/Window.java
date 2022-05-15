package app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.soleus.models.ServerAnswer;
import com.soleus.server.ServerThread;

public class Window extends JFrame implements ActionListener {

    private JButton initiateServerButton; 
    private boolean isServerOn = false;

    public Window() {
        super();                    
        configurarVentana();        
        inicializarComponentes();   
    }

    private void configurarVentana() {
        this.setTitle("Soleus Server");                   
        this.setSize(310, 210);                               
        this.setLocationRelativeTo(null);                     
        this.setLayout(null);                                  
        this.setResizable(false);                               
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }

    private void inicializarComponentes() {
    	initiateServerButton = new JButton();
        initiateServerButton.setText("Iniciar");
        initiateServerButton.setBounds(50, 50, 100, 30); 
        initiateServerButton.addActionListener(this);    
        this.add(initiateServerButton);
    }

    public void actionPerformed(ActionEvent e) {
    	JButton source = (JButton)e.getSource();
    	ServerThread server = new ServerThread();
    	
    	if (initiateServerButton == source) {
    		if (!isServerOn) {
    			isServerOn = true;
    			server.start();
                JOptionPane.showMessageDialog(this, "Servidor iniciado");              	
    		} else {
    			JOptionPane.showMessageDialog(this, "El servidor ya está iniciado");    
    		}
    		}
    		
    	}
    

    public static void main(String[] args) {
        Window V = new Window();      // creamos una ventana
        V.getContentPane().setBackground(Color.WHITE);
        V.setVisible(true);             // hacemos visible la ventana creada
    }
}