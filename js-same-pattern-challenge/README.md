### Randori #4 - Same Pattern 

<img src="https://grupoopciones.com/wp-content/uploads/2022/06/CARRO-TUCAN.png" width="200" height="200"> 
<img src="https://www.freep.com/gcdn/presto/2018/11/22/PDTF/b120b7c5-4840-419d-ac89-762fe852b7e3-112218_thanksgivingparade-7.jpg" width="200" height="200"> 
<img src="https://miro.medium.com/v2/resize:fit:960/1*ryExn-1cPqA9NqdF_bWRyQ.jpeg" width="200" height="200"> 
<img src="https://i.imgflip.com/4pdjvi.jpg?a474576" width="200" height="200"> 

Many countries have parades. Usa was a famous thanks given parade in NY. Mexico has the day of the dead parade. 
Brazil perhaps is the country with the biggest parade of all, called "carnaval". Multiple days of fun. 
People used to say in Brazil that the year only starts after the "carnaval". 

Brazil "carnaval" historically its origins can be traced to the Portuguese Age of Discoveries when their caravels passed regularly through Madeira island, a territory which already celebrated emphatically its carnival season, and where they were loaded with goods but also people and their ludic and cultural expressions. 
Clearly we have a multi-country trillion dollars parade business opportunity here. 

We could create building bocks to create the first Carnaval-as-a-service(CaaS). 

One of the offers can be generic parade cars (A float is a decorated platform, either built on a vehicle like a truck or towed behind one) that can be re-used across countries. 
IF we can re-use, we can re-sell, if we can re-sell we can borrow/land money for such reason. 

Company decided to create the first Truck-Parade-Loan (TPL), in order to operate such offer, we will be creating a platform where people can describe they cars and re-sell it or even ask for a loan to rent or by a parade car. 
Since it's a multi-country biz we need to be able to know if the car is the same or not. 

In order to know if a car is equal we need to ignore all decoration and look for the structure, here is an example: 

``` 
+ LEVEL("brown") 
    - LEVEL("white") 
+ LEVEL("blue") 
    - LEVEL("blue") 
+ LEVEL("brown") 
    - LEVEL("green") 
        - LEVEL("yellow") 
``` 

Giving 3 cars or more, could you tell is they have the same structure pattern? 

### Restrictions 
``` 
1. No String comparisons are allowed.
2. You need to be able to replicate the car structure as it is. 
3. No Arrays, Lists, Maps are allowed 
```
