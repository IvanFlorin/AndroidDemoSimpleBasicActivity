package com.example.icondor.androiddemosimplebasicactivity;

/**
 * Created by icondor on 02/03/2018.
 */
import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;


public class SingleListPersons {

    private static SingleListPersons m;

    // singleton, so a single instance per JVM
    public static SingleListPersons getInstance() {

        if (m == null) {
            m = new SingleListPersons();
            m.addInTheListOfNames("maria");
            m.addInTheListOfNames("cristina");
            m.addInTheListOfNames("corina");
        }
        return m;
    }


    private List<String> listofNames = new ArrayList<>();

    public void addInTheListOfNames(String s) {
        listofNames.add(s);
    }


    public List getListOfNames() {
        return listofNames;
    }

//    public List searchListOfNames(String name) {
//        List<String> matches = listofNames.stream().filter(it -> it.contains(name)).collect(Collectors.toList());
//        return matches;
//    }
}