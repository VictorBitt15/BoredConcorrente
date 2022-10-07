package br.ufrn.imd.service;

import br.ufrn.imd.domain.BoredQuote;
import org.springframework.web.client.RestTemplate;

public class ConsumerBoredThread extends Thread{
    private int ID;
    private RestTemplate restTemplate;
    public ConsumerBoredThread(int ID){
        this.ID=ID;
        this.restTemplate = new RestTemplate();
    }

    public int getID() {
        return ID;
    }

    @Override
    public void run() {
        try{
            BoredQuote boredQuote = this.restTemplate.getForObject(
                    "https://www.boredapi.com/api/activity",BoredQuote.class);
            System.out.println(boredQuote.toString());
        }catch (Exception e){

        }

    }
}
