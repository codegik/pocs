import unittest

from temperatures import daily_temperatures
from temperatures import analyze_temperatures


class Test(unittest.TestCase):

    def test_four(self):
        temperatures = daily_temperatures([49, 49, 48, 70])
        expected = [3, 2, 1, -1]
        assert temperatures == expected

    def test_eight(self):
        temperatures = daily_temperatures([73, 74, 75, 71, 69, 72, 76, 73])
        expected = [1, 1, 4, 2, 1, 1, -1, -1]
        assert temperatures == expected

    def test_four2(self):
        temperatures = daily_temperatures([30, 40, 50, 60])
        expected = [1, 1, 1, -1]
        assert temperatures == expected

    def test_three(self):
        temperatures = daily_temperatures([30, 60, 90])
        expected = [1, 1, -1]
        assert temperatures == expected

    def test_ric(self):
        temperatures = daily_temperatures([1, 2, 3, 85, 1, 2])
        expected = [1, 1, 1, -1, 1, -1]
        analyze_temperatures([1, 2, 3, 85, 1, 2])
        assert temperatures == expected
