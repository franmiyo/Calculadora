package Vista;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controlador.EventsHandler;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;

public class VistaCalculadora extends JFrame {

	// Componentes
	private JPanel contentPane;
	private JTextField tfResultado, tfNum1, tfNum2;
	private JLabel lblResultado, lblNum1, lblNum2, lblErrorNum1, lblErrorNum2, icono, lblFondoError;
	private JButton btnSumar, btnRestar, btnMultiplicar, btnDividir, btnRaizCuadrada, btnRaizCubica, btnReset;

	public JLabel getIcono() {
		return icono;
	}

	public JLabel getLblFondoError() {
		return lblFondoError;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public JLabel getLblErrorNum1() {
		return lblErrorNum1;
	}

	public JLabel getLblErrorNum2() {
		return lblErrorNum2;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTfResultado() {
		return tfResultado;
	}

	public void setTfResultado(JTextField tfResultado) {
		this.tfResultado = tfResultado;
	}

	public JTextField getTfNum1() {
		return tfNum1;
	}

	public void setTfNum1(JTextField tfNum1) {
		this.tfNum1 = tfNum1;
	}

	public JTextField getTfNum2() {
		return tfNum2;
	}

	public void setTfNum2(JTextField tfNum2) {
		this.tfNum2 = tfNum2;
	}

	public JLabel getLblResultado() {
		return lblResultado;
	}

	public void setLblResultado(JLabel lblResultado) {
		this.lblResultado = lblResultado;
	}

	public JLabel getLblNum1() {
		return lblNum1;
	}

	public JLabel getLblNum2() {
		return lblNum2;
	}

	public JButton getBtnSumar() {
		return btnSumar;
	}

	public JButton getBtnRestar() {
		return btnRestar;
	}

	public JButton getBtnMultiplicar() {
		return btnMultiplicar;
	}

	public JButton getBtnDividir() {
		return btnDividir;
	}

	public JButton getBtnRaizCuadrada() {
		return btnRaizCuadrada;
	}

	public JButton getBtnRaizCubica() {
		return btnRaizCubica;
	}

	// Constructor
	public VistaCalculadora() {
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 209, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/calculator.png"));
		setResizable(false);
		setTitle("Calculadora");
		initVariables();
		setVisible(true);

	}

	public void initVariables() {

		btnSumar = new JButton("Sumar");
		btnSumar.setBounds(30, 207, 120, 23);
		contentPane.add(btnSumar);

		btnRestar = new JButton("Restar");
		btnRestar.setBounds(190, 207, 120, 23);
		contentPane.add(btnRestar);

		btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.setBounds(30, 252, 120, 23);
		contentPane.add(btnMultiplicar);

		btnDividir = new JButton("Dividir");
		btnDividir.setBounds(190, 252, 120, 23);
		contentPane.add(btnDividir);

		btnRaizCuadrada = new JButton("Raíz cuadrada");
		btnRaizCuadrada.setBounds(30, 298, 120, 23);
		contentPane.add(btnRaizCuadrada);

		btnRaizCubica = new JButton("Raíz cúbica");
		btnRaizCubica.setBounds(190, 298, 120, 23);
		contentPane.add(btnRaizCubica);

		lblResultado = new JLabel("Resultado: ");
		lblResultado.setBounds(67, 402, 82, 14);
		contentPane.add(lblResultado);

		tfResultado = new JTextField();
		tfResultado.setBounds(150, 399, 150, 20);
		contentPane.add(tfResultado);
		tfResultado.setColumns(10);
		tfResultado.setBorder(BorderFactory.createEmptyBorder());

		lblNum1 = new JLabel("Número 1: ");
		lblNum1.setBounds(67, 100, 69, 14);
		contentPane.add(lblNum1);

		lblNum2 = new JLabel("Número 2: ");
		lblNum2.setBounds(67, 154, 69, 14);
		contentPane.add(lblNum2);

		tfNum1 = new JTextField();
		tfNum1.setBounds(184, 100, 86, 20);
		contentPane.add(tfNum1);
		tfNum1.setColumns(10);
		tfNum1.setBorder(BorderFactory.createEmptyBorder());

		tfNum2 = new JTextField();
		tfNum2.setBounds(184, 151, 86, 20);
		contentPane.add(tfNum2);
		tfNum2.setColumns(10);
		tfNum2.setBorder(BorderFactory.createEmptyBorder());

		lblErrorNum1 = new JLabel("Dato no válido");
		lblErrorNum1.setBounds(185, 125, 100, 14);
		lblErrorNum1.setVisible(false);
		contentPane.add(lblErrorNum1);

		lblErrorNum2 = new JLabel("Dato no válido");
		lblErrorNum2.setBounds(185, 182, 100, 14);
		lblErrorNum2.setVisible(false);
		contentPane.add(lblErrorNum2);

		btnReset = new JButton("Resetear");
		btnReset.setBounds(122, 349, 89, 23);
		contentPane.add(btnReset);

		Image img = new ImageIcon("Images/calculator.png").getImage();
		icono = new JLabel(new ImageIcon(img.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
		icono.setBounds(111, 15, 100, 75);
		contentPane.add(icono);

		Image imgBruja = new ImageIcon("Images/bruja.jpg").getImage();
		lblFondoError = new JLabel(new ImageIcon(imgBruja.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
		lblFondoError.setVisible(false);
		lblFondoError.setBounds(111, 15, 100, 75);
		contentPane.add(lblFondoError);

	}

	public void setHandler(EventsHandler handler) {
		// ponemos los botones a la escucha del evento
		btnSumar.addActionListener(handler);
		btnRestar.addActionListener(handler);
		btnMultiplicar.addActionListener(handler);
		btnDividir.addActionListener(handler);
		btnRaizCuadrada.addActionListener(handler);
		btnRaizCubica.addActionListener(handler);
		btnReset.addActionListener(handler);
	}
}
