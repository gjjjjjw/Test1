package com.Test;


import java.util.ArrayList;
import java.util.Iterator;

public class controller {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("2");
        Iterator<String> iterator = strings.iterator();

        while (iterator.hasNext()){
            String next = iterator.next();
            if ("2".equals(next)){
                iterator.remove();
            }
        }

        System.out.println(strings);
    }

}
  