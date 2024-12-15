package Arrays;

import java.util.PriorityQueue;

/*
 * 			Leetcode Medium 1792. Maximum Average Pass Ratio
 * 
There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.

You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.

The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.

Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.
*/public class MaxAvgPass {
	
	public double maxAverageRatio(int[][] classes, int extraStudents) {
	    
	    PriorityQueue<T> maxHeap =
	        new PriorityQueue<>((a, b) -> Double.compare(b.extraPassRatio, a.extraPassRatio));

	    for (int[] c : classes) {
	      final int pass = c[0];
	      final int total = c[1];
	      maxHeap.offer(new T(getExtraPassRatio(pass, total), pass, total));
	    }

	    for (int i = 0; i < extraStudents; ++i) {
	      final int pass = maxHeap.peek().pass;
	      final int total = maxHeap.poll().total;
	      maxHeap.offer(new T(getExtraPassRatio(pass + 1, total + 1), pass + 1, total + 1));
	    }

	    double ratioSum = 0;

	    while (!maxHeap.isEmpty())
	      ratioSum += maxHeap.peek().pass / (double) maxHeap.poll().total;

	    return ratioSum / classes.length;
	  }

	  
	  private double getExtraPassRatio(int pass, int total) {
	    return (pass + 1) / (double) (total + 1) - pass / (double) total;
	  }

	  private record T(double extraPassRatio, int pass, int total){};

}
