import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class MyDictionary implements Serializable {
    private TreeMap<String,String> dict;


    public MyDictionary(TreeMap<String,String> dict){
        this.dict = dict;
    }

    public void addKeyWords(String key,String meaning){
        dict.put(key,meaning);
    }

    public void removeWords(String key){
       dict.remove(key);
    }

    public String lookUpWords(String key){
       return dict.get(key);
    }

    public void printOutKeywords(){
        for (String k: dict.keySet()){
            System.out.println(k+" - "+dict.get(k));
        }
    }

    public int numberOfWords(){
       return dict.size();
    }

    public void clear(){
        dict.clear();
    }

    public void saveWordsToFile(String fileName) throws IOException {
        File f = new File(fileName);
        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(String k : dict.keySet()){
                String w = k + "-" + dict.get(k);
                oos.writeObject(w);
            }
            fos.flush();
            fos.close();
        }catch (IOException e){
            throw new IOException();
        }

    }


    public void readWordsFromFile(String fileName) throws IOException {
        File f = new File(fileName);
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0){
                String s = (String)ois.readObject();
                String[] words = s.split("-");
                dict.put(words[0],words[words.length-1]);
            }
            fis.close();
        }catch (IOException | ClassNotFoundException e){
            throw new IOException();
        }

    }












}
