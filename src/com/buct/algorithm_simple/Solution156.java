package com.buct.algorithm_simple;

import java.util.List;

/**
 * 合并区间
 * 给出若干闭合区间，合并所有重叠的部分。
 *
 */
public class Solution156 {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        // first sort
        this.sort(intervals);
        // 接下来进行排序
        for (int i = 0; i < intervals.size() -1; i++) {
            Interval data = intervals.get(i);
            if (data.end >= intervals.get(i + 1).start) {
                // 合并
                data.end = intervals.get(i+1).end > data.end ? intervals.get(i+1).end:data.end;
                intervals.remove(i+1);
                i--;
            }
        }
        return intervals;

    }

    //首先進行排序
    public void sort(List<Interval> intervals){
        for (int i = intervals.size() - 1; i > 0; --i)
        {
            for (int j = 0; j < i; ++j)
            {
                if(intervals.get(j).start>intervals.get(j+1).start){
                    Interval old = new Interval(intervals.get(j).start,intervals.get(j).end);
                    intervals.get(j).end=intervals.get(j+1).end;
                    intervals.get(j).start=intervals.get(j+1).start;
                    intervals.get(j+1).end=old.end;
                    intervals.get(j+1).start=old.start;
                }
            }
        }
    }

    //  Definition of Interval:
    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}