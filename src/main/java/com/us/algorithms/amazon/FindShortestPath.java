package com.us.algorithms.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class FindShortestPath {

  /* Problem Name is &&& Train Map &&& PLEASE DO NOT REMOVE THIS LINE. */

  /**
   * Instructions to candidate. 1) Run this code in the REPL to observe its behaviour. The execution
   * entry point is main(). 2) Consider adding some additional tests in doTestsPass(). 3) Implement
   * def shortestPath(self, fromStationName, toStationName) method to find shortest path between 2
   * stations 4) If time permits, some possible follow-ups.
   */

  
  /*
   * Visual representation of the Train map used
   *
   * King's Cross St Pancras --- Angel ---- Old Street | \ | | \ | | \ | Russell Square Farringdon
   * --- Barbican --- Moorgate | / | / | / Holborn --- Chancery Lane --- St Paul's --- Bank
   */

  public static boolean doTestsPass() {
    // todo: implement more tests, please
    // feel free to make testing more elegant
    TrainMap trainMap = new TrainMap();

    trainMap.addStation("King's Cross St Pancras").addStation("Angel").addStation("Old Street")
        .addStation("Moorgate").addStation("Farringdon").addStation("Barbican")
        .addStation("Russel Square").addStation("Holborn").addStation("Chancery Lane")
        .addStation("St Paul's").addStation("Bank");

    trainMap
        .connectStations(trainMap.getStation("King's Cross St Pancras"),
            trainMap.getStation("Angel"))
        .connectStations(trainMap.getStation("King's Cross St Pancras"),
            trainMap.getStation("Farringdon"))
        .connectStations(trainMap.getStation("King's Cross St Pancras"),
            trainMap.getStation("Russel Square"))
        .connectStations(trainMap.getStation("Russel Square"), trainMap.getStation("Holborn"))
        .connectStations(trainMap.getStation("Holborn"), trainMap.getStation("Chancery Lane"))
        .connectStations(trainMap.getStation("Chancery Lane"), trainMap.getStation("St Paul's"))
        .connectStations(trainMap.getStation("St Paul's"), trainMap.getStation("Bank"))
        .connectStations(trainMap.getStation("Angel"), trainMap.getStation("Old Street"))
        .connectStations(trainMap.getStation("Old Street"), trainMap.getStation("Moorgate"))
        .connectStations(trainMap.getStation("Moorgate"), trainMap.getStation("Bank"))
        .connectStations(trainMap.getStation("Farringdon"), trainMap.getStation("Barbican"))
        .connectStations(trainMap.getStation("Barbican"), trainMap.getStation("Moorgate"));

    System.out.println(trainMap.shortestPath("King's Cross St Pancras", "St Paul's"));
    String solution = "King's Cross St Pancras->Russel Square->Holborn->Chancery Lane->St Paul's";
    //String solution = "King's Cross St Pancras->Russel Square->Holborn";

    return solution.equals(TrainMap.convertPathToStringRepresentation(
        trainMap.shortestPath("King's Cross St Pancras", "St Paul's")));
  }

  public static void main(String[] args) {
    if (doTestsPass()) {
      System.out.println("All tests pass");
    } else {
      System.out.println("Tests fail.");
    }
  }

}



/**
 * class Station
 * <p>
 * Respresents Station in the rail network. Each station is identified by unique name. Station is
 * connected with other stations - this information is stored in the 'neighbours' field. Two station
 * objects with the same name are equal therefore they are considered to be same station.
 */
class Station {
  private String name;
  private List<Station> neighbours;

  public Station(String name) {
    this.name = name;
    this.neighbours = new ArrayList<>(3);
  }

  String getName() {
    return name;
  }

  void addNeighbour(Station v) {
    this.neighbours.add(v);
  }

  List<Station> getNeighbours() {
    return this.neighbours;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Station && this.name.equals(((Station) obj).getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name);
  }

  @Override
  public String toString() {
    return this.getName();
  }
}


/**
 * class TrainMap
 * <p>
 * Respresents whole rail network - consists of number of the Station objects. Stations in the map
 * are bi-directionally connected. Distance between any 2 stations is of same constant distance
 * unit. This implies that shortest distance between any 2 stations depends only on number of
 * stations in between
 */
class TrainMap {

  private HashMap<String, Station> stations;
  private List<Station> closestStations;
  public TrainMap() {
    this.stations = new HashMap<>();
  }

  public TrainMap addStation(String name) {
    Station s = new Station(name);
    this.stations.putIfAbsent(name, s);
    return this;
  }

  public Station getStation(String name) {
    return this.stations.get(name);
  }

  public TrainMap connectStations(Station fromStation, Station toStation) {
    if (fromStation == null) {
      throw new IllegalArgumentException("From station is null");
    }
    if (toStation == null) {
      throw new IllegalArgumentException("From station is null");
    }
    fromStation.addNeighbour(toStation);
    toStation.addNeighbour(fromStation);
    return this;
  }

  public List<Station> shortestPath(String from, String to) {
    /*
     * TODO Implement
     */
    Station st1 = this.stations.get(from);
    Station st2 = this.stations.get(to);
    Set<Station> visited = new HashSet<Station>();
    List<Station> result = new ArrayList<Station>();
    if (helper(st1, visited, result, st2)) {
      closestStations.add(st2);
      return closestStations;
    }
    return Collections.emptyList();
  }

  private boolean helper(Station currentS, Set<Station> visitedS, List<Station> stationL,
      Station stationTo) {
    if (currentS == null)
      return false;
    if (visitedS.contains(currentS))
      return false;
    if (currentS.getNeighbours().size() == 0)
      return false;
    if (currentS.equals(stationTo))
      return true;
    visitedS.add(currentS);
    stationL.add(currentS);

    int size = currentS.getNeighbours().size();
    Station s1 = size > 0 ? currentS.getNeighbours().get(size - 1) : null;
    Station s2 = size - 1 > 0 ? currentS.getNeighbours().get(size - 2) : null;
    Station s3 = size - 2 > 0 ? currentS.getNeighbours().get(size - 3) : null;
    if (helper(s1, visitedS, stationL, stationTo) || helper(s2, visitedS, stationL, stationTo)
          || helper(s3, visitedS, stationL, stationTo))
        closestStations = new ArrayList(stationL);
        return true;
  }

  public static String convertPathToStringRepresentation(List<Station> path) {
    if (path.isEmpty()) {
      return "";
    }
    return path.stream().map(Station::getName).reduce((s1, s2) -> s1 + "->" + s2).get();
  }
}
