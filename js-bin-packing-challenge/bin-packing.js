
class BinPacking {

    calculate(weight, capacity) {
        let usedBins = 0;
        let remaining = capacity;

        // Place items one by one
        for (let i = 0; i < weight.length; i++) {
            // If this item can't fit in current bin
            if (weight[i] > remaining) {
                usedBins++;
                remaining = capacity - weight[i];
            } else {
                remaining = remaining - weight[i];
            }
        }

        return usedBins;
    }
}

module.exports = {BinPacking}