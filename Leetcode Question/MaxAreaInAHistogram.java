import java.util.*;
public class MaxAreaInAHistogram {

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int nsl[] = new int[heights.length];
        int nsr[] = new int[heights.length];

        // next smaller right
        Stack<Integer> s = new Stack<>();
        for (int i = heights.length-1; i >= 0; i--) {
            // step -1
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) { // remove greater element
                s.pop();
            }

            // step -2
            if (s.isEmpty()) { // means I don't have next smaller right element
                nsr[i] = heights.length; // as I don't have next smaller right element, I'll store the length of the heights array
            }else{
                nsr[i] = s.peek();
            }

            // step -3 
            s.push(i);
        }

        // next smaller left

         s = new Stack<>();    // empty stack
        for (int i = 0; i < heights.length; i++) { // as I want next smaller left, I've to traverse from left
            // step -1
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) { // remove greater element
                s.pop();
            }

            // step -2
            if (s.isEmpty()) { // means I don't have next smaller left element
                nsl[i] = -1; // as I don't have next smaller left element, I'll store -1 in heights array
            }else{
                nsl[i] = s.peek();
            }

            // step -3 
            s.push(i);
        }

        /*calculate max area = height * width (nsr[i] - nsl[i] -1) 
        we are not including next smaller right/left, we need only the distance btw right & left smaller element
         */ 
        for (int i = 0; i < heights.length; i++) {
            // each time I'll get height & width
            int area = 0;
            int height = heights[i];
            int width = nsr[i] - nsl[i] -1; // j-i-1

            // calculating area
            area = height*width;
            maxArea = Math.max(area, maxArea);  // comparing with maxArea
        }


        return maxArea;
    }
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    
}
