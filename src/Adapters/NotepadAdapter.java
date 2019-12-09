package Adapters;

import com.google.gson.*;
import Model.Equipment;

import java.sql.SQLOutput;

public class NotepadAdapter
{
    public static void main(String[] args)
    {
        Gson gson = new Gson();

        Equipment equipment = new Equipment(true, true, false,true,5,6);

        String file = gson.toJson(equipment);

        System.out.println(file);

        Equipment eq = gson.fromJson(file, Equipment.class);

        System.out.println(eq.getHDMI());
    }
}
