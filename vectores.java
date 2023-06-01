package algebra;

import javax.swing.JOptionPane;


public class vectores {

    
    public static void main(String[] args) {

        int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas: "));
        int columns = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas: "));

        int[][] vector = new int[filas][1];
        int[][] vectorB = new int[filas][1];
        int[][] matriz = new int[filas][columns];
        int[][] matriza = new int[filas][columns];
        int[][] nueva = new int[matriz[0].length][matriz.length];
        int determinante = 0;
        String resultado = "";
        String resultadoVec = "";
        String resultadoVecO = "";
        String resultadov = "";

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < 1; j++) {
                vector[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor para la posición [" + (i + 1) + "," + (j + 1) + "] de las cardonedas a convetir"));
            }
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < 1; j++) {
                resultadoVec += "[" + vector[i][j] + "]";
                resultadoVec += "     ";

            }
            resultadoVec += "\n";
        }
        JOptionPane.showMessageDialog(null, "cordenadas a convertir :\n" + resultadoVec);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columns; j++) {
                matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor para la posición [" + (i + 1) + "," + (j + 1) + "] de la matriz"));
            }
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columns; j++) {
                resultado += "[" + matriz[i][j] + "]";
                resultado += "     ";

            }
            resultado += "\n";
        }
        JOptionPane.showMessageDialog(null, "La matriz es:\n" + resultado);
        int op;
        op = Integer.parseInt(JOptionPane.showInputDialog("Convertiar a : \n1.Canonica \n2.Otra base"));
        if (columns == filas && op == 1) {
            switch (filas) {
                case 2 -> {
                    determinante = matriz[0][0] * matriz[1][1] - matriz[1][0] * matriz[0][1];
                    matriza[0][0] = (int) (Math.pow(-1, 2) * (matriz[1][1]));
                    matriza[0][1] = (int) (Math.pow(-1, 3) * (matriz[1][0]));
                    matriza[1][0] = (int) (Math.pow(-1, 3) * (matriz[0][1]));
                    matriza[1][1] = (int) (Math.pow(-1, 4) * (matriz[0][0]));
                    if (determinante != 0) {
                        JOptionPane.showMessageDialog(null, "Linealmente independiente es una base");
                        for (int i = 0; i < matriza.length; i++) {
                            for (int j = 0; j < matriza[0].length; j++) {
                                nueva[j][i] = matriza[i][j];
                                int[] simplified = simplifyFraction(matriza[j][i], determinante);
                                if (simplified[1] == 1) {
                                    resultadov += ("[" + simplified[0] + "] ");
                                } else {
                                    resultadov += ("[" + simplified[0] + "/" + simplified[1] + "] ");
                                }
                                resultadov += "     ";
                            }
                            resultadov += "\n";
                        }
                        JOptionPane.showMessageDialog(null, "la matriz de trancicion es:\n " + resultadov);

                        vectorB[0][0] = (int) ((matriza[0][0] * vector[0][0]) + (matriza[1][0] * vector[1][0]));
                        vectorB[1][0] = (int) ((matriza[0][1] * vector[0][0]) + (matriza[1][1] * vector[1][0]));
                        for (int i = 0; i < vectorB.length; i++) {
                            for (int j = 0; j < vectorB[0].length; j++) {
                                int[] simplified = simplifyFraction(vectorB[i][j], determinante);
                                if (simplified[1] == 1) {
                                    resultadoVecO += ("[" + simplified[0] + "] ");
                                } else {
                                    resultadoVecO += ("[" + simplified[0] + "/" + simplified[1] + "] ");
                                }
                                resultadoVecO += "     ";
                            }
                            resultadoVecO += "\n";
                        }
                        JOptionPane.showMessageDialog(null, "las cordenadas son:\n " + resultadoVecO);

                    } else {
                        JOptionPane.showMessageDialog(null, "Linealmente Depediente no es una base.");
                    }
                }
                case 3 -> {
                    determinante = (matriz[0][0] * (matriz[1][1] * matriz[2][2] - matriz[2][1] * matriz[1][2])) - (matriz[0][1] * (matriz[1][0] * matriz[2][2] - matriz[1][2] * matriz[2][0])) + (matriz[0][2] * (matriz[1][0] * matriz[2][1] - matriz[2][0] * matriz[1][1]));

                    System.out.println(determinante);
                    matriza[0][0] = (int) (Math.pow(-1, 2) * (matriz[1][1] * matriz[2][2] - matriz[2][1] * matriz[1][2]));
                    matriza[0][1] = (int) (Math.pow(-1, 3) * (matriz[1][0] * matriz[2][2] - matriz[2][0] * matriz[1][2]));
                    matriza[0][2] = (int) (Math.pow(-1, 4) * (matriz[1][0] * matriz[2][1] - matriz[2][0] * matriz[1][1]));

                    matriza[1][0] = (int) (Math.pow(-1, 3) * (matriz[0][1] * matriz[2][2] - matriz[2][1] * matriz[0][2]));
                    matriza[1][1] = (int) (Math.pow(-1, 4) * (matriz[0][0] * matriz[2][2] - matriz[2][0] * matriz[0][2]));
                    matriza[1][2] = (int) (Math.pow(-1, 5) * (matriz[0][0] * matriz[2][1] - matriz[2][0] * matriz[0][1]));

                    matriza[2][0] = (int) (Math.pow(-1, 4) * (matriz[0][1] * matriz[1][2] - matriz[1][1] * matriz[0][2]));
                    matriza[2][1] = (int) (Math.pow(-1, 5) * (matriz[0][0] * matriz[1][2] - matriz[1][0] * matriz[0][2]));
                    matriza[2][2] = (int) (Math.pow(-1, 6) * (matriz[0][0] * matriz[1][1] - matriz[1][0] * matriz[0][1]));
                    if (determinante != 0) {
                        JOptionPane.showMessageDialog(null, "Linealmente independiente es una base");
                        for (int i = 0; i < matriza.length; i++) {
                            for (int j = 0; j < matriza[0].length; j++) {
                                nueva[j][i] = matriza[i][j];
                                int[] simplified = simplifyFraction(matriza[j][i], determinante);
                                if (simplified[1] == 1) {
                                    resultadov += ("[" + simplified[0] + "] ");
                                } else {
                                    resultadov += ("[" + simplified[0] + "/" + simplified[1] + "] ");
                                }
                                resultadov += "     ";
                            }
                            resultadov += "\n";
                        }
                        JOptionPane.showMessageDialog(null, "La matriz de trancicion es:\n " + resultadov);

                        vectorB[0][0] = (int) ((matriza[0][0] * vector[0][0]) + (matriza[1][0] * vector[1][0]) + (matriza[2][0] * vector[2][0]));
                        vectorB[1][0] = (int) ((matriza[0][1] * vector[0][0]) + (matriza[1][1] * vector[1][0]) + (matriza[2][1] * vector[2][0]));
                        vectorB[2][0] = (int) ((matriza[0][2] * vector[0][0]) + (matriza[1][2] * vector[1][0]) + (matriza[2][2] * vector[2][0]));

                        for (int i = 0; i < vectorB.length; i++) {
                            for (int j = 0; j < vectorB[0].length; j++) {
                                int[] simplified = simplifyFraction(vectorB[i][j], determinante);
                                if (simplified[1] == 1) {
                                    resultadoVecO += ("[" + simplified[0] + "] ");
                                } else {
                                    resultadoVecO += ("[" + simplified[0] + "/" + simplified[1] + "] ");
                                }
                                resultadoVecO += "     ";
                            }
                            resultadoVecO += "\n";
                        }
                        JOptionPane.showMessageDialog(null, "las cordenadas son:\n " + resultadoVecO);

                    } else {
                        JOptionPane.showMessageDialog(null, "Linealmente Depediente no es una base.");
                    }
                }
                case 4 -> {
                    determinante = (matriz[0][0] * (matriz[1][1] * (matriz[2][2] * matriz[3][3] - matriz[3][2] * matriz[2][3]) - matriz[1][2] * (matriz[2][1] * matriz[3][3] - matriz[3][1] * matriz[2][3]) + matriz[1][3] * (matriz[2][1] * matriz[3][2] - matriz[3][1] * matriz[2][2])))
                            - (matriz[0][1] * (matriz[1][0] * (matriz[2][2] * matriz[3][3] - matriz[3][2] * matriz[2][3]) - matriz[1][2] * (matriz[2][0] * matriz[3][3] - matriz[3][0] * matriz[2][3]) + matriz[1][3] * (matriz[2][0] * matriz[3][2] - matriz[3][0] * matriz[2][2])))
                            + (matriz[0][2] * (matriz[1][0] * (matriz[2][1] * matriz[3][3] - matriz[3][1] * matriz[2][3]) - matriz[1][1] * (matriz[2][0] * matriz[3][3] - matriz[2][3] * matriz[3][0]) + matriz[1][3] * (matriz[2][0] * matriz[3][1] - matriz[3][0] * matriz[2][1])))
                            - (matriz[0][3] * (matriz[1][0] * (matriz[2][1] * matriz[3][2] - matriz[2][2] * matriz[3][1]) - matriz[1][1] * (matriz[2][0] * matriz[3][2] - matriz[3][0] * matriz[2][2]) + matriz[1][2] * (matriz[2][0] * matriz[3][1] - matriz[3][0] * matriz[2][1])));

                    System.out.println(determinante);

                    matriza[0][0] = (int) (Math.pow(-1, 2) * (matriz[1][1] * (matriz[2][2] * matriz[3][3] - matriz[3][2] * matriz[2][3]) - matriz[1][2] * (matriz[2][1] * matriz[3][3] - matriz[3][1] * matriz[2][3]) + matriz[1][3] * (matriz[2][1] * matriz[3][2] - matriz[3][1] * matriz[2][2])));
                    matriza[0][1] = (int) (Math.pow(-1, 3) * (matriz[1][0] * (matriz[2][2] * matriz[3][3] - matriz[3][2] * matriz[2][3]) - matriz[1][2] * (matriz[2][0] * matriz[3][3] - matriz[3][0] * matriz[2][3]) + matriz[1][3] * (matriz[2][0] * matriz[3][2] - matriz[3][0] * matriz[2][2])));
                    matriza[0][2] = (int) (Math.pow(-1, 4) * (matriz[1][0] * (matriz[2][1] * matriz[3][3] - matriz[3][1] * matriz[2][3]) - matriz[1][1] * (matriz[2][0] * matriz[3][3] - matriz[2][3] * matriz[3][0]) + matriz[1][3] * (matriz[2][0] * matriz[3][1] - matriz[3][0] * matriz[2][1])));
                    matriza[0][3] = (int) (Math.pow(-1, 5) * (matriz[1][0] * (matriz[2][1] * matriz[3][2] - matriz[2][2] * matriz[3][1]) - matriz[1][1] * (matriz[2][0] * matriz[3][2] - matriz[3][0] * matriz[2][2]) + matriz[1][2] * (matriz[2][0] * matriz[3][1] - matriz[3][0] * matriz[2][1])));

                    matriza[1][0] = (int) (Math.pow(-1, 3) * (matriz[0][1] * (matriz[2][2] * matriz[3][3] - matriz[3][2] * matriz[2][3]) - matriz[0][2] * (matriz[2][1] * matriz[3][3] - matriz[3][1] * matriz[2][3]) + matriz[0][3] * (matriz[2][1] * matriz[3][2] - matriz[3][1] * matriz[2][2])));
                    matriza[1][1] = (int) (Math.pow(-1, 4) * (matriz[0][0] * (matriz[2][2] * matriz[3][3] - matriz[3][2] * matriz[2][3]) - matriz[0][2] * (matriz[2][0] * matriz[3][3] - matriz[3][0] * matriz[2][3]) + matriz[0][3] * (matriz[2][0] * matriz[3][2] - matriz[3][0] * matriz[2][2])));
                    matriza[1][2] = (int) (Math.pow(-1, 5) * (matriz[0][0] * (matriz[2][1] * matriz[3][3] - matriz[3][1] * matriz[2][3]) - matriz[0][1] * (matriz[2][0] * matriz[3][3] - matriz[3][0] * matriz[2][3]) + matriz[0][3] * (matriz[2][0] * matriz[3][1] - matriz[3][0] * matriz[2][1])));
                    matriza[1][3] = (int) (Math.pow(-1, 6) * (matriz[0][0] * (matriz[2][1] * matriz[3][2] - matriz[3][1] * matriz[2][2]) - matriz[0][1] * (matriz[2][0] * matriz[3][2] - matriz[3][0] * matriz[2][2]) + matriz[0][2] * (matriz[2][0] * matriz[3][1] - matriz[3][0] * matriz[2][1])));

                    matriza[2][0] = (int) (Math.pow(-1, 4) * (matriz[0][1] * (matriz[1][2] * matriz[3][3] - matriz[3][2] * matriz[1][3]) - matriz[0][2] * (matriz[1][1] * matriz[3][3] - matriz[3][1] * matriz[1][3]) + matriz[0][3] * (matriz[1][1] * matriz[3][2] - matriz[3][1] * matriz[1][2])));
                    matriza[2][1] = (int) (Math.pow(-1, 5) * (matriz[0][0] * (matriz[1][2] * matriz[3][3] - matriz[3][2] * matriz[1][3]) - matriz[0][2] * (matriz[1][0] * matriz[3][3] - matriz[3][0] * matriz[1][3]) + matriz[0][3] * (matriz[1][0] * matriz[3][2] - matriz[3][0] * matriz[1][2])));
                    matriza[2][2] = (int) (Math.pow(-1, 6) * (matriz[0][0] * (matriz[1][1] * matriz[3][3] - matriz[3][1] * matriz[1][3]) - matriz[0][1] * (matriz[1][0] * matriz[3][3] - matriz[3][0] * matriz[1][3]) + matriz[0][3] * (matriz[1][0] * matriz[3][1] - matriz[3][0] * matriz[1][1])));
                    matriza[2][3] = (int) (Math.pow(-1, 7) * (matriz[0][0] * (matriz[1][1] * matriz[3][2] - matriz[3][1] * matriz[1][2]) - matriz[0][1] * (matriz[1][0] * matriz[3][2] - matriz[3][0] * matriz[1][2]) + matriz[0][2] * (matriz[1][0] * matriz[3][1] - matriz[3][0] * matriz[1][1])));

                    matriza[3][0] = (int) (Math.pow(-1, 5) * (matriz[0][1] * (matriz[1][2] * matriz[2][3] - matriz[2][2] * matriz[1][3]) - matriz[0][2] * (matriz[1][1] * matriz[2][3] - matriz[2][1] * matriz[1][3]) + matriz[0][3] * (matriz[1][1] * matriz[2][2] - matriz[2][1] * matriz[1][2])));
                    matriza[3][1] = (int) (Math.pow(-1, 6) * (matriz[0][0] * (matriz[1][2] * matriz[2][3] - matriz[2][2] * matriz[1][3]) - matriz[0][2] * (matriz[1][0] * matriz[2][3] - matriz[2][0] * matriz[1][3]) + matriz[0][3] * (matriz[1][0] * matriz[2][2] - matriz[2][0] * matriz[1][2])));
                    matriza[3][2] = (int) (Math.pow(-1, 7) * (matriz[0][0] * (matriz[1][1] * matriz[2][3] - matriz[2][1] * matriz[1][3]) - matriz[0][1] * (matriz[1][0] * matriz[2][3] - matriz[2][0] * matriz[1][3]) + matriz[0][3] * (matriz[1][0] * matriz[2][1] - matriz[2][0] * matriz[1][1])));
                    matriza[3][3] = (int) (Math.pow(-1, 8) * (matriz[0][0] * (matriz[1][1] * matriz[2][2] - matriz[2][1] * matriz[1][2]) - matriz[0][1] * (matriz[1][0] * matriz[2][2] - matriz[2][0] * matriz[1][2]) + matriz[0][2] * (matriz[1][0] * matriz[2][1] - matriz[2][0] * matriz[1][1])));
                    if (determinante != 0) {
                        JOptionPane.showMessageDialog(null, "Linealmente independiente es una base");
                        for (int i = 0; i < matriza.length; i++) {
                            for (int j = 0; j < matriza[0].length; j++) {
                                nueva[j][i] = matriza[i][j];
                                int[] simplified = simplifyFraction(matriza[j][i], determinante);
                                if (simplified[1] == 1) {
                                    resultadov += ("[" + simplified[0] + "] ");
                                } else {
                                    resultadov += ("[" + simplified[0] + "/" + simplified[1] + "] ");
                                }
                                resultadov += "     ";
                            }
                            resultadov += "\n";
                        }
                        JOptionPane.showMessageDialog(null, "La matriz de trancicion es:\n " + resultadov);

                        vectorB[0][0] = (int) ((matriza[0][0] * vector[0][0]) + (matriza[1][0] * vector[1][0]) + (matriza[2][0] * vector[2][0]) + (matriza[3][0] * vector[3][0]));
                        vectorB[1][0] = (int) ((matriza[0][1] * vector[0][0]) + (matriza[1][1] * vector[1][0]) + (matriza[2][1] * vector[2][0]) + (matriza[3][1] * vector[3][0]));
                        vectorB[2][0] = (int) ((matriza[0][2] * vector[0][0]) + (matriza[1][2] * vector[1][0]) + (matriza[2][2] * vector[2][0]) + (matriza[3][2] * vector[3][0]));
                        vectorB[2][0] = (int) ((matriza[0][3] * vector[0][0]) + (matriza[1][3] * vector[1][0]) + (matriza[2][3] * vector[2][0]) + (matriza[3][3] * vector[3][0]));

                        for (int i = 0; i < vectorB.length; i++) {
                            for (int j = 0; j < vectorB[0].length; j++) {
                                int[] simplified = simplifyFraction(vectorB[i][j], determinante);
                                if (simplified[1] == 1) {
                                    resultadoVecO += ("[" + simplified[0] + "] ");
                                } else {
                                    resultadoVecO += ("[" + simplified[0] + "/" + simplified[1] + "] ");
                                }
                                resultadoVecO += "     ";
                            }
                            resultadoVecO += "\n";
                        }
                        JOptionPane.showMessageDialog(null, "las cordenadas son:\n " + resultadoVecO);
                    } else {
                        JOptionPane.showMessageDialog(null, "Linealmente Depediente no es una base.");
                    }
                }
                default ->
                    JOptionPane.showMessageDialog(null, "Matriz invalida");
            }

        } else if (columns == filas && op == 2) {
            switch (filas) {
                case 2 -> {
                    if (determinante != 0) {
                        JOptionPane.showMessageDialog(null, "Linealmente independiente es una base");
                        vectorB[0][0] = (int) ((matriz[0][0] * vector[0][0]) + (matriz[0][1] * vector[1][0]));
                        vectorB[1][0] = (int) ((matriz[1][0] * vector[0][0]) + (matriz[1][1] * vector[1][0]));
                        for (int i = 0; i < vector.length; i++) {
                            for (int j = 0; j < vector[0].length; j++) {
                                resultadoVecO += "[" + vectorB[i][j] + "]";
                                resultadoVecO += "     ";

                            }
                            resultadoVecO += "\n";
                        }
                        JOptionPane.showMessageDialog(null, "las cordenadas son:\n " + resultadoVecO);

                        JOptionPane.showMessageDialog(null, "las cordenadas son:\n " + resultadoVecO);
                    } else {
                        JOptionPane.showMessageDialog(null, "Linealmente Depediente no es una base.");
                    }
                }
                case 3 -> {
                    if (determinante != 0) {
                        vectorB[0][0] = (int) ((matriz[0][0] * vector[0][0]) + (matriz[0][1] * vector[1][0]) + (matriz[0][2] * vector[2][0]));
                        vectorB[1][0] = (int) ((matriz[1][0] * vector[0][0]) + (matriz[1][1] * vector[1][0]) + (matriz[1][2] * vector[2][0]));
                        vectorB[2][0] = (int) ((matriz[2][0] * vector[0][0]) + (matriz[2][1] * vector[1][0]) + (matriz[2][2] * vector[2][0]));
                        for (int i = 0; i < vector.length; i++) {
                            for (int j = 0; j < vector[0].length; j++) {
                                resultadoVecO += "[" + vectorB[i][j] + "]";
                                resultadoVecO += "     ";

                            }
                            resultadoVecO += "\n";
                        }
                        JOptionPane.showMessageDialog(null, "las cordenadas son:\n " + resultadoVecO);
                    } else {
                        JOptionPane.showMessageDialog(null, "Linealmente Depediente no es una base.");
                    }
                }
                case 4 -> {
                    if (determinante != 0) {
                        vectorB[0][0] = (int) ((matriz[0][0] * vector[0][0]) + (matriz[1][0] * vector[1][0]) + (matriz[2][0] * vector[2][0]) + (matriz[3][0] * vector[3][0]));
                        vectorB[1][0] = (int) ((matriz[0][1] * vector[0][0]) + (matriz[1][1] * vector[1][0]) + (matriz[2][1] * vector[2][0]) + (matriz[3][1] * vector[3][0]));
                        vectorB[2][0] = (int) ((matriz[0][2] * vector[0][0]) + (matriz[1][2] * vector[1][0]) + (matriz[2][2] * vector[2][0]) + (matriz[3][2] * vector[3][0]));
                        vectorB[2][0] = (int) ((matriz[0][3] * vector[0][0]) + (matriz[1][3] * vector[1][0]) + (matriz[2][3] * vector[2][0]) + (matriz[3][3] * vector[3][0]));

                        for (int i = 0; i < vector.length; i++) {
                            for (int j = 0; j < vector[0].length; j++) {
                                resultadoVecO += "[" + vectorB[i][j] + "]";
                                resultadoVecO += "     ";

                            }
                            resultadoVecO += "\n";
                        }
                        JOptionPane.showMessageDialog(null, "las cordenadas son:\n " + resultadoVecO);
                    } else {
                        JOptionPane.showMessageDialog(null, "Linealmente Depediente no es una base.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "LAS MATRICES RECTANGULARES NO SON BASES.");
        }
    }

    static int[] simplifyFraction(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);
        int simplifiedNumerator = numerator / gcd;
        int simplifiedDenominator = denominator / gcd;
        return new int[]{simplifiedNumerator, simplifiedDenominator};
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
