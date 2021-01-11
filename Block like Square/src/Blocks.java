import java.util.*;

public class Blocks {

    public static int largestBlock(String string) {
        
    	
    	Scanner scanner = new Scanner(string);
    	
    
    	
    	int n = scanner.nextInt();
    	
    	if(n == 0 || n < 0) {
    		return 0;
    	} else if(n == 1) {
    		return 1;
    	}
    	
    	int[][] grid = new int[n][n];
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			grid[i][j] = scanner.nextInt();
    		}
    	}

    	
    	int max = 0;
    	for(int i = 0; i < n; i++) {//1 loop
    		for(int j = 0; j < n ; j++) {// 2 Loop
    			int temp = grid[i][j];
    			int counter = 1;	
    			boolean flag = true;
    			for(int m = 1; m < Math.min(n-i, n-j); m++) {	//   0  1  kontrollieret die 1
    															//   1  1 
    				for(int k = i; k < i+m; k++) {  // une links bis une rechts
    					if(j+m < n && grid[k][j+m] != temp) {
    						flag = false;
    					}
    					
    				}
    				for(int k = j; k < j+m; k++) {  // obe rechts bis une rechts
    					if(i+m < n && grid[i+m][k] != temp) {
    						flag = false;
    					}
    				}
    				
    				
    				if(flag) {
    					counter ++;
    				}
    				
    			}
    			if(grid[i+counter-1][j+counter-1] != temp) {
    				counter--; // de ecke of doom
    			}
    			max = Math.max(max, counter);
    			
    			
    		}
    	}
    	
    	
        return max;
    }
}