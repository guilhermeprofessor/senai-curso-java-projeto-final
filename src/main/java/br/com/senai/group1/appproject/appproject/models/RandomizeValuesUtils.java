package br.com.senai.group1.appproject.appproject.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizeValuesUtils {

    public static int[] RandomUnrepeatedPosition(int limit)
    {
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < limit; i++)
        {
            numberList.add(i + 1);
        }

        Random random = new Random();

        int[] newList = new int[numberList.size()];

        boolean alreadyRegistered;
        int randomizedPosition = -1;
        int valueToRegister = -2;

        List<Integer> indexUnregistered;

        while (valueToRegister != -1)
        {
            alreadyRegistered = false;
            indexUnregistered = new ArrayList<>();
            valueToRegister = -1;

            for (int i = 0; i < newList.length; i++)
            {
                if (newList[i] < 1)
                {
                    indexUnregistered.add(i);
                }
            }

            for (int number : numberList)
            {
                for (int i : newList)
                {
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
                randomizedPosition = random.nextInt(numberList.size());

                if (newList[randomizedPosition] < 1)
                {
                    newList[randomizedPosition] = valueToRegister;
                    break;
                }
            }

        }

        return newList;
    }
}
