/*
An underground railway system is keeping track of customer travel times between different stations. They are using this data to calculate the average time it takes to travel from one station to another.

Implement the UndergroundSystem class:

void checkIn(int id, string stationName, int t)
A customer with a card ID equal to id, checks in at the station stationName at time t.
A customer can only be checked into one place at a time.
void checkOut(int id, string stationName, int t)
A customer with a card ID equal to id, checks out from the station stationName at time t.
double getAverageTime(string startStation, string endStation)
Returns the average time it takes to travel from startStation to endStation.
The average time is computed from all the previous traveling times from startStation to endStation that happened directly, meaning a check in at startStation followed by a check out from endStation.
The time it takes to travel from startStation to endStation may be different from the time it takes to travel from endStation to startStation.
There will be at least one customer that has traveled from startStation to endStation before getAverageTime is called.
You may assume all calls to the checkIn and checkOut methods are consistent. If a customer checks in at time t1 then checks out at time t2, then t1 < t2. All events happen in chronological order.

 

Example 1:

Input
["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]

Output
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]

Explanation
UndergroundSystem undergroundSystem = new UndergroundSystem();
undergroundSystem.checkIn(45, "Leyton", 3);
undergroundSystem.checkIn(32, "Paradise", 8);
undergroundSystem.checkIn(27, "Leyton", 10);
undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
undergroundSystem.getAverageTime("Paradise", "Cambridge"); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
undergroundSystem.checkIn(10, "Leyton", 24);
undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000
undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
*/

class UndergroundSystem {
    
    // this records id--> stationName, time
    private HashMap<Integer, Checkin> hash1 = new HashMap<Integer, Checkin>();
    
    // this records startStation EndStationPair --> total time, total frequencies
    private HashMap<String, TimeCount> hash2 = new HashMap<String, TimeCount>();
    public UndergroundSystem() {

    }
    //use a hashmap to store id --> pair(station name, time)
    public void checkIn(int id, String stationName, int t) {
        hash1.put(id, new Checkin(stationName, t));
    }
    //use previous hashmap to get the stationName and time for checking in using current id
    //use a hashmap to store the stationStart stationEnd pair and time + frequency pair
    public void checkOut(int id, String stationName, int t) {
        if (!hash1.containsKey(id)) return;
        Checkin pair = hash1.get(id);
        String stationPair = pair.stationName + "->" + stationName;
        if (hash2.containsKey(stationPair)) {
            TimeCount timeCount = hash2.get(stationPair);
            // here it needs to add new values instead of adding in itself
            timeCount.time += t - pair.checkinTime;
            timeCount.count += 1;
            hash2.put(stationPair, timeCount);
        } else {
            hash2.put(stationPair, new TimeCount(t-pair.checkinTime), 1);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String stationPair = startStation + "->" + endStation;
        if (!hash2.containsKey(stationPair)) return -1;
        return hash2.get(stationPair).totalTime/hash2.get(stationPair).count;
    }
    
    class Checkin {
        String stationName;
        int checkinTime;
        public Checkin(String stationName, int checkinTime) {
            this.stationName = stationName;
            this.checkinTime = checkinTime;
        }
    }
    //eg. 
    class TimeCount {
        int totalTime;
        int count;
        public TimeCount(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
        
    }
}
