
class Dictionary:
    def replace(self, input_text, input_dict):
        buffer = ""
        result = input_text
        startIndex = 0
        endIndex = 0

        for i, c in enumerate(input_text):
            if (c == "$"):
                buffer = c
                startIndex = i
            elif len(buffer) > 0:
                if c == "$" or c == " " or len(input_text) == i + 1:
                    if buffer in input_dict:
                        value = input_dict.get(buffer)
                        result = result[:startIndex] + value + result[i:]
                    print(buffer)
                    buffer = ""
                else:
                    buffer += c

        return result

def main():
    print(Dictionary().replace("My $name$is $name $lastname", {"$name": "Inacio", "$lastname": "Klassmann"}))

if __name__ == "__main__":
    main()


