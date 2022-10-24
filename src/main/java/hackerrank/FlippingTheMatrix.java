package hackerrank;

class FlippingTheMatrix {
 
    static int maxSum(int mat[][]) {
        int sum = 0;
        final int total = mat.length;
        final int middle = total / 2;
        final int maxPossible = total-1;
          
        for (int i = 0; i < middle; i++) {
            for (int j = 0; j < middle; j++) {
                
                System.out.println(i + " " + j);
                
                System.out.println(mat[i][j] + " " + mat[maxPossible-i][j]);
                
                System.out.println(mat[maxPossible-i][maxPossible-j] + " " + mat[i][maxPossible-j]);
                
                sum += Math.max(
                              Math.max(mat[i][j], mat[maxPossible-i][j]),
                            Math.max(mat[maxPossible-i][maxPossible-j], mat[i][maxPossible-j])
                            );
                
                System.out.println("#####");
            }
        }
        return sum;
    }
 
// Driven Program
    public static void main(String[] args) {
        int mat[][] = {
            {112, 42, 83, 119},
            {56, 125, 56, 49},
            {15, 78, 101, 43},
            {62, 98, 114, 108}
        };
        
        final StringBuilder str = new StringBuilder();
        for(int i = 0; i < mat.length; i++){
            
            str.setLength(0);
            for(int j = 0; j < mat[i].length; j++){
                str.append(mat[i][j]).append(" ");
            }
            System.out.println(str.toString());
        }
        System.out.println("#####");
 
        System.out.println(maxSum(mat));
 
    }
}
