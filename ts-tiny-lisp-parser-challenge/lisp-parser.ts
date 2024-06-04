export class LispParser {
    knownFunctions = ["print", "echo"]
    closeOpen: Map<String, String> = new Map([
        [")", "("],
        ["]", "["],
        ["}", "{"]
    ])


    isValidCloseOpen(text: String): Boolean {
        const chars = [...text]
        const stack: String[] = []
        const validOpenChars = [...this.closeOpen.values()]

        for (let char of chars) {
            if (this.closeOpen.has(char)) {
                if (stack.length > 0 && stack[stack.length - 1] == this.closeOpen.get(char)) {
                    stack.pop()
                } else {
                    return false
                }
            } else {
                const isValidOpenChar = validOpenChars.filter(value => value == char).length > 0
                if (isValidOpenChar) {
                    stack.push(char)
                }
            }
        }

        return stack.length == 0
    }

    isValidText(content: String): Boolean {
        if (!this.isValidCloseOpen(content)) {
            return false
        }

        const validOpenChars = [...this.closeOpen.values()]
        const validCloseChars = [...this.closeOpen.keys()]
        let word = ""

        for (let char of content) {
            const isValidOpenChar = validOpenChars.filter(value => value == char).length > 0
            const isValidCloseChar = validCloseChars.filter(value => value == char).length > 0

            if (word.length > 0 && (char == " " || isValidCloseChar)) {
                let knownFunction = this.knownFunctions
                    .filter(value => word == value)
                    .length > 0

                if (!knownFunction && word[0] != "\"" && word[word.length - 1] != "\"") {
                    return false
                }
                word = ""
            } else if (!isValidOpenChar && !isValidCloseChar) {
                word += char
            }
        }

        return true
    }
}
