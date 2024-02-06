### Billionaires challenge

<img src="https://i.stack.imgur.com/Jteqd.png" width="200" height="200">
<img src="https://blogs.oracle.com/content/published/api/v1.1/assets/CONTBC2E10DFF84B4330B0F2CEF65770C1AF/Medium?format=jpg&channelToken=7e01516d535048508dfbd81a6ea0d1ed
" width="200" height="200">
<img src="https://m.media-amazon.com/images/I/81qy+MXuxDL._AC_UF894,1000_QL80_.jpg" width="200" height="200">


Java 21 is out. People keep joking about java running on 3B devices because the java installer for windows had a image for ever never ever updated(right now is probably 6B or more). Anyway, billions leads us to billionaires, billionaires like to buy companies and we need to make a auditing system that make sure we are not allowing unfair monopolies to happen. You talk to the legal team they give you some complicated formulas, but the worst is that they keep trace of all transactions in a single row and out of order, yes it could not be more chaotic, is just a bunch of numbers like:
```
{ -1, 0, 1, 2, -1, -4 }
{ 0, 1, 1 }
```
Within this numbers there is a 3 entity system, there is the Buyer(B), the Seller(S) and the auditor(A) what legal tells us is, you cant know who is who, for identity protection they say, and you can't know who is the buyer and who is the seller. But they tell you this: when the sell is good, all 3 entity align to ZERO. Meaning, in plain english, if you sum 3 numbers you will get zero which means the transaction was approved. When the transaction is denied the sum is not zero, they have a mix of valid and invalid transactions all together. We told them, okay we can build a system with that... maybe! One advice, this "folks" are not really engineers and they dont not polish the data, I would count on duplicate data. Given a log of transactions{B,S,A,...} tell us how many where allowed in that log?


## Requirements

- Java 21
- Maven 3


## Running
```shell
mvn clean install
```