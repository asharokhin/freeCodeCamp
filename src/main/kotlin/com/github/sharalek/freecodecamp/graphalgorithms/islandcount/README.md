Function isLandCount returns the number of islands on the input grid.

Logic:
Traverse the grid, marking visited positions (convert node indexes into string with some symbol). If found node which is "Land", run search (DFS) on neighbour nodes. 