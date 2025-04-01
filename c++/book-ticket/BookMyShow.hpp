#ifndef BOOKMYSHOW_HPP
#define BOOKMYSHOW_HPP

#include <vector>
#include <string>

using namespace std;


class BookMyShow {
    int n;
    int m;
    vector<array<long long, 2> > stree;

    void build(int i, int p, int q);
    vector<int> query_max(int i, int p, int q, int k, int maxRow);
    void update_max(int i, int p, int q, int row, int k);
    long long query_sum(int i, int p, int q, int maxRow);
    void update_sum(int i, int p, int q, int k, int maxRow);

public:
    BookMyShow(int n, int m);
    vector<int> gather(int k, int maxRow);
    bool scatter(int k, int maxRow);
    static string as_string(const vector<int>& result);
};

#endif