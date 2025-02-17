const std = @import("std");
const myzql = @import("myzql");
const ArrayList = std.ArrayList;
const Conn = myzql.conn.Conn;
const ResultSet = myzql.result.ResultSet;
const TextResultRow = myzql.result.TextResultRow;
const ResultRowIter = myzql.result.ResultRowIter;
const TextElemIter = myzql.result.TextElemIter;


fn init() !myzql.conn.Conn {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    const allocator = gpa.allocator();
    defer {
        switch (gpa.deinit()) {
            .ok => {},
            .leak => std.log.err("memory leak detected", .{}),
        }
    }

    var conn = try Conn.init(allocator, &.{ .username = "root", .password = "password" });
    defer conn.deinit();
    try conn.ping();
    {
        const qr = try conn.query("create database if not exists todo");
        _ = try qr.expect(.ok);
    }
    {
        const qr = try conn.query("use todo");
        _ = try qr.expect(.ok);
    }
    {
        const qr = try conn.query("create table if not exists grocery(id varchar(36) primary key)");
        _ = try qr.expect(.ok);
    }

    return conn;
}

pub fn list() !ArrayList([]const u8) {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    const allocator = gpa.allocator();
    var buffer = try ArrayList([]const u8).initCapacity(allocator, 100);
    defer buffer.deinit();

    _ = try init();
    var conn = try Conn.init(allocator, &.{ .username = "root", .password = "password" });

    {
        _ = try conn.query("use todo");
        const query_res = try conn.queryRows("select * from grocery");
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
    }

    return buffer;
}

pub fn add(id: []const u8) ![]const u8 {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    const allocator = gpa.allocator();
    var conn = try Conn.init(allocator, &.{ .username = "root", .password = "password" });

    {
        const insert = try std.fmt.allocPrint(allocator, "insert into grocery (id) values ({s})", .{id});
        _ = try conn.query("use todo");
        _ = try conn.query(insert);
    }

    return id;
}