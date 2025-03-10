const std = @import("std");
const testing = std.testing;

// How many permutations we have for number 3? 6
// How many permutations we have for number 4? 24
// How many permutations we have for number 5? 120

// comptime key word: the value passed to that function parameter must be known at compile time
pub fn getPermutation(comptime n: usize, k: usize) ![]usize {
    // Allocate memory
    var numbers = std.ArrayList(usize).init(std.heap.page_allocator);

    // Release all allocated memory.
    defer numbers.deinit();

    // n is comptime, it means the compiler knows the value and allow to declarate an array with a specific size
    var factorial: [n + 1]usize = undefined;

    // Allocate and release memory
    var result = std.ArrayList(usize).init(std.heap.page_allocator);
    defer result.deinit();

    // create an array of factorial lookup
    var sum: usize = 1; // store the sum of the factorial, 1! = 1, 2! = 2, 3! = 6, 4! = 24
    var i: usize = 1; // factorials must start in 1
    factorial[0] = 1;
    while (i <= n) : (i += 1) {
        sum *= i;
        // store all the factorials
        factorial[i] = sum;
        // store all the number of factorial
        try numbers.append(i);
    }

    var k_mut = k - 1; // things start on index 0, if you want 14th element, you need to subtract 1
    i = 1;
    while (i <= n) : (i += 1) {
        // k = 14, n = 4
        // k/(n-1)! = 13/(4-1)! = 13/3! = 13/6 = 2
        // The array {1, 2, 3, 4} has a value of 3 at index 2. So the first number is a 3.
        // find the index of the number to append
        const index = k_mut / factorial[n - i];
        const number = numbers.items[index];
        try result.append(number);
        _ = numbers.orderedRemove(index);
        // next iteration will get the next factorial, so we need to update the mut
        k_mut -= index * factorial[n - i];
    }

    // create new array and free the memory
    return result.toOwnedSlice();
}



test "test n = 3, k = 1" {
    const result = try getPermutation(3, 1);
    const expected = [_]usize{1, 2, 3};
    const assertion = std.mem.eql(usize, result, &expected);
    try testing.expect(assertion);
}

test "test n = 3, k = 2" {
    const result = try getPermutation(3, 2);
    const expected = [_]usize{1, 3, 2};
    const assertion = std.mem.eql(usize, result, &expected);
    try testing.expect(assertion);
}

test "test n = 3, k = 3" {
    const result = try getPermutation(3, 3);
    const expected = [_]usize{2, 1, 3};
    const assertion = std.mem.eql(usize, result, &expected);
    try testing.expect(assertion);
}

test "test n = 4, k = 9" {
    const result = try getPermutation(4, 9);
    const expected = [_]usize{2, 3, 1, 4};
    const assertion = std.mem.eql(usize, result, &expected);
    try testing.expect(assertion);
}

test "test n = 4, k = 14" {
    const result = try getPermutation(4, 14);
    const expected = [_]usize{3, 1, 4, 2};
    const assertion = std.mem.eql(usize, result, &expected);
    try testing.expect(assertion);
}

