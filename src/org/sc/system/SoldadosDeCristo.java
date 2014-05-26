package org.sc.system;


import org.sc.window.Window;
import java.awt.EventQueue;

public class SoldadosDeCristo {
	
	public static SystemManager system;
        

	public static void main(String[] args) {
		
		system = new SystemManager();
		
		//essa Janela vai ser criada pra aparecer a tela inicial
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                
               new Window().setVisible(true);
            }   
            
        });
		

	}

}
