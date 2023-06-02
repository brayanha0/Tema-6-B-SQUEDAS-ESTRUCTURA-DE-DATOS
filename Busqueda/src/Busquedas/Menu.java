package Busquedas;

import javax.swing.*;

import Metodos.Tools;
import Metodos.Busquedas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

	private static Busquedas busq;
	private static JFrame frame;
	private static JPanel panel;
	private static JComboBox<String> opciones;

	public static void main(String[] args) {
		busq = new Busquedas(10);
		createWindow();
	}

	private static void createWindow() {
		frame = new JFrame("Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();

		String[] menuOptions = { "VALORES ORDENADOS", "BUSQUEDAS ORDENADAS", "VALORES ALEATORIOS",
				"BUSQUEDAS DESORDENADAS", "IMPRIME", "VACIA", "SALIR" };
		opciones = new JComboBox<>(menuOptions);
		panel.add(opciones);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedOption = opciones.getSelectedItem().toString();
				handleOption(selectedOption);
			}
		});
		panel.add(btnAceptar);

		frame.getContentPane().add(panel);
		frame.setSize(300, 150);
		frame.setVisible(true);
	}

	private static void handleOption(String option) {
		switch (option) {
		case "VALORES ORDENADOS":
			if (busq.espacioArray()) {
				busq.almacenaAleatorios();
				busq.inserDirecta();
				JOptionPane.showMessageDialog(null, "Datos: " + busq.impresionDatos());
			} else {
				JOptionPane.showMessageDialog(null, "Memoria llena", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "BUSQUEDAS ORDENADAS":
			String op1 = Tools.BusqOrd();
			switch (op1) {

			case "BINARIA":
				if (busq.arrayVacio()) {
					JOptionPane.showMessageDialog(null, "Lista Vacia", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					int buscar = busq.busquedaBinaria(busq.getMemoria(), Tools.leerInt("Dato a buscar: "));
					if (buscar == -1) {
						JOptionPane.showMessageDialog(null, "Dato no encontrado");
					} else {
						int valorEncontrado = busq.getMemoria()[buscar];
						JOptionPane.showMessageDialog(null, "Posición: " + buscar + ", Valor: " + valorEncontrado);
					}
				}
				break;

			case "INTERPOLACION":
				if (busq.arrayVacio()) {
					JOptionPane.showMessageDialog(null, "Lista Vacia", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					int buscar = busq.busquedaInterpolacion(busq.getMemoria(), Tools.leerInt("Dato a buscar: "));
					if (buscar == -1) {
						JOptionPane.showMessageDialog(null, "Dato no encontrado");
					} else {
						int valorEncontrado = busq.getMemoria()[buscar];
						JOptionPane.showMessageDialog(null, "Posición: " + buscar + ", Valor: " + valorEncontrado);
					}
				}
				break;

			case "EXPONENCIAL":
				if (busq.arrayVacio()) {
					JOptionPane.showMessageDialog(null, "Lista Vacia", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					int buscar = busq.busquedaExponencial(busq.getMemoria(), Tools.leerInt("Dato a buscar: "));
					if (buscar == -1) {
						JOptionPane.showMessageDialog(null, "Dato no encontrado");
					} else {
						int valorEncontrado = busq.getMemoria()[buscar];
						JOptionPane.showMessageDialog(null, "Posición: " + buscar + ", Valor: " + valorEncontrado);
					}
				}
				break;

			case "FIBONACCI":
				if (busq.arrayVacio()) {
					JOptionPane.showMessageDialog(null, "Lista Vacia", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					int buscar = busq.busquedaFibonacci(busq.getMemoria(), Tools.leerInt("Dato a buscar: "));
					if (buscar == -1) {
						JOptionPane.showMessageDialog(null, "Dato no encontrado");
					} else {
						int valorEncontrado = busq.getMemoria()[buscar];
						JOptionPane.showMessageDialog(null, "Posición: " + buscar + ", Valor: " + valorEncontrado);
					}
				}
				break;

			case "SALTAR BUSQUEDA":
				if (busq.arrayVacio()) {
					JOptionPane.showMessageDialog(null, "Lista Vacia", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					int buscar = busq.saltoBusqueda(busq.getMemoria(), Tools.leerInt("Dato a buscar: "));
					if (buscar == -1) {
						JOptionPane.showMessageDialog(null, "Dato no encontrado");
					} else {
						int valorEncontrado = busq.getMemoria()[buscar];
						JOptionPane.showMessageDialog(null, "Posición: " + buscar + ", Valor: " + valorEncontrado);
					}
				}
				break;
			}
			break;

		case "VALORES ALEATORIOS":
			if (busq.espacioArray()) {
				busq.almacenaAleatorios();
				JOptionPane.showMessageDialog(null, "Datos: " + busq.impresionDatos());
			} else {
				JOptionPane.showMessageDialog(null, "Memoria llena", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "BUSQUEDAS DESORDENADAS":
			String op2 = Tools.BusqDes();
			switch (op2) {

			case "SECUENCIAL":
				if (busq.arrayVacio()) {
					JOptionPane.showMessageDialog(null, "Lista Vacia", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					int buscar = busq.busquedaSecuencial(busq.getMemoria(), Tools.leerInt("Dato a buscar: "));
					if (buscar == -1) {
						JOptionPane.showMessageDialog(null, "Dato no encontrado");
					} else {
						int valorEncontrado = busq.getMemoria()[buscar];
						JOptionPane.showMessageDialog(null, "Posición: " + buscar + ", Valor: " + valorEncontrado);
					}
				}
				break;

			case "KNUTH MORRIS PRATT":
				String patron = Tools.leerString("Ingresa el texto"); // ababcababcabc
				String datoBuscar = Tools.leerString("Patrón a buscar: "); // abcabc
				boolean encontrado = busq.busquedaKMP(patron, datoBuscar);
				if (encontrado) {
					JOptionPane.showMessageDialog(null, "El patrón se encontró en el texto.");
				} else {
					JOptionPane.showMessageDialog(null, "El patrón no se encontró en el texto.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
			break;

		case "IMPRIME":
			if (busq.arrayVacio()) {
				JOptionPane.showMessageDialog(null, "Memoria Vacia", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Datos: " + busq.impresionDatos());
			}
			break;

		case "VACIAR":
			if (busq.arrayVacio()) {
				JOptionPane.showMessageDialog(null, "La memoria ya está vacia", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				busq.vaciarArray();
			}
			break;

		case "SALIR":
			frame.dispose();
			break;
		}
	}
}
