const std = @import("std");
const myzql = @import("myzql");
const globals = @import("globals.zig");
const ArrayList = std.ArrayList;
const ResultSet = myzql.result.ResultSet;
const TextResultRow = myzql.result.TextResultRow;
const ResultRowIter = myzql.result.ResultRowIter;
const TextElemIter = myzql.result.TextElemIter;


pub fn list() !ArrayList([]const u8) {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    const allocator = gpa.allocator();
    var buffer = try ArrayList([]const u8).initCapacity(allocator, 100);
    defer buffer.deinit();

    _ = try globals.db_connection.query("use todo");
    const query_res = try globals.db_connection.queryRows("select * from grocery");
    const rows: ResultSet(TextResultRow) = try query_res.expect(.rows);
    const rows_iter: ResultRowIter(TextResultRow) = rows.iter();
    while (try rows_iter.next()) |row| {
        var elems_iter: TextElemIter = row.iter();
        while (elems_iter.next()) |elem| {
            if (elem != null) {
                _ = try buffer.append(elem.?);
                std.debug.print("{?s} ", .{elem});
            }
        }
    }

    return buffer;
}

pub fn add(id: []const u8) ![]const u8 {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    const allocator = gpa.allocator();
    const insert = try std.fmt.allocPrint(allocator, "insert into grocery (id) values ({s})", .{id});

    _ = try globals.db_connection.query("use todo");
    _ = try globals.db_connection.query(insert);

    return id;
}