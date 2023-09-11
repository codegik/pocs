export class BeautifulDays {
  count(start: number, end: number, divisor: number): number {
    let countDays = 0;

    for (let i = start; i <= end; i++) {
      const number = i + 0;
      const reversed = this.reverse(number);

      if (((i - reversed) / divisor) % 1 == 0) {
        countDays++;
      }
    }

    return countDays;
  }

  reverse(number: number): number {
    let reversed = 0;

    while (number != 0) {
      const digit = number % 10;
      reversed = reversed * 10 + digit;
      number = Math.trunc(number / 10);
    }

    return reversed;
  }
}
