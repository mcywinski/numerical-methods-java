/*
 * LU Decomposition
 * Author: Michał Cywiński
 * E-Mail: mcywinski[at]hotmail.com
 * Description: LU Decomposition algorithm created for Numerical Methods classes at Military University of Technology in Warsaw.
 */

package ludecomposition;

import Jama.Matrix;
import matrixhelpers.MatrixHelpers;

/**
 *
 * @author mcywinski
 */
public class LUDecomposition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Matrix aMatrix = null;
        boolean useFixtureData = true;
        
        if (useFixtureData) {
            double[][] rawAMatrix = new double[4][4];
            
            //Fill row 1
            rawAMatrix[0][0] = 3;
            rawAMatrix[0][1] = -4;
            rawAMatrix[0][2] = 4;
            rawAMatrix[0][3] = -4;
            
            //Fill row 2
            rawAMatrix[1][0] = 1.5;
            rawAMatrix[1][1] = -1;
            rawAMatrix[1][2] = 2;
            rawAMatrix[1][3] = -2;
            
            //Fill row 3
            rawAMatrix[2][0] = 1.5;
            rawAMatrix[2][1] = -0.5;
            rawAMatrix[2][2] = 0;
            rawAMatrix[2][3] = -3;
            
            //Fill row 4
            rawAMatrix[3][0] = 4.5;
            rawAMatrix[3][1] = -5.5;
            rawAMatrix[3][2] = 4;
            rawAMatrix[3][3] = -9;
            
            aMatrix = new Matrix(rawAMatrix);
        }
        else {
            //TODO: Prompt user for non-fixture data
        }
        
        System.out.println("A matrix is: ");
        MatrixHelpers.printMatrix(aMatrix);
        
        //LU Decomposition starts here
        int size = aMatrix.getColumnDimension();
        Matrix lMatrix, uMatrix;
        lMatrix = new Matrix(new double[size][size]);
        uMatrix = new Matrix(new double[size][size]);
        
        for (int i = 0 ; i < aMatrix.getRowDimension(); i++) {
            double calculatedValue;
            
            //Go through horizontally
            for (int j = 0; j < uMatrix.getColumnDimension(); j++) {
                if (i > j) { //All values above diagonal
                    calculatedValue = 0;
                    uMatrix.set(i, j, calculatedValue);
                }
                else {
                    double valueA = aMatrix.get(i, j);
                    double sum = valueA;
                    for (int k = 0; k <= i - 1; k++) {
                        double lValue = lMatrix.get(i, k);
                        double uValue = uMatrix.get(k, j);
                        sum += (lValue * uValue);
                    }
                    uMatrix.set(i, j, sum);
                }
            }
            
            //Go vertically
            for (int j = 0; j < lMatrix.getRowDimension(); j++) {
                if (i == j) { //Diagonal
                    calculatedValue = 1;
                    lMatrix.set(i, j, calculatedValue);
                }
                else if (i > j) { //All values below diagonal
                    calculatedValue = 0;
                    lMatrix.set(i, j, calculatedValue);
                }
                else if (i < j) { //All values above diagonal
                    double valueA = aMatrix.get(j, i);
                    double sum = valueA;
                    for (int k = 0; k <= i - 1; k++) {
                        double lVal = lMatrix.get(j, k);
                        double uVal = uMatrix.get(k, i);
                        sum += (lVal * uVal);
                    }
                    double finalValue = sum / uMatrix.get(i, i);
                    lMatrix.set(j, i, finalValue);
                }
            }
        }
        
        //Print the values to the screen
        System.out.println("L matrix is: ");
        MatrixHelpers.printMatrix(lMatrix);
        
        System.out.println("U matrix is: ");
        MatrixHelpers.printMatrix(uMatrix);
    }
    
}
