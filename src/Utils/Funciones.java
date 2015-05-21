package Utils;



import javax.swing.JOptionPane;




public class Funciones {
	public static int validaint(String mensaje, String titulo) {
		int a = 0;
		String s;
		boolean correcto = true;

		do {
			try {
				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				if (s == null) {
					// JOptionPane.showMessageDialog(null,
					// "Saliendo de la aplicaci贸n","Saliendo",JOptionPane.INFORMATION_MESSAGE);
					// System.exit(0);//al usuario pulsar cancelar o cerrar la
					// vtna del showinputdialog, acaba la ejecuci贸n
				} else {
					a = Integer.parseInt(s);
					correcto = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido un n潞 entero", "Error",
						JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);

		return a;
	}

	public static int confirmado() {

		int confirmado = JOptionPane.showConfirmDialog(null, "縇o confirmas?");

		return confirmado;
	}

	public static float validafloat(String mensaje, String titulo) {
		float a = 0.0f;
		String s;
		boolean correcto = true;

		do {
			try {
				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);

				a = Float.parseFloat(s);
				correcto = true;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido un num float", "Error",
						JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		
		return a;
	}

	public static char validachar() {
		char c = 0;
		String s;
		boolean correcto = true;

		do {
			try {
				s = JOptionPane.showInputDialog(null, "Escribe una letra", "letra", JOptionPane.QUESTION_MESSAGE);
				if (s == null) {
					JOptionPane.showMessageDialog(null, "Saliendo de la aplicaci贸n", "Saliendo",
							JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);// al usuario pulsar cancelar o cerrar la
									// vtna del showinputdialog, acaba la
									// ejecuci贸n
				} else {
					c = s.charAt(0);
					correcto = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido una letra", "Error", JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		JOptionPane.showMessageDialog(null, "Has introducido: " + c, "Resultado", JOptionPane.INFORMATION_MESSAGE);
		return c;

	}

	public static String validastring(String mensaje, String titulo) {
		String s = "";
		boolean correcto = true;

		do {
			try {
				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				correcto = true;
				if (s == null) {
					JOptionPane.showMessageDialog(null, "Saliendo de la aplicaci髇", "Saliendo",
							JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);// al usuario pulsar cancelar o cerrar la
									// vtna del showinputdialog, acaba la
									// ejecuci贸n
				}
				if (s.equals("")) {
					JOptionPane.showMessageDialog(null, "Error de introducci髇 de datos", "Error",
							JOptionPane.ERROR_MESSAGE);
					correcto = false;
				}
			} catch (Exception e) {
				JOptionPane
						.showMessageDialog(null, "No has introducido una cadena", "Error", JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		return s;
	}

	







}