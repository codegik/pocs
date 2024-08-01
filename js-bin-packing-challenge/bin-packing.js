
class BinPacking {

    calculate(weight, capacity) {
        let usedBins = 0;
        let remaining = capacity;
        let sortedWeight = weight.sort((a, b) => b - a);

        // Place items one by one
        for (let i = 0; i < sortedWeight.length; i++) {
            // If this item can't fit in current bin
            if (sortedWeight[i] > remaining) {
                usedBins++;
                remaining = capacity - sortedWeight[i];
            } else {
                remaining = remaining - sortedWeight[i];
            }
        }

        return usedBins;
    }
}

module.exports = {BinPacking}