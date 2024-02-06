###  eSports Judge

<img src="https://www.judo-ch.jp/english/dictionary/terms/rantori/image-mfi/img01.gif" width="200" height="200">
<img src="https://educommunity.minecraft.net/hc/user_images/XVlw09H1ClF9-cr_hHigRg.png" width="200" height="200">
<img src="https://preview.redd.it/ufr2vqmno5161.jpg?width=640&crop=smart&auto=webp&s=f3de636fe2944ad3cfc2968c0d10ec4919e93da1" width="200" height="200">
<img src="https://www.genesislawfirm.com/wp-content/uploads/2020/12/judge-vector-character-cartoon-illustration_MyGD2Jdd_L.png" width="200" height="200">
<img src="https://miro.medium.com/v2/resize:fit:816/0*iQcvmErDo0udSrK3" width="200" height="200">

The company decide to make money offering loans for people to build they super computer, either to mine bitcoins or to just play some videgames. This will be called the eSportsLoan where we will give very good deal for our custtomers. In order to promote the new product line, markething decided to create some twitch party on the internet to make the players(future borrowers) see us a nice eSports frindly company. Marketing team decided to pick Minecraft as the first game to run some promotional party. To spice things a little bit, engineering decided that the players need to build a bot and that bot will have a task in minecraft. The task, that the BOT will need todo will be:
```
Bots need to build a water trap machine. They need to tweack the map and do terraformation in order to elevate the map.
The Bot that creates a map which is capable to retain the biggest volume of water will be the winner.
```
Marketing creates a JIRA ticket(To us) and the story says:
```
Dear engineers,
Please build a Bot system, good luck.
PS: It's for the Minecraft world final event in SF, a sprint from today, it is already done?
```
After calming Gabriel, and hours of slack chat with marketing we understood what we need todo:
We need to rank the robots build in minecraft, Gabriel wrote a plugin in Scala that connects to a minecraft server and reads the 3D map and generates 2D coordinates(elevation in delta pixels) from the map like this:
```
[0,1,0,2,1,0,1,3,2,1,2,1]
```
We will get an array of arrays, one array for each robbot, we need to create a ranking system that tells what is the top 3 robbots.
