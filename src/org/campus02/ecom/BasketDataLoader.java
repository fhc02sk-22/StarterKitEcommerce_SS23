package org.campus02.ecom;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BasketDataLoader {

    public static ArrayList<BasketData> load(String path) throws DataFileException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            ArrayList<BasketData> list = new ArrayList<>();
            String line = br.readLine(); // Kopfzeile wird gelesen und ignoriert

            if (line == null)
                return null;

            System.out.println("Kopfzeile (ignore it): " + line);

            while ((line = br.readLine()) != null){
                if (line.isEmpty())
                    continue;

                BasketData bd = new Gson().fromJson(line, BasketData.class);
                list.add(bd);
            }
            return list;
        } catch (FileNotFoundException e) {
            throw new DataFileException(path, e);
        } catch (IOException e) {
            throw new DataFileException(path, e);
        }
    }
}
