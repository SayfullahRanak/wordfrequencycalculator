/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ranak.frequencygenerator;

/**
 *
 * @author ranak
 */
import java.io.File;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sun.misc.Sort;

/**
 * Example program to list links from a URL.
 */
public class Main{
    
    Map map;
    
    public Main() {
        this.map = new HashMap();
    }
    
    
    public static void main(String[] args) throws IOException {
        Main mn = new Main();
        int mk = 0;
        List<Dataset> data = new ArrayList<Dataset>();
        
        // get the file absolute path
        File [] fileArray =  { new File("./dataset/a.html"),
                          new File("./dataset/b.html"),
                            new File("./dataset/c.html"),
                        new File("./dataset/d.html"),new File("./dataset/e.html"),new File("./dataset/f.html"),
                        new File("./dataset/g.html"),new File("./dataset/h.html"),new File("./dataset/i.html"),
                        new File("./dataset/j.html"),new File("./dataset/k.html"),new File("./dataset/l.html"),
                        new File("./dataset/m.html"),new File("./dataset/n.html"),new File("./dataset/o.html"),
                        new File("./dataset/p.html"),new File("./dataset/q.html"),new File("./dataset/r.html"),
                        new File("./dataset/s.html"),new File("./dataset/t.html"),new File("./dataset/u.html"),
                        new File("./dataset/x.html"),new File("./dataset/y.html"),
                        new File("./dataset/z.html"),new File("./dataset/aa.html"),new File("./dataset/ab.html"),
                        new File("./dataset/ac.html"),new File("./dataset/ad.html"),new File("./dataset/ae.html"),
                        new File("./dataset/af.html"),new File("./dataset/ag.html"),new File("./dataset/ah.html"),
                        new File("./dataset/ai.html"),new File("./dataset/aj.html"),new File("./dataset/ak.html"),
                        new File("./dataset/al.html"),new File("./dataset/am.html"),new File("./dataset/an.html"),
                        new File("./dataset/ao.html"),new File("./dataset/ap.html"),new File("./dataset/ar.html"),
                        new File("./dataset/as.html"),new File("./dataset/at.html"),};
        int i = 0;
        for(File file : fileArray) {
            // parse and save as jsoup Document
            Document doc = Jsoup.parse(file, "UTF-8", "https://somewhereinblog.net/");
            //Document doc = Jsoup.connect("www.facebook.com").get();

            //System.out.println(doc.toString());

            // get all elements of doc
            Elements elements = doc.select("p");
            //System.out.println(elements.toString());

            //System.out.println( elements.html().toString() );

            
            ArrayList list = new ArrayList();
            
            for(Element tag : elements) {
                String str = tag
                                .getElementsByAttributeValue("style", "\"text-align: left; line-height: 1.8em\"")
                                .text()
                                .toString();

                if(!str.isEmpty()) {
                    //System.out.println(str+"\n\n");
                    String [] ss = str.split("[ ♣১২৩৪৫৬৭৮৯০,<.>?।/:;'‘’\"-_=+`~1!2@3#4$5%6^7&8*9(0){}\\|]");
                    for(int in=0; in<ss.length; in++) {
                        if(!ss[in].isEmpty()) {
                            int k=0;
                            
                            for(k=0;k<data.size();k++)
                            {
                                
                                if(data.get(k).isSame(ss[in]))
                                {
                                    data.get(k).push();
                                    break;                                    
                                }
                            }
                            if(k==data.size()) data.add(new Dataset(ss[in]));
                            
                            
                            // check if the value is already in map or not
                            if( !mn.map.containsValue(ss[in]) ) {
                                // not in map
                                // now put the string into map
                                mn.map.put(mk++, ss[in]);
                            }
                            
                            
                            //System.out.println(ss[in]+"\n");
                            i++;
                        }
                    }
                }
            }
            
            
//            for(int k=0;k<data.size();k++)
//            {
//                System.out.print(k+" ");
//                data.get(k).print();
//            }
            
            System.out.println("\n\n\ntotal words found: " + i);
            System.out.println("pushed into map: " + mn.map.size() + "\n");
        }
        
        Collections.sort(data, new Comparator<Dataset>() {
            @Override
            public int compare(Dataset lhs, Dataset rhs) 
            {  
              return Integer.signum(rhs.frequency-lhs.frequency);  
            }
        });

        for(Dataset tdata : data) {
            tdata.print();
        }
    }
}