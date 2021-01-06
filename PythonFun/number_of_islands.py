
class Solution(object):
    def numIslands(self, grid):
        count = 0
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 1:
                    count += 1
                    self.dfs(grid, row, col)


        return count

    def dfs(self, grid, row, col):
        grid[row][col] = 0

        if isValid(row, col-1, len(grid), len(grid[0])) and grid[row][col-1] == 1:
            dfs(self, grid, row, col-1)

        if (isValid(row, col+1) &and grid[row][col+1] == 1):
            dfs(self, grid, row, col-1)

        if (isValid(row-1, col) &and grid[row-1][col] == 1):
            dfs(self, grid, row-1, col-1)

        if (isValid(row+1, col) and grid[row+1][col] == 1):
            dfs(self, grid, row, col-1)


            if (row > 0 && )

    def isValid(self, row, col, rows, cols):
        return row >= 0 and
        row
