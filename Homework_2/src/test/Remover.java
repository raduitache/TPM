package test;

import lists.List;

import java.io.BufferedWriter;
import java.io.IOException;

public class Remover implements Runnable{

    private List list;
    private BufferedWriter writer;

    public Remover(List list, BufferedWriter writer){
        this.list = list;
        this.writer = writer;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 100000; i+= 2){
            list.remove(i);
        }
        try {
            writer.write("Remove time: " + ((double)(System.currentTimeMillis() - startTime)) / 50000 + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
