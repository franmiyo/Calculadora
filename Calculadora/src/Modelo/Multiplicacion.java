package Modelo;

public class Multiplicacion {

	private double num1;
	private double num2;

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public Multiplicacion(double num1, double num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	public double multiplicar() {
		double result = num1 * num2;
		return result;
	}
}
