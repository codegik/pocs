const {SamePattern, Structure} = require('./same-pattern');

test('3 cars are equal', () => {
    const pattern = new SamePattern()
    const car1 = new Structure(5, new Structure(7), new Structure(9))
    const car2 = new Structure(5, new Structure(7), new Structure(9))

    expect(pattern.areEqual(car1, car2)).toBe(true);
})

test('3 cars are different', () => {
    const pattern = new SamePattern()
    const car1 = new Structure(5, new Structure(7, new Structure(7)), new Structure(9))
    const car2 = new Structure(3, new Structure(7, new Structure(7)), new Structure(9))
    const car3 = new Structure(3, new Structure(7), new Structure(9))

    expect(pattern.areEqual(car1, car2)).toBe(false)
    expect(pattern.areEqual(car2, car3)).toBe(false)
})

