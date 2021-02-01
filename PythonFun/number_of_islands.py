def dfs(grid, r, c):
    if r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0]) or grid[r][c] == 0:
        return
    grid[r][c] = 0
    dfs(grid, r, c - 1)
    dfs(grid, r, c + 1)
    dfs(grid, r - 1, c)
    dfs(grid, r + 1, c)


def num_islands(grid):
    count = 0
    for row in range(len(grid)):
        for col in range(len(grid[0])):
            if grid[row][col] == 1:
                count += 1
                dfs(grid, row, col)
    return count


matrix = [[1, 1, 0, 0, 0], [1, 1, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 1, 1]]
print(f"{num_islands(matrix)} count")
