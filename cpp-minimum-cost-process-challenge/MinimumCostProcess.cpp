#include <climits>
#include <vector>
#include "MinimumCostProcess.hpp"

using namespace std;

int MinimumCostProcess::calculate(int cores, vector<int> tasks) {
    int size = tasks.size();
    vector<int> frequency(size, 0);

    // Counting the frequency of all tasks
    // Using These frequencies later to determine which task type is least likely to appear again in the future
    // when it needs to replace a running task on a core.
    for (int i = 0; i < size; i++) {
        frequency[tasks[i]] += 1;
    }

    // isRunning[i] denotes whether task is currently running in one of the cores.
    // At the beginning no tasks are running so all values are false.
    vector<bool> isRunning(size, false);
    int cost = 0;
    int occupiedCores = 0;

    for (int i = 0; i < size; i++) {
        int task = tasks[i];

        // Case 1: if same type of task is currently running cost for this is 0.
        if (isRunning[task]) {
            continue;
        }

        // case 1: if there is at least one free core then assign this
        // task to that core at a cost of 1 unit.
        if (occupiedCores < cores) {
            cost += 1;
            occupiedCores += 1;
            isRunning[task] = true;
        }

        // case 2: No core is free
        else {
            // Here we will first find the minimum frequency among all the ongoing tasks in the future.
            // We have to find out which of these will rehappen last among the all ongoing tasks.

            int minimum = INT_MAX;
            int minimumIndex = 0;

            // Find the minimum frequency task type(minimumIndex) and frequency(minimum).
            for (int j = 0; j < size; j++) {
                if (isRunning[j] && minimum > frequency[j]) {
                    minimum = frequency[j];
                    minimumIndex = j;
                }
            }

            isRunning[minimumIndex] = false;
            isRunning[task] = true;
            cost += 1;
        }
    }

    return cost;
}

