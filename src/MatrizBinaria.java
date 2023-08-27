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



            double[][] matA = new double[3][3];
            double[][] matB = new double[3][3];
            double[][] matc = new double[3][3];

            disA.readByte();
            disA.readByte();
            System.out.println("Matriz A");
            for (int i = 0; i < matA.length; i++) {
                for (int j = 0; j < matA.length; j++) {
                    matA[i][j] = disA.readDouble();
                    System.out.print(matA[i][j] + " \t");
                }System.out.println();
            }
            System.out.println();
            //al leerse los datos con readByte los metemos a una matriz que será la del archivo a



            disB.readByte();
            disB.readByte();
            System.out.println("Matriz B");
            for (int i = 0; i < matB.length; i++) {
                for (int j = 0; j < matB.length; j++) {
                    matB[i][j] = disB.readDouble();
                    System.out.print(matB[i][j] + " \t");
                }System.out.println();
            }
            System.out.println();
//hacemos lo mismo de readByte con la matriz B


       ////////MATRIZ C//////
            System.out.println("Matriz c");
            for (int i = 0; i < matc.length; i++) {
                for (int j = 0; j < matc.length; j++) {

                    for (int k = 0; k < 3; k++) {
                        matrizc[i][j] += matA[i][k] * matB[k][j];
                    }
                    System.out.print(matc[i][j] + " \t");
                }
                //espacio para salto de línea
                System.out.println();
            }


            dosR.writeByte(3);
            dosR.writeByte(3);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    dosR.writeDouble(matc[i][j]);
                }//se agregan al archivo con writeByte


            }
    }
}
