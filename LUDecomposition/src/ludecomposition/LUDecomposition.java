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
        Matrix lMatrix, uMatrix;
        lMatrix = new Matrix(new double[aMatrix.getRowDimension()][aMatrix.getColumnDimension()]);
        uMatrix = new Matrix(new double[aMatrix.getRowDimension()][aMatrix.getColumnDimension()]);
        
        
        for (int i = 0 ; i < aMatrix.getRowDimension(); i++) {
            //Go through columns
            for (int m = 0; m < uMatrix.getColumnDimension(); m++) {
                double calculatedValue;
                if (i > m) {
                    calculatedValue = 0;
                }
                else { //i >= m, value must be calculated
                    //TODO: Calculation method
                }
            }
        }
    }
    
}
