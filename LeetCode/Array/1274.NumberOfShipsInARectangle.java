/*

(This problem is an interactive problem.)

Each ship is located at an integer point on the sea represented by a cartesian plane, and each integer point may contain at most 1 ship.

You have a function Sea.hasShips(topRight, bottomLeft) which takes two points as arguments and returns true If there is at least one ship in the rectangle represented by the two points, including on the boundary.

Given two points: the top right and bottom left corners of a rectangle, return the number of ships present in that rectangle. It is guaranteed that there are at most 10 ships in that rectangle.

Submissions making more than 400 calls to hasShips will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

Input: 
ships = [[1,1],[2,2],[3,3],[5,5]], topRight = [4,4], bottomLeft = [0,0]
Output: 3
Explanation: From [0,0] to [4,4] we can count 3 ships within the range.
Example 2:

Input: ans = [[1,1],[2,2],[3,3]], topRight = [1000,1000], bottomLeft = [0,0]
Output: 3

*/

/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        int x1 = bottomLeft[0], y1 = bottomLeft[1];
        int x2 = topRight[0], y2 = topRight[1];
        int x3 = (x1 + x2)/2;
        int y3 = (y1 + y2)/2;
        if (x1 == x2 && y1 == y2) return sea.hasShips(topRight, bottomLeft) == true? 1: 0;
        int a=0,b=0,c=0,d=0;
        if (x3>=x1 && y3>=y1 && sea.hasShips(new int[]{x3,y3}, new int[]{x1,y1})) {
            a = countShips(sea, new int[]{x3,y3}, new int[]{x1,y1});
        }
        if (x2>=x3+1 && y3>=y1 && sea.hasShips(new int[]{x2,y3},new int[]{x3+1,y1})) {
            b = countShips(sea, new int[]{x2,y3},new int[]{x3+1,y1});
        }
        if (x3>=x1 && y2>=y3+1 && sea.hasShips(new int[]{x3,y2}, new int[]{x1,y3+1})) {
            c = countShips(sea,new int[]{x3,y2}, new int[]{x1,y3+1});
        }  
        if (x2>=x3+1 && y2>=y3+1 && sea.hasShips(new int[]{x2,y2}, new int[]{x3+1,y3+1})) {
            d = countShips(sea, new int[]{x2,y2}, new int[]{x3+1,y3+1});
        }
        return a+b+c+d;
    }
}

//https://leetcode.com/problems/number-of-ships-in-a-rectangle/discuss/1754239/Java-or-0-ms-or-Divide-and-Conquer-or-Explained
// public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
// 	if (!sea.hasShips(topRight, bottomLeft))
// 		return 0;

// 	var x1 = topRight[0];
// 	var y1 = topRight[1];
// 	var x2 = bottomLeft[0];
// 	var y2 = bottomLeft[1];

// 	if (x1 == x2 && y1 == y2)
// 		return 1;

// 	var midX = (x1 + x2) / 2;
// 	var midY = (y1 + y2) / 2;

// 	return countShips(sea, point(midX, y1), point(x2, midY + 1)) + // Q1: top-left quadrant
// 		   countShips(sea, topRight, point(midX + 1, midY + 1)) +  // Q2: top-right quadrant
// 		   countShips(sea, point(x1, midY), point(midX + 1, y2)) + // Q3: bottom-right quadrant
// 		   countShips(sea, point(midX, midY), bottomLeft);         // Q4: bottom-left quadrant
// }

// private int[] point(int x, int y) {
// 	return new int[]{x, y};
// }
