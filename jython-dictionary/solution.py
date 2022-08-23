
class Solution:
    def solve(self, input_text, input_dict):
        buffer = ""
        result = ""

        for c in input_text:
            if (c == "$"):
                buffer = c
            elif len(buffer) > 0:
                if c == "$" or c == " ":
                    if buffer in input_dict:
                        value = input_dict.get(buffer)
                        result = result.replace(buffer, value)
                    buffer = ""
                else:
                    buffer += c

            print(buffer)
        return result

def main():
    print("Hello World!")
    print(Solution().solve("My $name$is $name $lastname", {"$name": "Inacio", "$lastname": "Klassmann"}))

if __name__ == "__main__":
    main()


