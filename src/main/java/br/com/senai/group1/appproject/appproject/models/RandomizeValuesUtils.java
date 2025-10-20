package br.com.senai.group1.appproject.appproject.models;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizeValuesUtils {

    public static int[] randomUnrepeatedPosition(int limit)
    {
        int[] numberList = new int[limit];

        for (int i = 0; i < limit; i++)
        {
            numberList[i]=(i + 1);
        }

        Random random = new Random();

        int[] newList = new int[numberList.length];

        boolean alreadyRegistered;
        int randomizedPosition = -1;
        int valueToRegister = -2;

        List<Integer> indexUnregistered;
        int[] indexUnregisteredList;

        while (valueToRegister != -1)
        {
            indexUnregistered = new ArrayList<>();
            valueToRegister = -1;

            for (int i = 0; i < newList.length; i++)
            {
                if (newList[i] < 1)
                {
                    indexUnregistered.add(i);
                }
            }

            int lastNumber1 = -1;
            int lastNumber2 = -1;
            for (int number : numberList)
            {
                alreadyRegistered = false;
                lastNumber1 = number;
                for (int i : newList)
                {
                    lastNumber2 = i;
                    if (number == i)
                    {
                        alreadyRegistered = true;
                        break;
                    }
                }

                if(alreadyRegistered == false)
                {
                    valueToRegister = number;
                    break;
                }
            }


            while(valueToRegister != -1)
            {
                randomizedPosition = random.nextInt(numberList.length);

                if (newList[randomizedPosition] < 1)
                {
                    newList[randomizedPosition] = valueToRegister;
                    break;
                }
            }

        }

        return newList;
    }

    public static Pos randomizePosEnumValue() {
        Pos[] posList = Pos.values();
        Random random = new Random();
        int selectedValue = random.nextInt(posList.length);

        return posList[selectedValue];
    }

    public static HPos randomizeHPosEnumValue() {
        HPos[] posList = HPos.values();
        Random random = new Random();
        int selectedValue = random.nextInt(posList.length);

        return posList[selectedValue];
    }
    public static VPos randomizeVPosEnumValue() {
        VPos[] posList = VPos.values();
        Random random = new Random();
        int selectedValue = random.nextInt(posList.length);



        return posList[selectedValue];
    }
}
