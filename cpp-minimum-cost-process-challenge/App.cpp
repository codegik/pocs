#include "MinimumCostProcess.hpp"
#include <iostream>
#include <vector>

using namespace std;

int main() {
    MinimumCostProcess mcp;

    // Test case 1
    {
        int cores = 3;
        vector<int> tasks = {1, 2, 1, 3, 4, 1};
        int expected = 4;
        int result = mcp.calculate(cores, tasks);
        cout << "Test case 1: " << (result == expected ? "Passed" : "Failed") 
                  << " (Expected: " << expected << ", Got: " << result << ")" << endl;
    }

    // Test case 2
    {
        int cores = 2;
        vector<int> tasks = {1, 2, 1, 3, 2, 1};
        int expected = 4;
        int result = mcp.calculate(cores, tasks);
        cout << "Test case 2: " << (result == expected ? "Passed" : "Failed") 
                  << " (Expected: " << expected << ", Got: " << result << ")" << endl;
    }

    // Test case 3
    {
        int cores = 3;
        vector<int> tasks = {7, 11, 17, 10, 7, 10, 2, 9, 2, 18, 8, 10, 20, 10, 3, 20, 17, 17, 17, 1, 15, 10, 8, 3, 3, 18, 13, 2, 10, 10, 11};
        int expected = 21;
        int result = mcp.calculate(cores, tasks);
        cout << "Test case 3: " << (result == expected ? "Passed" : "Failed") 
                  << " (Expected: " << expected << ", Got: " << result << ")" << endl;
    }

    // Test case 4
    {
        int cores = 2;
        vector<int> tasks = {1, 1, 1, 1, 1, 1};
        int expected = 1;
        int result = mcp.calculate(cores, tasks);
        cout << "Test case 4: " << (result == expected ? "Passed" : "Failed") 
                  << " (Expected: " << expected << ", Got: " << result << ")" << endl;
    }

    // Test case 5
    {
        int cores = 2;
        vector<int> tasks = {1, 1, 2, 1, 1, 1};
        int expected = 2;
        int result = mcp.calculate(cores, tasks);
        cout << "Test case 5: " << (result == expected ? "Passed" : "Failed") 
                  << " (Expected: " << expected << ", Got: " << result << ")" << endl;
    }

    // Test case 6
    {
        int cores = 2;
        vector<int> tasks = {1, 2, 3, 4, 5, 6};
        int expected = 6;
        int result = mcp.calculate(cores, tasks);
        cout << "Test case 6: " << (result == expected ? "Passed" : "Failed") 
                  << " (Expected: " << expected << ", Got: " << result << ")" << endl;
    }

    // Test case 7
    {
        int cores = 2;
        vector<int> tasks = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6};
        int expected = 6;
        int result = mcp.calculate(cores, tasks);
        cout << "Test case 7: " << (result == expected ? "Passed" : "Failed") 
                  << " (Expected: " << expected << ", Got: " << result << ")" << endl;
    }

    // Test case 8
    {
        int cores = 2;
        vector<int> tasks = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2};
        int expected = 8;
        int result = mcp.calculate(cores, tasks);
        cout << "Test case 8: " << (result == expected ? "Passed" : "Failed") 
                  << " (Expected: " << expected << ", Got: " << result << ")" << endl;
    }

    return 0;
}
