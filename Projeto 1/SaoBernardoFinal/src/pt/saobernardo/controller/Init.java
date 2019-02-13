package pt.saobernardo.controller;

import java.io.FileNotFoundException;

import pt.saobernardo.view.FrameLogin;

public class Init {

	public static void main(String[] args) {

		// 1. Invocar m�todo para carregamento dos dados dos ficheiros para mem�ria (Chamar load)
		
			try {
				SaoBernardo.load();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		
		// 2. Mostrar a primeira JFrame (chamar a frame Login)
		
		FrameLogin fl = new FrameLogin();
		fl.setVisible(true);
		
		
		
	}

}
