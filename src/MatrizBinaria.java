import java.io.*;

public class MatrizBinaria {
    public static void main(String[] args) throws IOException {

        FileInputStream leeA = new FileInputStream("a.mat");
        DataInputStream disA = new DataInputStream(leeA);

        FileInputStream leeB = new FileInputStream("b.mat");
        DataInputStream disB = new DataInputStream(leeB);

            File c = new File("c.mat");
            c.createNewFile();
            FileOutputStream fosR = new FileOutputStream(c);
            DataOutputStream dosR = new DataOutputStream(fosR);



            double[][] matrizA = new double[3][3];
            double[][] matrizB = new double[3][3];
            double[][] matrizc = new double[3][3];

            disA.readByte();
            disA.readByte();
            System.out.println("Matriz A");
            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizA.length; j++) {
                    matrizA[i][j] = disA.readDouble();
                    System.out.print(matrizA[i][j] + " \t");
                }System.out.println();
            }
            System.out.println();
            //al leerse los datos con readByte los metemos a una matriz que será la del archivo a



            disB.readByte();
            disB.readByte();
            System.out.println("Matriz B");
            for (int i = 0; i < matrizB.length; i++) {
                for (int j = 0; j < matrizB.length; j++) {
                    matrizB[i][j] = disB.readDouble();
                    System.out.print(matrizB[i][j] + " \t");
                }System.out.println();
            }
            System.out.println();
//hacemos lo mismo de readByte con la matriz B


       ////////MATRIZ C//////
            System.out.println("Matriz c");
            for (int i = 0; i < matrizc.length; i++) {
                for (int j = 0; j < matrizc.length; j++) {

                    for (int k = 0; k < 3; k++) {
                        matrizc[i][j] += matrizA[i][k] * matrizB[k][j];
                    }
                    System.out.print(matrizc[i][j] + " \t");
                }
                //espacio para salto de línea
                System.out.println();
            }


            dosR.writeByte(3);
            dosR.writeByte(3);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    dosR.writeDouble(matrizc[i][j]);
                }//se agregan al archivo con writeByte


            }
    }
}
