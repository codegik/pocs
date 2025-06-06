function findCatalan(n) {
    // Create an array to store Catalan numbers
    let catalanArray = new Array(n + 1).fill(0);
    
    // Base case: C(0) = 1
    catalanArray[0] = 1;
    
    // Calculate Catalan numbers iteratively
    for (let i = 1; i <= n; i++) {
        for (let j = 0; j < i; j++) {
            catalanArray[i] += catalanArray[j] * catalanArray[i - j - 1];
        }
    }
    
    // Return the nth Catalan number
    return catalanArray[n];
}

// Example usage
let n = 6;
let res = findCatalan(n);
console.log(`The ${n}th Catalan number is: ${res}`);

