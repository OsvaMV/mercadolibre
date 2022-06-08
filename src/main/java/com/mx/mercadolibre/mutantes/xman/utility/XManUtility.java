package com.mx.mercadolibre.mutantes.xman.utility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * This class contains to logic implements to evaluate dna persons
 *
 * @author Osvaldo Mata Vega
 * @version 0.1
 */
@Component
@Slf4j
public class XManUtility implements IXManUtility {

    /**
     * Create matrix two-dimensional
     */
    private char[][] squareMatrix;

    /**
     * This method create matrix whit sequences
     *
     * @param array    Is positions to sequences
     * @param posicion Is size to matrix
     */
    private void createSquareMatrix(char[] array, int posicion) {
        squareMatrix[posicion] = array;
    }

    /**
     * This method implements logic to validate string with sequences
     *
     * @param data String to validate
     * @return Boolean with validates
     */
    private boolean validateMatrix(String[] data) {


        for (int i = 0; i < data.length; i++) {

            if (!data[i].matches("[ATCGatcg]*")) {
                log.info("Para analizar DNA solo se permiten las letras A, T, C, G");
                return false;
            }
            if (data[i].length() != data.length) {
                log.info("Error una secuencia de dna es menor o mayor a las otras o el tamaño de la matriz no coincide en vertical u horizontal");
                return false;
            }
            createSquareMatrix(data[i].toUpperCase().toCharArray(), i);

        }
        return true;
    }

    /**
     * This Method find sequences in horizontal positions
     *
     * @param row            Is data to rows analyze
     * @param position       Is data to positions analyze
     * @param actualPosition Is Actual position to analyze
     * @return Boolean data if find sequence
     */
    private boolean horizontalFind(int row, int position, char actualPosition) {

        String sequence = "" + actualPosition + squareMatrix[row][position + 1] + squareMatrix[row][position + 2]
                + squareMatrix[row][position + 3];

        return validateStrings(sequence);

    }

    /**
     * This Method find sequences in vertical positions
     *
     * @param row            Is data to rows analyze
     * @param position       Is data to positions analyze
     * @param actualPosition Is Actual position to analyze
     * @return Boolean data if find sequence
     */
    private boolean verticalFind(int row, int position, char actualPosition) {

        String sequence = "" + actualPosition + squareMatrix[row + 1][position] + squareMatrix[row + 2][position]
                + squareMatrix[row + 3][position];

        return validateStrings(sequence);

    }

    /**
     * This Method find sequences in diagonal positions
     *
     * @param row            Is data to rows analyze
     * @param position       Is data to positions analyze
     * @param actualPosition Is Actual position to analyze
     * @return Boolean data if find sequence
     */
    private boolean diagonalFind(int row, int position, char actualPosition) {

        String sequence = "" + actualPosition + squareMatrix[row + 1][position + 1] + squareMatrix[row + 2][position + 2]
                + squareMatrix[row + 3][position + 3];

        return validateStrings(sequence);

    }

    /**
     * This method validate if sequence strings repeat continually
     *
     * @param sequence Is Strings validate
     * @return Boolean whit validate strings
     */
    private boolean validateStrings(String sequence) {

        switch (sequence) {
            case "AAAA":
            case "TTTT":
            case "GGGG":
            case "CCCC":
                return true;
            default:
                return false;

        }

    }

    /**
     * This method contains logic to evaluate is dna person mutant or human
     *
     * @param dna is array with dan to evaluate
     * @return Boolean with results to evaluate dna person
     */
    @Override
    public Boolean isMutant(String[] dna) {

        squareMatrix = new char[dna.length][dna.length];

        int longMatrix = squareMatrix.length;

        int count = 0;

        if (!validateMatrix(dna)) {
            return false;
        }

        for (int x = 0; x < longMatrix; x++) {

            if (count < 2) {
                for (int y = 0; y < longMatrix; y++) {

                    char actualPosition = squareMatrix[x][y];

                    if (count < 2) {
                        if ((y + 4) <= longMatrix) {
                            if (horizontalFind(x, y, actualPosition)) {
                                count++;
                                log.info("Se encontro una secuencia de DNA: " + actualPosition + " en Horizontal");
                            }
                        }
                    } else {
                        break;
                    }

                    if (count < 2) {
                        if ((x + 4) <= longMatrix) {
                            if (verticalFind(x, y, actualPosition)) {
                                count++;
                                log.info("Se encontro una secuencia de DNA: " + actualPosition + " en Vertical");
                            }
                        }
                    } else {
                        break;
                    }

                    if (count < 2) {
                        if ((y + 4) <= longMatrix) {
                            if ((x + 4) <= longMatrix) {
                                if (diagonalFind(x, y, actualPosition)) {
                                    count++;
                                    log.info("Se encontro una secuencia de DNA: " + actualPosition + " en Diagonal");
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }

        return count >= 2;

    }
}
