package br.ufrn.imd.util;

import java.util.HashMap;
import java.util.Map;

public class NumberThreads {
    public Map<Integer,Integer> QTD_THREADS;

    public NumberThreads(){
        this.QTD_THREADS = new HashMap<>();
        QTD_THREADS.put(1,10);
        QTD_THREADS.put(2,100);
        QTD_THREADS.put(3,300);
        QTD_THREADS.put(4,500);
        QTD_THREADS.put(5,800);
        QTD_THREADS.put(6,1000);
        QTD_THREADS.put(7,1500);
    }

    public Map<Integer, Integer> getQTD_THREADS() {
        return QTD_THREADS;
    }
}
