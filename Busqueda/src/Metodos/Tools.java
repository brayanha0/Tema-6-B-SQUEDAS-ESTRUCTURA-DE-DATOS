package Metodos;

import javax.swing.JOptionPane;

public class Tools {
    
    public static byte leerByte(String msje) {
        byte num = 0;
        boolean r = true;
        do {
            try {
                num = (Byte.parseByte(JOptionPane.showInputDialog(null, msje, "Lectura", JOptionPane.QUESTION_MESSAGE)));
                r = false;
            } catch (NumberFormatException e) {
                imprimirErrorMSJE("Error, Ingrese valor valido, no deje campos vacios");
            }
        } while (r);
        return num;
    }
    public static String BusqOrd() {
        try {
            String opcion[] = { "BINARIA", "INTERPOLACION", "EXPONENCIAL", "FIBONACCI", "SALTAR BUSQUEDA" };
            int n;
            n = JOptionPane.showOptionDialog(null, "OPCIONES DE BUSQUEDAS ORDENADAS", "MENU BUSQUEDA ORDENADA",
                    JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcion, opcion[0]);
            return (opcion[n]);
        } catch (Exception e) {
            System.exit(0);
        }
        return null;
    }

    public static short leerShort(String msje) {
        short num = 0;
        boolean r = true;
        do {
            try {
                num = (Short.parseShort(JOptionPane.showInputDialog(null, msje, "Lectura", JOptionPane.QUESTION_MESSAGE)));
                r = false;
            } catch (NumberFormatException e) {
                imprimirErrorMSJE("Error, Ingrese valor valido, no deje campos vacios use numeros enteros");
            }
        } while (r);
        return num;
    }

    public static int leerInt(String msje) {
        int num = 0;
        boolean r = true;
        do {
            try {
                num = (Integer.parseInt(JOptionPane.showInputDialog(null, msje, "Lectura", JOptionPane.QUESTION_MESSAGE)));
                r = false;
            } catch (NumberFormatException e) {
                imprimirErrorMSJE("Error, Ingrese valor valido, no deje campos vacios use numeros enteros");
            }
        } while (r);
        return num;
    }

    public static Long leerLong(String msje) {
        long num = 0;
        boolean r = true;
        do {
            try {
                num = (Long.parseLong(JOptionPane.showInputDialog(null, msje, "Lectura", JOptionPane.QUESTION_MESSAGE)));
                r = false;
            } catch (NumberFormatException e) {
                imprimirErrorMSJE("Error, Ingrese valor valido, no deje campos vacios");
            }
        } while (r);
        return num;
    }

    public static Float leerFloat(String msje) {
        float num = 0;
        boolean r = true;
        do {
            try {
                num = (Float.parseFloat(JOptionPane.showInputDialog(null, msje, "Lectura", JOptionPane.QUESTION_MESSAGE)));
                r = false;
            } catch (NumberFormatException e) {
                imprimirErrorMSJE("Error, Ingrese valor valido, no deje campos vacios");
            }
        } while (r);
        return num;
    }

    public static double leerDouble(String msje) {
        double num = 0;
        boolean r = true;
        do {
            try {
                num = Double.parseDouble(JOptionPane.showInputDialog(null, msje, "Lectura", JOptionPane.QUESTION_MESSAGE));
                r = false;
            } catch (NumberFormatException e) {
                imprimirErrorMSJE("Error, Ingrese valor valido, no deje campos vacios");
            }
        } while (r);
        return num;
    }

    public static char leerChar(String msje) {
        char num = 0;
        boolean r = true;
        do {
            try {
                num = (JOptionPane.showInputDialog(null, msje, "Lectura", JOptionPane.QUESTION_MESSAGE).charAt(0));
                r = false;
            } catch (NumberFormatException e) {
                imprimirErrorMSJE("Error, Ingrese valor valido, no deje campos vacios");
            }
        } while (r);
        return num;
    }

    public static String leerString(String msje) {
        String num = "";
        boolean r = true;
        do {
            try {
                num = JOptionPane.showInputDialog(null, msje, "Lectura" + "", JOptionPane.QUESTION_MESSAGE);
                r = false;
            } catch (NumberFormatException e) {
                imprimirErrorMSJE("Error, Ingrese valor valido, no deje campos vacios");
            }
        } while (r);
        return num;
    }

    public static void imprimirMSJE(String Msje) {
        JOptionPane.showMessageDialog(null, Msje, "Salida", JOptionPane.QUESTION_MESSAGE);
    }

    public static void imprimirErrorMSJE(String Msje) {
        JOptionPane.showMessageDialog(null, Msje, "Salida", JOptionPane.ERROR_MESSAGE);
    }

    public static String Botones(String menu) {
        try {
            String opcion[] = { "", "", "", "", "", "", "" };
            int n;
            n = JOptionPane.showOptionDialog(null, "SELECCIONA", "MENU", JOptionPane.NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opcion, opcion[0]);
            return (opcion[n]);
        } catch (Exception e) {
            System.exit(0);
        }
        return null;
    }

    public static String Deslizable() {
        try {
            String valores[] = { "", "", "", "", "", "", "", "", "", "" };
            return (String) JOptionPane.showInputDialog(null, "Tipo", "Selecciona el tipo de modelo: ",
                    JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);
        } catch (Exception e) {
            System.exit(0);
        }
        return null;
    }

    public static String BotonesBusquedas(String menu) {
        try {
            String opcion[] = { "VALORES ORDENADOS", "BUSQUEDAS ORDENADAS", "VALORES ALEATORIOS",
                    "BUSQUEDAS DESORDENADAS", "IMPRIMIR", "VACIAR", "SALIR" };
            int n;
            n = JOptionPane.showOptionDialog(null, "SELECCIONA", "MENU DE BUSQUEDA", JOptionPane.NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opcion, opcion[0]);
            return (opcion[n]);
        } catch (Exception e) {
            System.exit(0);
        }
        return null;
    }

    public static String BusqDes() {
        try {
            String opcion[] = { "SECUENCIAL", "KNUTH MORRIS PRATT" };
            int n;
            n = JOptionPane.showOptionDialog(null, "OPCIONES DE BUSQUEDAS DESORDENADAS",
                    "MENU DE BUSQUEDAS DESORDENADAS", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    opcion, opcion[0]);
            return (opcion[n]);
        } catch (Exception e) {
            System.exit(0);
        }
        return null;
    }

    
}
