const std = @import("std");
const myzql = @import("myzql");
const Conn = myzql.conn.Conn;

pub const db_connection: myzql.conn.Conn = db_init();

pub fn db_init() !myzql.conn.Conn {
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

    std.debug.print("type of conn {?s} ", @typeInfo(@TypeOf(conn)));

    return conn;
}

