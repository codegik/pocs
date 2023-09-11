import { BeautifulDays } from "../src/BeautifulDays";

describe('testing beautiful days', () => {
  test('count interval 20 to 23', () => {
    const bd = new BeautifulDays();
    expect(bd.count(20, 23, 6)).toBe(2);
  });
});