import java.util.LinkedList;
import java.util.List;

class SpiralTraversalMatrix{
    int [][] mat_A = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    public void solution(){
        try{

            int n = this.mat_A.length;
            int colStart = 0;
            int colEnd = n-1;
            int rowStart= 0;
            int rowEnd = n-1;
            int direction = 0;      // l-r-> 0, t-b-> 1, r-l-> 2, b-t ->3 

            List<Integer> output= new LinkedList<>();

            while(rowStart<n){
                System.out.println(output);
                if (direction==0){      // traversing to the left to top 
                    for (int i=rowStart, j = colStart ; j <= colEnd; j++){
                        output.add(this.mat_A[i][j]);
                    }
                    rowStart++;                    
                }
                else if (direction==1){     // traversing to the top to bottom
                    for (int i=rowStart, j=colEnd; i <= rowEnd; i++){
                        output.add(this.mat_A[i][j]);
                    }
                    colEnd--;
                }else if (direction==2){     // traversing to the right to left
                    for (int i=rowEnd, j=colEnd; j >= colStart; j--){
                        output.add(this.mat_A[i][j]);
                    }
                    rowEnd--;
                }
                else if (direction ==3){    // traversing to the bottom to top
                    for (int i=rowEnd, j=colEnd; i >= colStart; i--){
                        output.add(this.mat_A[i][j]);
                    }
                    colStart++;
                }else{      // unknown direction
                    throw new Exception("Unknown direction!");
                }
                direction = (direction+1)%4;

            }

        }catch(Exception e){
            System.out.println("Exception in solution: "+e);
            return ;
        }

    }

    public static void main(String[] argc){
        System.out.println("********** Spiral Traversal of Matrix ***********");
        SpiralTraversalMatrix instance  = new SpiralTraversalMatrix();
        instance.solution();
    }
}