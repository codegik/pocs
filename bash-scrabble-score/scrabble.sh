#!/opt/homebrew/bin/bash

declare -A letters
letters=(["aeioulnrst"]="1" ["dg"]="2" ["bcmp"]="3" ["fhvwy"]="4" ["k"]="5" ["jx"]="8" ["qz"]="10")


scrabble() {
    words="$@"
    top_score=0
    top_word=""

    for word in $words; do
        score=0
        for (( i=0; i<${#word}; i++ )); do
            letter="${word:$i:1}"
            key=$(echo ${!letters[@]} | grep -o "[^[:space:]]*$letter[^[:space:]]*")
            if [ $key ]; then
                score=$(($score+${letters[$key]}))
            fi
        done

        if [[ $score > $top_score ]]; then
            top_score=$score
            top_word=$word
        fi
    done

    echo "$top_word: $top_score"
}
