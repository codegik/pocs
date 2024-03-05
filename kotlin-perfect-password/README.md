### Randori Dojo - Perfect Pass

<img src="https://www.judo-ch.jp/english/dictionary/terms/rantori/image-mfi/img01.gif" width="200" height="200">
<img src="https://eu-images.contentstack.com/v3/assets/blt66983808af36a8ef/blt713fe7bac809f87a/60d966c85e51ad3b1d20cecf/083526_671638.jpg" width="200" height="200">
<img src="https://us.123rf.com/450wm/bsd555/bsd5552101/bsd555210101952/162513429-video-game-rules-rgb-color-icon-video-game-design-components-restricting-user-from-accessing-wrong.jpg?ver=6" width="200" height="200">
<img src="https://media.istockphoto.com/id/1032869448/vector/creative-thinking.jpg?s=612x612&w=0&k=20&c=0PdDG2ZdoHlLLWZoHykWFgNFBSXz6KwIWMCyyztMzyM=" width="200" height="200">
<img src="https://www.homestructions.com/yesorno/yesornobutton.png" width="200" height="200">

Entropy is central to the second law of thermodynamics, which states that the entropy of an isolated system left to spontaneous evolution cannot decrease with time. As a result, isolated systems evolve toward thermodynamic equilibrium, where the entropy is highest. A consequence of the second law of thermodynamics is that certain processes are irreversible. WAT? Keep reading...

Password entropy is important because it measures password randomness and unpredictability — the greater the entropy, the more effective the password is against all types of cyberattacks.
One of the most common types of targeted cyberattack is a brute force attack in which cybercriminals try all possible character combinations to discover your password. Sometimes they use dictionaries of common passwords (like “qwerty” or “123456”) to break into password-protected computers, accounts, and networks — this strategy is better known as a dictionary attack.

Passwords are complicated, the famous 123deoliveira4 is bad, we need to do better, we can and we will. But in order to do better we need to be creative sometimes.Our company decided to increase the security for endusers. We are tasked with project to create the perfect password validator. We need to be able to detect if the password is weak or strong, the cool kids dont call strong passwords anymore, they call perfect pass. We need to write a program that pass all 7 rules of perfect password, so our detector call tell if any password is perfect or not, rules:
```
Rule #1 - The length needs to be 32 bits.
Rule #2 - The character "!" is forbiden.
Rule #3 - The character "_" is forbiden.
Rule #4 - The password need to have at least 2 Capital letters
Rule #5 - The password need to have at least 2 numbers
Rule #6 - The password need to have at exact 2 special chars (#,*,-,$)
Rule #7 - The password need to have the longest substring without repeating chars == 26
```