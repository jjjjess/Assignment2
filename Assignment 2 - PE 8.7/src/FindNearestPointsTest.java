import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class FindNearestPointsTest {

  public static double distanceBetweenPoints(double x1, double y1, double z1, double x2, double y2,
      double z2) {
    return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)) + ((z2 - z1) * (z2 - z1)));
  }

  @Test
  void testDistanceBetweenPoints() {
    double actual = distanceBetweenPoints(1, 1, 1, 2, 2, 2);
    double expected = Math.sqrt(3);
    assertEquals(actual, expected, 0.00001);

    double actual1 = distanceBetweenPoints(-1, -2, -3, -4, -5, -6);
    double expected1 = 5.196152;
    assertEquals(actual1, expected1, 0.00001);

    double actual2 = distanceBetweenPoints(22, 33, 44, 67, 200, 4);
    double expected2 = 177.52183;
    assertEquals(actual2, expected2, 0.00001);

  }

  @Test
  void testInputArray() {
    Scanner test;
    double[][] actualArray;
    double[][] expectedArray;

    test = new Scanner("2   1 1 1   2 2 2");
    actualArray = FindNearestPoints.inputArray(test);
    expectedArray = new double[][] {{1, 1, 1}, {2, 2, 2}};
    assertArrayEquals("failed", actualArray, expectedArray);

    test = new Scanner("5   39 39 876   97 27 54   100 22 54   87 -1 65    44 77 99");
    actualArray = FindNearestPoints.inputArray(test);
    expectedArray =
        new double[][] {{39, 39, 876}, {97, 27, 54}, {100, 22, 54}, {87, -1, 65}, {44, 77, 99}};
    assertArrayEquals("failed", actualArray, expectedArray);
  }

  @Test
  void testClosestPoints() {
    Scanner test;
    double[][] actualArray;
    double[][] expectedArray;

    test = new Scanner("2   1 1 1   2 2 2");
    actualArray = FindNearestPoints.inputArray(test);
    expectedArray = new double[][] {{1, 1, 1}, {2, 2, 2}};
    assertArrayEquals("failed", actualArray, expectedArray);

    test = new Scanner("5   39 39 876   97 27 54   100 22 54   87 -1 65    44 77 99");
    actualArray = FindNearestPoints.inputArray(test);
    expectedArray =
        new double[][] {{39, 39, 876}, {97, 27, 54}, {100, 22, 54}, {87, -1, 65}, {44, 77, 99}};
    assertArrayEquals("failed", actualArray, expectedArray);
  }
}
