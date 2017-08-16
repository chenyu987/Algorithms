/**
* Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

a  b  c  d  e

public int maxPoints(Point[] points) {
  int res = 0;
  if (points == null || points.length == 0) return 0;
  for (i = 0; i < points.length; i++) {
    int cnt = 1;
    int duplt = 0;
    Map<Double, Integer> map = new HashMap<>();
    Point cur = Point[i];
    for (j = i + 1; j < points.length; j++) {
      Point other = points[j];
      Double slope = 0.0;
      if (other.y == cur.y && other.x == cur.x) {
        duplit++;
      } else if (other.x == cur.x) {
        slope = Double.MAX_VALUE;
      } else if (other.y == cur.y) {
        slope = 0.0;
      } else {
        slope = (other.y - cur.y) / (double) (other.x - cur.x);
      }
      if (!map.containsKey(slope)) {
        map.put(slope, 2);
      } else {
        map.put(slope, map.get(slope)+1);
      }
      cnt = Math.max(cnt, map.get(slope));
    }
    res = Math.max(res, cnt+duplt);
  }
  return res;
}
