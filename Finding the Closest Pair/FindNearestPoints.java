import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FindNearestPoints {
    public static void main(String[] args) throws FileNotFoundException {
        int numberOfPoints;
        double[][] points;
        File file = new File("Finding the Closest Pair\\input.txt");
        Scanner input  = new Scanner(file);

        numberOfPoints = Integer.parseInt(input.nextLine().split(" ")[0]);
        points = new double[numberOfPoints][2];
        
        int index = 0;
        while(input.hasNextLine()) {
            String[] line = input.nextLine().split(" ");
            points[index][0] = Double.parseDouble(line[0]);
            points[index++][1] = Double.parseDouble(line[1]);
        }
        input.close();
        for (double[] row: points) {
            System.out.println(row[0] +","+ row[1]);
        }
        int p1 = 0, p2 = 0;
        double shortestDistance = distance(points[0][0], points[0][1], points[1][0], points[1][1]);

        for (int i =0; i<numberOfPoints; i++) {
            for (int j=i+1; j < numberOfPoints; j++) {
                double distance  = distance(
                    points[i][0], points[i][1], points[j][0], points[j][1]);
                    if (distance < shortestDistance) {
                        shortestDistance = distance;
                        p1 = i;
                        p2 = j;
                    }
            }
        }
        System.out.println(
            "The Closest two points are ("+ points[p1][0] +", "+ points[p1][1] +") & ("+
            points[p2][0] +", "+ points[p2][1] +")"
        );
    }

    public static double distance(
        double x1, double y1, double x2, double y2) {
            return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    
}