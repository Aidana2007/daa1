Learning Goals
- Practice implementing classic divide-and-conquer algorithms.
- Learn safe recursion patterns (avoiding stack overflows).
- Analyze running-time recurrences using Master Theorem and Akra-Bazzi intuition.
- Collect and compare simple metrics (time, recursion depth, comparisons).
- Communicate results in a short report and maintain a clean Git history.

Implemented algorithms:
1. MergeSort (Case 2 of Master Theorem)
- Linear merge with a reusable buffer.
- Uses insertion sort for small subarrays (cut-off ~15).
- Expected complexity: (nlogn).

2. QuickSort 
- Randomized pivot selection.
- Recurse on the smaller partition, iterate over the larger → recursion depth ≈ O(log n).
- Expected complexity: O(nlogn), worst-case O(n²) avoided by randomization.

3. Deterministic Select (Median of Medians)
- Groups of 5, median-of-medians pivot.
- Only recurse into the needed side, always the smaller side.
- Complexity: O(n).

4. Closest Pair of Points (2D)
- Sort by x-coordinate, recursive split.
- Uses strip check sorted by y (7–8 neighbour rule).
- Complexity: O(nlogn).

Recurrence Analysis:
- MergeSort: T(n) = 2T(n/2) + Θ(n) → Θ(n log n).
- QuickSort: T(n) = T(k) + T(n−k−1) + Θ(n), average Θ(n log n).
- Select: T(n) = T(n/5) + T(7n/10) + Θ(n) → Θ(n).
- Closest Pair: T(n) = 2T(n/2) + Θ(n) → Θ(n log n).

Summary
- Theory and measurements mostly agree.
- QuickSort faster in practice despite worse worst-case.
- Deterministic Select is slower on small n but scales linearly as predicted.
