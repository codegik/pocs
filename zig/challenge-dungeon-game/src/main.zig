const testing = std.testing;
const std = @import("std");
const math = std.math;
const print = std.debug.print;
const Allocator = std.mem.Allocator;

pub fn calculateMinimumHP(allocator: Allocator, dungeon: []const []const i32) !i32 {
    if (dungeon.len == 0 or dungeon[0].len == 0) {
        return 1;
    }

    const m = dungeon.len;
    const n = dungeon[0].len;

    var dp = try createZeroMatrix(allocator, m + 1, n + 1);
    // dp[m - 1][n - 1] = 1;
    dp[m][n - 1] = 1;
    dp[m - 1][n] = 1;

    // Fill the DP table from bottom-right to top-left
    var i: usize = m;
    while (i > 0) : (i -= 1) {
        var j: usize = n;
        while (j > 0) : (j -= 1) {
            const ii = i - 1;
            const jj = j - 1;
            const min_next = @min(dp[i][jj], dp[ii][j]);
            dp[ii][jj] = @max(1, min_next - dungeon[ii][jj]);
        }
    }

    return dp[0][0];
}

fn createZeroMatrix(allocator: Allocator, rows: usize, cols: usize) ![]([]i32) {
    const matrix = try allocator.alloc([]i32, rows);
    errdefer allocator.free(matrix);

    for (matrix) |*row| {
        row.* = try allocator.alloc(i32, cols);
        @memset(row.*, 0);
    }
    return matrix;
}


test "test n = 4, k = 14" {
    var gpa = std.heap.ArenaAllocator.init(std.heap.page_allocator);
    defer _ = gpa.deinit();
    const allocator = gpa.allocator();

    const dungeon = [_][]const i32{
        &[_]i32{ -2,  -3,  3 },
        &[_]i32{ -5, -10,  1 },
        &[_]i32{ 10,  30, -5 },
    };

    const result = try calculateMinimumHP(allocator, &dungeon);
    const expected: i32 = 7;
    const assertion = std.mem.eql(i32, result, &expected);
    try testing.expect(assertion);
}

