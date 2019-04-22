package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        ArrayList[] graph = new ArrayList[numCourses];
	        int[] degree = new int[numCourses];
	        Queue<Integer> queue = new LinkedList<Integer>();
	        int count=0;
	        
	        for(int i=0;i<numCourses;i++)
	            graph[i] = new ArrayList();
	            
	        for(int i=0; i<prerequisites.length;i++){
	            degree[prerequisites[i][1]]++;
	            graph[prerequisites[i][0]].add(prerequisites[i][1]);
	        }
	        for(int i=0; i<degree.length;i++){
	            if(degree[i] == 0){
	                queue.add(i);
	                count++;
	            }
	        }
	        
	        while(queue.size() != 0){
	            int course = (int)queue.poll();
	            for(int i=0; i<graph[course].size();i++){
	                int pointer = (int)graph[course].get(i);
	                degree[pointer]--;
	                if(degree[pointer] == 0){
	                    queue.add(pointer);
	                    count++;
	                }
	            }
	        }
	          
	            return count == numCourses;
	    }
}






