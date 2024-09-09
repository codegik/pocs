import {LargeNumber} from "./largenumber";

test("test case 1", () => {
    const largeNumber = new LargeNumber()
    const num1 = "654154154151454545415415454"
    const num2 = "63516561563156316545145146514654"
    const expected = "41549622603955309777243716069997997007620439937711509062916"

    expect(expected).toBe(largeNumber.multiply(num1, num2));
});

test("test case 2", () => {
    const largeNumber = new LargeNumber()
    const num1 = "4154"
    const num2 = "51454"
    const expected = "213739916"

    expect(expected).toBe(largeNumber.multiply(num1, num2));
});

test("test case 3", () => {
    const largeNumber = new LargeNumber()
    const num1 = "41540"
    const num2 = "51454"
    const expected = "2137399160"

    expect(expected).toBe(largeNumber.multiply(num1, num2));
});

test("test case 4", () => {
    const largeNumber = new LargeNumber()
    const num1 = "10"
    const num2 = "10"
    const expected = "0100"

    expect(expected).toBe(largeNumber.multiply(num1, num2));
});
