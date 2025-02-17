const std = @import("std");
const ArrayList = std.ArrayList;
const myzql = @import("myzql");
const Conn = myzql.conn.Conn;



fn connection() !myzql.conn.Conn {
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

pub fn list() !ArrayList(u8) {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    const allocator = gpa.allocator();
    var buffer = try ArrayList(u8).initCapacity(allocator, 100);
    defer buffer.deinit();

    _ = try connection();
    var conn = try Conn.init(allocator, &.{ .username = "root", .password = "password" });

    {
        const qr = try conn.query("select * from grocery");
        _ = try qr.expect(.ok);
    }

    return buffer;
}