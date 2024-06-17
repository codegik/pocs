from typing import List


class Pair:

    def __init__(self, temperature=0, index=0):
        self.temperature = temperature
        self.index = index


def daily_temperatures(temperatures: List[int]) -> List[int]:
    length = len(temperatures)
    result = [-1] * length
    stack = []

    for i in range(length):
        t = temperatures[i]
        while stack and t > stack[-1].temperature:
            pair = stack.pop()
            result[pair.index] = i - pair.index
        stack.append(Pair(t, i))

    return result


def analyze_temperatures(temperatures):
    days_until_warmer = daily_temperatures(temperatures)
    print(days_until_warmer)

    warm_days_threshold = 85
    warm_days_count = sum(1 for temp in temperatures if temp > warm_days_threshold)
    cold_days_count = len(temperatures) - warm_days_count

    warm_percentage = (warm_days_count / len(temperatures)) * 100
    cold_percentage = (cold_days_count / len(temperatures)) * 100

    is_majority_warm = warm_days_count > cold_days_count
    majority_status = "warm" if is_majority_warm else "cold"

    print(f"Is majority {majority_status}")
    print(f"Percent warm {warm_percentage:.2f}")
    print(f"Percent cold {cold_percentage:.2f}")
