/*
 * Matrix helpers
 * Author: Michał Cywiński
 * E-Mail: mcywinski[at]hotmail.com
 * Description: Class containing helper methods for projects created at Numerical Methods at Military University of Technology in Warsaw.
 */

package matrixhelpers;

import Jama.Matrix;

/**
 *
 * @author mcywinski
 */
public class MatrixHelpers {
    public static void printMatrix(Matrix m) {
        for (int i = 0; i < m.getRowDimension(); i++) {
            for (int j = 0; j < m.getColumnDimension(); j++) {
                System.out.print(m.get(i, j) + " ");
                if (j == m.getColumnDimension() - 1) {
                    System.out.println();
                }
            }
        }
    }
}
