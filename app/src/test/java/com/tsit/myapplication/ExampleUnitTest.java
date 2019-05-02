package com.tsit.myapplication;

import android.util.Log;

import org.junit.Test;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Random random=new Random();
        System.out.print(random.nextLong()) ;

    }

    @Test public void splitFUN() {
        String a="1121";
        System.out.print(split(a.charAt(0),a.substring(1)));
    }

    public String split(char char1, String sub) {

        if (char1== sub.charAt(0))
            return char1 + "" + (sub.length()>1?split(sub.charAt(0),sub.substring(1)):sub.charAt(0));
        else return char1 + "," + (sub.length()>1?split(sub.charAt(0),sub.substring(1)):sub.charAt(0));

    }
}