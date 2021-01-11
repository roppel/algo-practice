
class NumberOfIslands():



    def dfs(self, grid, r, c):
        if r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0]) or grid[r][c] == 0:
            return
        grid[r][c] = 0
        self.dfs(grid, r, c-1)
        self.dfs(grid, r, c+1)
        self.dfs(grid, r-1, c)
        self.dfs(grid, r+1, c)

    def numIslands(self, grid):
        count = 0
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 1:
                    count += 1
                    self.dfs(grid, row, col)
        print(count, "count")


if __name__ == "__main__":
    grid = [[1,1,0,0,0], [1,1,0,0,0], [0,0,1,0,0],  [0,0,0,1,1]]
    NumberOfIslands().numIslands(grid)

