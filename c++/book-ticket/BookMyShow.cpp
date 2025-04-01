
#include <vector>
#include <array>
#include <iostream>
#include "BookMyShow.hpp"

using namespace std;


void BookMyShow::build(const int i, const int p, const int q) { // NOLINT(*-no-recursion)
    if (p == q) {
        stree[i] = {m, m};
        return;
    }
    const int r = (p + q) / 2;
    stree[i] = {m, static_cast<long long>(q - p + 1)*m};
    build(2*i+1, p, r);
    build(2*i+2, r+1, q);
}

vector<int> BookMyShow::query_max(const int i, const int p, const int q, const int k, const int maxRow) { // NOLINT(*-no-recursion)
    if (p > maxRow)
        return {};
    if (stree[i][0] < k)
        return {};
    if (p == q)
        return {p, static_cast<int>(m - stree[i][0])};
    const int r = (p + q) / 2;
    vector<int> ret = query_max(2*i+1, p, r, k, maxRow);
    if (!ret.empty())
        return ret;
    return query_max(2*i+2, r+1, q, k, maxRow);
}

void BookMyShow::update_max(const int i, const int p, const int q, const int row, const int k) { // NOLINT(*-no-recursion)
    if (p > row || q < row)
        return;
    if (p == q) {
        stree[i][0] -= k;
        stree[i][1] -= k;
        return;
    }
    const int r = (p + q) / 2;
    stree[i][1] -= k;
    update_max(2*i+1, p, r, row, k);
    update_max(2*i+2, r+1, q, row, k);
    stree[i][0] = max(stree[2*i+1][0], stree[2*i+2][0]);
}

long long BookMyShow::query_sum(const int i, const int p, const int q, const int maxRow) { // NOLINT(*-no-recursion)
    if (p > maxRow)
        return 0;
    if (q <= maxRow)
        return stree[i][1];
    const int r = (p + q) / 2;
    return query_sum(2*i+1, p, r, maxRow) + query_sum(2*i+2, r+1, q, maxRow);
}

void BookMyShow::update_sum(int i, int p, int q, int k, int maxRow) { // NOLINT(*-no-recursion)
    if (p > maxRow)
        return;
    if (p == q) {
        stree[i][0] -= k;
        stree[i][1] -= k;
        return;
    }
    int r = (p + q) / 2;
    stree[i][1] -= k;
    if (r+1 > maxRow || stree[2*i+1][1] >= k) {
        update_sum(2*i+1, p, r, k, maxRow);
    } else {
        k -= stree[2*i+1][1]; // NOLINT(*-narrowing-conversions)
        update_sum(2*i+1, p, r, stree[2*i+1][1], maxRow); // NOLINT(*-narrowing-conversions)
        update_sum(2*i+2, r+1, q, k, maxRow);
    }
    stree[i][0] = max(stree[2*i+1][0], stree[2*i+2][0]);
}

BookMyShow::BookMyShow(int n_in, int m_in) {
    n = n_in;
    m = m_in;

    int sz = 1;
    while (sz < n*2)
        sz <<= 1;
    stree.resize(sz);

    build(0, 0, n-1);
}

vector<int> BookMyShow::gather(const int k, const int maxRow) {
    vector<int> ret = query_max(0, 0, n-1, k, maxRow);
    if (!ret.empty())
        update_max(0, 0, n-1, ret[0], k);
    return ret;
}

bool BookMyShow::scatter(const int k, const int maxRow) {
    long long cnt = query_sum(0, 0, n-1, maxRow);
    bool ret = cnt >= k;
    if (ret)
        update_sum(0, 0, n-1, k, maxRow);
    return ret;
}

string BookMyShow::as_string(const vector<int> &result) {
    string res;
    for (const int i: result) {
        res += to_string(i) + " ";
    }
    return res;
}



int main() {
    BookMyShow bookShow = BookMyShow(2, 5);
    const vector<int> result = bookShow.gather(4, 0);

    cout << "gather " << BookMyShow::as_string(result) << endl;
    return 0;
}
