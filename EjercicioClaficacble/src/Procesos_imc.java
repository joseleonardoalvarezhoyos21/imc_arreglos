
import javax.swing.JOptionPane;

public class Procesos_imc {


	String nombres[];
	String telefono[];
	Double imcArray[];
	String resultadoImc[];

	public void menu() {
		
		int menu = 0;

		
		
		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog("*****************menu*****************\n\n"
					+ "1.registro\n" 
					+ "2.imprimir\n" 
					+ "3.salir\n\n" 
					+ "*****************menu*****************"));
			proceso(menu);
		}while(menu != 3);
		
		
		
	}

	public void proceso(int menu) {
		switch (menu) {
		case 1:
			datos();
			break;
		case 2:
			imprimir();
			break;
		case 3:
			salir();
			break;
		default:
			System.out.println("Opcion incorrecta");
			break;
		}

	}

	private void salir() {
		System.out.println("Gracias por usar el programa");
		
		
	}

	private void imprimir() {

		for (int i = 0; i < nombres.length; i++) {
			System.out.println("El nombre de la persona es: " +nombres[i] +"\n El telefono: "+ telefono[i] + "\n El resultado del examen es:"+ resultadoImc[i]+ "\n su porcentaje de imc es: "+imcArray[i]);
			System.out.println("*********************************************************");
		}

	}

	private String obtenerResultado(double imc) {

		String resultado = "";

		if (imc < 18) {
			resultado = "anorexia";
		} else if (imc >= 18 && imc < 20) {
			resultado = "Delgades";
		} else if (imc >= 20 && imc < 27) {
			resultado = "Normalidad";
		} else if (imc >= 27 && imc < 30) {
			resultado= "Obesidad grado 1";
		} else if (imc >= 30 && imc < 35) {
			resultado= "Obesidad grado 2";
		} else if (imc >= 35 && imc < 40) {
			resultado= "Obesidad grado 3";
		} else {
			resultado= "Obesidad morbida";
		}

		return resultado;

	}

	public void datos() {

		double peso = 0;
		double altura = 0;

		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de personas a registrar: "));

		nombres = new String[cantidad];
		telefono = new String[cantidad];
		resultadoImc = new String[cantidad];
		imcArray= new Double[cantidad];
		
		double imc = 0;

		String resultado;

		for (int i = 0; i < cantidad; i++) {
			nombres[i] = JOptionPane.showInputDialog("Ingrese su nombre: ");
			telefono[i] = JOptionPane.showInputDialog("Imgrese su número de telefono:");
			do {
				peso = Double.parseDouble(JOptionPane.showInputDialog("ingrese su peso: "));
			}while(peso<0);
			do {
				altura = Double.parseDouble(JOptionPane.showInputDialog("ingrese su altura: "));
			}while(altura<0);
			
			imc = obtenerImc(peso, altura);

			imcArray[i]=imc;
			
			resultado = obtenerResultado(imc);

			resultadoImc[i] = resultado;

		}
		
	}

	private double obtenerImc(double peso, double altura) {

		double imc = 0;

		imc = peso / (altura * altura);

		return imc;

	}

}
