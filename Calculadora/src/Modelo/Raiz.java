package Modelo;

public class Raiz {

	private double num1;

	public double getNum1() {
		return num1;
	}

	public Raiz(double num1) {
		super();
		this.num1 = num1;

	}

	public String raizCuadrada() {
		num1 = Math.sqrt(num1);
		String result = String.valueOf(num1);
		return result;
	}

	public String raizCubica() {
		num1 = Math.cbrt(num1);
		String result = String.valueOf(num1);
		return result;
	}

}
