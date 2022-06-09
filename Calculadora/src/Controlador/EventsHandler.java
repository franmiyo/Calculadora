package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import Modelo.Division;
import Modelo.Multiplicacion;
import Modelo.Raiz;
import Modelo.Resta;
import Modelo.Suma;
import Vista.JPanelWithBackground;
import Vista.MainWindow;
import Vista.VistaCalculadora;

public class EventsHandler implements ActionListener {

	private VistaCalculadora mainWindow;
	private JLabel back;

	public JLabel getBack() {
		return back;
	}

	public VistaCalculadora getMainWindow() {
		return mainWindow;
	}

	public EventsHandler(VistaCalculadora mainWindow) {

		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == mainWindow.getBtnSumar()) {
			// Validacion de datos introducidos por usuario
			if (!checkData(mainWindow.getTfNum1().getText()) || !checkData(mainWindow.getTfNum2().getText())) {
				badInput();
				return;
			}
			if (!fieldsCheck()) {
				badInput();
				return;
			}
			sonido1();
			// En caso de introducir correctamente los datos se realiza operacion
			double num1 = Float.parseFloat(mainWindow.getTfNum1().getText());
			double num2 = Float.parseFloat(mainWindow.getTfNum2().getText());
			Suma suma = new Suma(num1, num2);
			String result = String.valueOf(suma.sumar());
			mainWindow.getTfResultado().setText(result);

		}
		if (e.getSource() == mainWindow.getBtnRestar()) {
			// Validacion de datos introducidos por usuario
			if (!checkData(mainWindow.getTfNum1().getText()) || !checkData(mainWindow.getTfNum2().getText())) {
				badInput();
				return;
			}
			if (!fieldsCheck()) {
				badInput();
				return;
			}
			sonido1();
			// En caso de introducir correctamente los datos se realiza operacion
			double num1 = Float.parseFloat(mainWindow.getTfNum1().getText());
			double num2 = Float.parseFloat(mainWindow.getTfNum2().getText());
			Resta resta = new Resta(num1, num2);
			String result = String.valueOf(resta.restar());
			mainWindow.getTfResultado().setText(result);
		}
		if (e.getSource() == mainWindow.getBtnMultiplicar()) {
			// Validacion de datos introducidos por usuario
			if (!checkData(mainWindow.getTfNum1().getText()) || !checkData(mainWindow.getTfNum2().getText())) {
				badInput();
				return;
			}
			if (!fieldsCheck()) {
				badInput();
				return;
			}
			sonido1();
			// En caso de introducir correctamente los datos se realiza operacion
			double num1 = Float.parseFloat(mainWindow.getTfNum1().getText());
			double num2 = Float.parseFloat(mainWindow.getTfNum2().getText());
			Multiplicacion multiplicacion = new Multiplicacion(num1, num2);
			String result = String.valueOf(multiplicacion.multiplicar());
			mainWindow.getTfResultado().setText(result);

		}
		if (e.getSource() == mainWindow.getBtnDividir()) {
			// Validacion de datos introducidos por usuario
			if (!checkData(mainWindow.getTfNum1().getText()) || !checkData(mainWindow.getTfNum2().getText())) {
				badInput();
				return;
			}
			if (!fieldsCheck()) {
				badInput();
				return;
			}
			sonido1();
			// En caso de introducir correctamente los datos se realiza operacion
			double num1 = Float.parseFloat(mainWindow.getTfNum1().getText());
			double num2 = Float.parseFloat(mainWindow.getTfNum2().getText());
			Division division = new Division(num1, num2);
			String result = String.valueOf(division.dividir());
			mainWindow.getTfResultado().setText(result);

		}
		if (e.getSource() == mainWindow.getBtnRaizCuadrada()) {
			// Validacion de datos introducidos por usuario
			if (!rootCheck()) {
				badInput();
				return;
			}

			if (mainWindow.getTfNum1().getText().length() > 0) {
				if (!checkData(mainWindow.getTfNum1().getText())) {
					badInput();
					return;
				}
				sonido1();
				double num = Float.parseFloat(mainWindow.getTfNum1().getText());
				Raiz raizCuadrada = new Raiz(num);
				mainWindow.getTfResultado().setText(raizCuadrada.raizCuadrada());
			}
			if (mainWindow.getTfNum2().getText().length() > 0) {
				if (!checkData(mainWindow.getTfNum2().getText())) {
					badInput();
					return;
				}
				sonido1();
				double num = Float.parseFloat(mainWindow.getTfNum2().getText());
				Raiz raizCuadrada = new Raiz(num);
				mainWindow.getTfResultado().setText(raizCuadrada.raizCuadrada());
			}

		}
		if (e.getSource() == mainWindow.getBtnRaizCubica()) {
			// Validacion de datos introducidos por usuario
			if (!rootCheck()) {
				badInput();
				return;
			}

			if (mainWindow.getTfNum1().getText().length() > 0) {
				if (!checkData(mainWindow.getTfNum1().getText())) {
					badInput();
					return;
				}
				sonido1();
				double num = Float.parseFloat(mainWindow.getTfNum1().getText());
				Raiz raizCubica = new Raiz(num);
				mainWindow.getTfResultado().setText(raizCubica.raizCubica());
			}
			if (mainWindow.getTfNum2().getText().length() > 0) {
				if (!checkData(mainWindow.getTfNum2().getText())) {
					badInput();
					return;
				}
				sonido1();
				double num = Float.parseFloat(mainWindow.getTfNum2().getText());
				Raiz raizCubica = new Raiz(num);
				mainWindow.getTfResultado().setText(raizCubica.raizCubica());
			}
		}
		if (e.getSource() == mainWindow.getBtnReset()) {
			resetForm();
		}
	}



	private void badInput() {
		errorMessage();
		sonido2();
		badUserInput();
	}

	private void errorMessage() {
		mainWindow.getLblErrorNum1().setVisible(true);
		mainWindow.getLblErrorNum2().setVisible(true);
		mainWindow.getTfNum1().setBorder(new LineBorder(Color.RED));
		mainWindow.getTfNum2().setBorder(new LineBorder(Color.RED));
		mainWindow.getTfNum1().requestFocus();

	}

	private void badUserInput() {
		try {
			mainWindow.getLblFondoError().setVisible(true);
			mainWindow.getIcono().setVisible(false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private boolean fieldsCheck() {
		if (mainWindow.getTfNum1().getText().length() == 0 || mainWindow.getTfNum2().getText().length() == 0) {
			return false;
		}
		return true;
	}
	
	private boolean checkData(String cadena) {

		try {
			Float.parseFloat(cadena);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	private void resetForm() {
		mainWindow.getTfNum1().setText("");
		mainWindow.getTfNum2().setText("");
		mainWindow.getTfResultado().setText("");
		mainWindow.getLblErrorNum1().setVisible(false);
		mainWindow.getLblErrorNum2().setVisible(false);
		mainWindow.getTfNum1().setBorder(new LineBorder(Color.BLACK));
		mainWindow.getTfNum2().setBorder(new LineBorder(Color.BLACK));
		mainWindow.getTfNum1().requestFocus();
		mainWindow.getLblFondoError().setVisible(false);
		mainWindow.getIcono().setVisible(true);
		sonido3();
	}

	private boolean rootCheck() {
		if (mainWindow.getTfNum1().getText().length() > 0 && mainWindow.getTfNum2().getText().length() == 0) {
			return true;
		}
		if (mainWindow.getTfNum1().getText().length() == 0 && mainWindow.getTfNum2().getText().length() > 0) {
			return true;
		}

		return false;
	}

	private static void sonido1() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("Audio/0010552.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			return;
		}
	}

	private static void sonido2() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("Audio/0003862.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			return;
		}
	}

	private static void sonido3() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("Audio/0002615.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			return;
		}
	}

}
