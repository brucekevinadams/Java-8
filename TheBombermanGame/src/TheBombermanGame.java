import java.util.Scanner;

public class TheBombermanGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();
        int timeOut = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[row][column];
        String[] grid = new String[row];
        for (int i = 0; i < row; i++) {
            grid[i] = sc.nextLine();
            for (int j = 0; j < column; j++) {
                if (grid[i].charAt(j) == '.') {
                    matrix[i][j] = -1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        sc.close();
        if (timeOut == 1) {
            for (int i = 0; i < row; i++) {
                System.out.println(grid[i]);
            }
        } else {
            if (timeOut % 2 == 0) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        System.out.print('O');
                    }
                    System.out.println();

                }
                return;
            } else {
                if (timeOut % 4 == 3) {
                    for (int j = 0; j < row; j++) {
                        for (int k = 0; k < column; k++) {
                            if (matrix[j][k] == 0) {
                                matrix[j][k] = -2;
                                if (j < row - 1) {
                                    if (matrix[j + 1][k] < 0) {
                                        matrix[j + 1][k] = -2;
                                    }
                                }
                                if (j > 0) {
                                    if (matrix[j - 1][k] < 0) {
                                        matrix[j - 1][k] = -2;
                                    }
                                }
                                if (k > 0) {
                                    if (matrix[j][k - 1] < 0) {
                                        matrix[j][k - 1] = -2;
                                    }
                                }
                                if (k < column - 1) {
                                    if (matrix[j][k + 1] < 0) {
                                        matrix[j][k + 1] = -2;
                                    }
                                }
                            }
                        }
                    }
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < column; j++) {
                            if (matrix[i][j] == -1) {
                                System.out.print('O');
                            }
                            if (matrix[i][j] == -2) {
                                System.out.print('.');
                            }
                        }
                        System.out.println();
                    }

                } else {
                    for (int j = 0; j < row; j++) {
                        for (int k = 0; k < column; k++) {
                            if (matrix[j][k] == 0) {
                                matrix[j][k] = -2;
                                if (j < row - 1) {
                                    if (matrix[j + 1][k] < 0) {
                                        matrix[j + 1][k] = -2;
                                    }
                                }
                                if (j > 0) {
                                    if (matrix[j - 1][k] < 0) {
                                        matrix[j - 1][k] = -2;
                                    }
                                }
                                if (k > 0) {
                                    if (matrix[j][k - 1] < 0) {
                                        matrix[j][k - 1] = -2;
                                    }
                                }
                                if (k < column - 1) {
                                    if (matrix[j][k + 1] < 0) {
                                        matrix[j][k + 1] = -2;
                                    }
                                }
                            }
                        }
                    }

                    for (int j = 0; j < row; j++) {
                        for (int k = 0; k < column; k++) {
                            if (matrix[j][k] == -1) {
                                matrix[j][k] = -3;
                                if (j < row - 1) {
                                    if (matrix[j + 1][k] == -2) {
                                        matrix[j + 1][k] = -3;
                                    }
                                }
                                if (j > 0) {
                                    if (matrix[j - 1][k] == -2) {
                                        matrix[j - 1][k] = -3;
                                    }
                                }
                                if (k > 0) {
                                    if (matrix[j][k - 1] == -2) {
                                        matrix[j][k - 1] = -3;
                                    }
                                }
                                if (k < column - 1) {
                                    if (matrix[j][k + 1] == -2) {
                                        matrix[j][k + 1] = -3;
                                    }
                                }
                            }
                        }
                    }
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < column; j++) {
                            if (matrix[i][j] == -2) {
                                System.out.print('O');
                            }
                            if (matrix[i][j] == -3) {
                                System.out.print('.');
                            }
                        }
                        System.out.println();
                    }

                }
            }
        }

    }

}