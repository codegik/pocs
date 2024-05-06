class Structure {
    constructor(color, left, right) {
        this.color = color
        this.left = left
        this.right = right
    }
}

class SamePattern {
    areEqual(structure1, structure2) {
        if (structure1 == null || structure2 == null) {
            return structure1 === structure2
        }

        return structure1.color === structure2.color &&
            this.areEqual(structure1.left, structure2.left) &&
            this.areEqual(structure1.right, structure2.right)
    }
}


module.exports = { Structure, SamePattern }