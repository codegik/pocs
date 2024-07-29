const {BinPacking} = require('./bin-packing');

test('test case 1', () => {
    const bin = new BinPacking()
    expect(bin.calculate([2, 5, 4, 7, 1, 3, 8], 10)).toBe(4);
})

test('test case 2', () => {
    const bin = new BinPacking()
    expect(bin.calculate([4, 8, 1, 4, 2, 1], 10)).toBe(2);
})

test('test case 3', () => {
    const bin = new BinPacking()
    expect(bin.calculate([9, 8, 2, 2, 5, 4], 10)).toBe(3);
})

test('test case 4', () => {
    const bin = new BinPacking()
    expect(bin.calculate([2, 5, 4, 7, 1, 3, 8], 10)).toBe(4);
})

test('test case 5', () => {
    const bin = new BinPacking()
    expect(bin.calculate([2, 5, 4, 7, 1, 3, 8], 5)).toBe(5);
})