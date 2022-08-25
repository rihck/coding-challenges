package main.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*
    https://leetcode.com/problems/my-calendar-i/
 */
public class MyCalendar1 {

    public static void main(String[] args) {
        MyCalendar1 myCalendar = new MyCalendar1();

        myCalendar.bookLogNsolution(10, 20); // return True
        myCalendar.bookLogNsolution(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
        myCalendar.bookLogNsolution(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.

        System.out.println(myCalendar);
    }

    TreeMap<Integer, Integer> map;

    public MyCalendar1() {
        map = new TreeMap();
    }

    public boolean bookLogNsolution(int start, int end) {
        Integer smallerKey = map.floorKey(start), greaterKey = map.ceilingKey(start);

        if (smallerKey == null || map.get(smallerKey) <= start) {
            if (greaterKey == null || greaterKey >= end) {
                map.put(start, end);
                return true;
            }
        }
        return false;
    }

    ///////// O(n) solution

    class MyCalendar {

        List<Event> events;

        public MyCalendar() {
            events = new ArrayList<>();
        }

        public boolean bookOsolution(int start, int end) {
            if (events.isEmpty()) {
                events.add(new Event(start, end));
                return true;
            }

            boolean book = true;

            for (Event event : events) {
                if ((start > event.getStart() && start < event.getEnd()) ||
                        (end > event.getStart() && end < event.getEnd()) ||
                        (start >= event.getStart() && end >= event.getStart() && end <= event.getEnd()) ||
                        (start <= event.getStart() && end > event.getStart())) {
                    return false;
                }
            }

            events.add(new Event(start, end));
            return true;
        }
    }

    class Event {

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }

        private int start;
        private int end;

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }



}
