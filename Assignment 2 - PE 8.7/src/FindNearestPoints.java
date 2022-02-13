// **********************************************
// Student Name: Jesse Tripp
// COSC 211
// Assignment 2 - Programming Exercise 8.7
// **********************************************

import java.util.Scanner;

public class FindNearestPoints {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double[][] points = inputArray(input);
    int[] closestIndices = closestPoints(points);
    int p1 = closestIndices[0];
    int p2 = closestIndices[1];
    displayClosestPoints(p1, p2, points);
  }

  /** Compute the distance between two points (x1, y1) and (x2, y2) */
  // added z1, z2 and updated math
  public static double distanceBetweenPoints(double x1, double y1, double z1, double x2, double y2,
      double z2) {
    return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)) + ((z2 - z1) * (z2 - z1)));
  }

  public static void displayClosestPoints(int p1, int p2, double[][] points) {
    // Display result
    System.out.println("The closest two points are " + "(" + points[p1][0] + ", " + points[p1][1]
        + ", " + points[p1][2] + ") and (" + points[p2][0] + ", " + points[p2][1] + ", "
        + points[p2][2] + ")"); // added points[X][2]
  }

  public static double[][] inputArray(Scanner input) {
    System.out.print("Enter the number of points: ");
    int numberOfPoints = input.nextInt();

    // Create an array to store points
    double[][] points = new double[numberOfPoints][3]; // changed from [2] to [3]
    System.out.print("Enter " + numberOfPoints + " points: ");
    for (int i = 0; i < points.length; i++) {
      points[i][0] = input.nextDouble();
      points[i][1] = input.nextDouble();
      points[i][2] = input.nextDouble(); // added line for 3rd point
    }
    return points;
  }

  public static int[] closestPoints(double[][] points) {
    // p1 and p2 are the indices in the points array
    int p1 = 0, p2 = 1; // Initial two points
    double shortestDistance = distanceBetweenPoints(points[p1][0], points[p1][1], points[p1][2],
        points[p2][0], points[p2][1], points[p2][2]); // Initialize shortest distance - added
                                                      // points[X][2]

    // Compute distance for every two points
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        double distance = distanceBetweenPoints(points[i][0], points[i][1], points[i][2],
            points[j][0], points[j][1], points[j][2]); // Find distance - added points[X][2]

        if (shortestDistance > distance) {
          p1 = i; // Update p1
          p2 = j; // Update p2
          shortestDistance = distance; // Update shortestDistance
        }
      }
    }
    return new int[] {p1, p2};
  }
}
