import {LispParser} from "./lisp-parser";

test('testing is valid closeOpen', () => {
    const parser = new LispParser()
    expect(parser.isValidCloseOpen("()[]{}")).toBe(true);
    expect(parser.isValidCloseOpen("((()))")).toBe(true);
    expect(parser.isValidCloseOpen("([(()))")).toBe(false);
    expect(parser.isValidCloseOpen("[]{()}]]")).toBe(false);
})

test('testing is valid text', () => {
    const parser = new LispParser()
    expect(parser.isValidText("(print (echo (echo \"1\")))")).toBe(true);
    expect(parser.isValidText("(print \"1\")")).toBe(true);
    expect(parser.isValidText("clojure (print (echo (echo \"1\")))")).toBe(false);
})

