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

    // Create a DP table with an extra row and column
    var dp = try allocator.alloc([]i32, m + 1);
    defer allocator.free(dp);

    for (dp) |*row| {
        row.* = try allocator.alloc(i32, n + 1);
        defer allocator.free(row.*);
        @memset(row.*, math.maxInt(i32));
    }

    // Set the "exit" point
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

pub fn main() !void {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    defer _ = gpa.deinit();
    const allocator = gpa.allocator();

    const dungeon = [_][]const i32{
        &[_]i32{ -2, -3, 3 },
        &[_]i32{ -5, -10, 1 },
        &[_]i32{ 10, 30, -5 },
    };

    const result = try calculateMinimumHP(allocator, &dungeon);
    print("Minimum initial health: {}\n", .{result});
}

// test "test n = 4, k = 14" {
//     const result = try getPermutation(4, 14);
//     const expected = [_]usize{3, 1, 4, 2};
//     const assertion = std.mem.eql(usize, result, &expected);
//     try testing.expect(assertion);
// }

