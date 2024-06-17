### Challenge - Weather Report 

The Babylonians, who lived in Mesopotamia from the 18th to the 6th century BCE, could track the movements of celestial bodies. 
They believed that the positions of stars and planets could help predict weather patterns. 
The Babylonians also developed a system of dividing the sky into twelve equal parts, which they called the zodiac. 
Besides, they studied cloud formations, wind patterns, and the behavior of animals. 
Weather is the state of the atmosphere, describing for example the degree to which it is hot or cold, wet or dry, calm or stormy, clear or cloudy.

On Earth, most weather phenomena occur in the lowest layer of the planet's atmosphere, the troposphere, just below the stratosphere. 
Like the Babylonians we would like to do some weather predictions. 

Given a SET of temperatures like this: 
```
[49,49,49,49,48,48,48,32,33,37,70]

``` 
Given any Z position on the set, tell us when it will be warm in Fahrenheit. 

How many days after the Z day? Calculate same math for all elements on the set, if you cant get any warmer day the result should be -1; 
since you are doing computations pls also tell if majority of theys are warm or not and how % of cold/warm days we have in the forecast? 
Could we predict if will rain or not? 

### Restrictions 
``` 
1. No Set can be used! 
2. No Celsius are allowd it should be all about fahrenheit. 
3. No While loops.
 ```

### Running
```
python -m unittest
```

### Tips
- Daily Temperature problem
- Fahrenheit consider warm is 85 and above.
  - the solution is missing a condition (if t > 85)
  - solution need to calculate the % starting in Z and t > 85 over all elements
  - solution need to i start on Z
- Set is a list not a set.
- Last question cannot be coded.


