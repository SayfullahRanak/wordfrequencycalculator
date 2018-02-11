/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ranak.frequencygenerator;

/**
 *
 * @author ranak
 */
public class Dataset {
    String data;
    int frequency;
    // store dataset
    public Dataset(String data)
    {
        this.data=data;
        this.frequency = 1;
    }
    //increase frequence
    public void push()
    {
        frequency++;
    }
    // check string is already here
    public boolean isSame(String str) {
        return this.data.equals(str);
    }
    
    public void print()
    {
        System.out.println("Data : "+data+", Frequency : "+frequency);
        
    }
}
