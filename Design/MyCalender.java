package Design;

import java.util.ArrayList;
import java.util.List;


/*
 * 
 * 				My Calender 1 Leetcode 729 Medium
 * 
You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendar class:

MyCalendar() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 

Example 1:

Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]

Explanation
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
*/
class MyCalendar {
	List<List<Integer>> lis;

	public MyCalendar() {
		lis = new ArrayList<>();
	}

	public boolean book(int st, int ed) {
		boolean bool = lis.stream()
				.anyMatch(n -> ((n.get(0) >= st && n.get(0) < ed) || (st >= n.get(0) && st < n.get(1))
						|| (ed > n.get(0) && ed <= n.get(1)) || (n.get(1) > st && n.get(1) <= ed)));

		if (!bool)
			return false;

		List<Integer> ls = new ArrayList<>();
		ls.add(st);
		ls.add(ed);
		lis.add(ls);

		return true;
	}
}