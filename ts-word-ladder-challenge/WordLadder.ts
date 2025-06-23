export class WordLadder {
    length(beginWord: string, endWord: string, wordList: string[]): number {
        const words = new Set(wordList);
        if (!words.has(endWord)) return 0;

        const queue: string[] = [];
        queue.push(beginWord);

        const visited = new Set<string>();
        visited.add(beginWord);

        let changes = 1;

        while (queue.length > 0) {
            const size = queue.length;
            for (let i = 0; i < size; i++) {
                const word = queue.shift()!;
                if (word === endWord) return changes;

                for (let j = 0; j < word.length; j++) {
                    for (let k = 97; k <= 122; k++) {
                        const chars = word.split('');
                        chars[j] = String.fromCharCode(k);
                        const newWord = chars.join('');

                        if (words.has(newWord) && !visited.has(newWord)) {
                            queue.push(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            changes++;
        }
        return 0;
    }
}