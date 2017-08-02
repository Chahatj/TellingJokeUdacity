package com.udacity.gradle.builditbigger.tests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

/**
 * Created by chahat on 1/8/17.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskResultAndroidTest extends AndroidTestCase {

    @Test
    public void setTestTask(){
        final CountDownLatch latch = new CountDownLatch(1);
        Context context = InstrumentationRegistry.getContext();
        MainActivity.AsyncTaskBackend task = new MainActivity.AsyncTaskBackend() {
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                assertEquals("new Joke",result);
                latch.countDown();
            }
        };
        task.execute(context);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
