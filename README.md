Recursion Depth Control:
- MergeSort: Regular binary splitting, but insertion sort cutoff (n < 15) prevents deep recursion on small arrays
- QuickSort: Always recurse on smaller partition first, then iterate on larger - guarantees O(log n) stack depth
- QuickSelect: Recurses only into needed side, uses insertion sort for n ≤ 10
- Closest Pair: Standard binary splitting, base cases for n ≤ 3

 Memory Allocation Control:
- MergeSort: Single buffer allocated once and reused for all merge operations
- QuickSort: Fully in-place partitioning, no extra arrays
- QuickSelect: In-place median-of-medians, minimal temporary storage
- Closest Pair: Creates temporary strips during conquer phase, but sizes are O(n)

Recurrence Analysis

MergeSort
Recurrence: T(n) = 2T(n/2) + O(n)  
Method: Master Theorem Case 2  
Result: Θ(n log n)  
The work is split equally into two subproblems with linear merge cost. Master Theorem Case 2 applies directly since the work at each level is balanced and the merge is linear.

QuickSort
Recurrence: T(n) = T(k) + T(n-k-1) + O(n) where k is pivot position  
Method: Akra-Bazzi intuition for expected case  
Result: Expected Θ(n log n)  
With random pivot, partitions are usually balanced (k ≈ n/2). Akra-Bazzi handles the probabilistic split sizes. Worst case O(n²) occurs with bad pivots but randomization makes this negligible.

Deterministic Select
Recurrencea: T(n) ≤ T(n/5) + T(7n/10) + O(n)  
Method: Master Theorem-like analysis  
Result: Θ(n)  
Median-of-medians guarantees the pivot eliminates at least 30% of elements. The recurrence solves to linear time because the subproblem sizes decrease geometrically.

Closest Pair
Recurrence: T(n) = 2T(n/2) + O(n)  
Method: Master Theorem Case 2  
Result: Θ(n log n)  
Split into two halves recursively, then linear-time strip check. The 7-neighbor rule in the strip ensures linear work during conquer phase.
