package com.example.nobod.listkeyword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.nobod.listkeyword.Adapter.ListKeyWordAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private String[] listKeyWords = {"xiaomi", "bitis hunter", "bts", "balo", "bitis hunter x", "tai nghe", "harry potter", "anker", "iphone", "balo nữ", "nguyễn nhật ánh", "đắc nhân tâm", "ipad", "senka", "tai nghe bluetooth", "son", "maybelline", "laneige", "kem chống nắng", "anh chính là thanh xuân của em"};

    private ArrayList<String> keyWords = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initKeyWords();
    }

    private void initKeyWords() {
        for (String item : listKeyWords) {
            if (countSpaceInChar(item) > 0) {
                item = addNewLineToString(item);
                keyWords.add(item);
            } else {
                keyWords.add(item);
            }
        }
        initRecycleView();
    }

    /**
     * This function use for call Adapter to set data
     */
    private void initRecycleView() {
        Log.d(TAG, "initRecycleView: init data to recycleView");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.list_key_word);
        recyclerView.setLayoutManager(layoutManager);
        ListKeyWordAdapter listKeyWordAdapter = new ListKeyWordAdapter(this, keyWords);
        recyclerView.setAdapter(listKeyWordAdapter);

    }

    /**
     * This function use for count number of space in String
     * @param string
     * @return spaceCount
     */
    private int countSpaceInChar(String string) {
        int spaceCount = 0;
        for (char c : string.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        return spaceCount;
    }

    /**
     * This function use for break new line for string in array
     * @param string
     * @return result
     */
    private String addNewLineToString(String string) {
        String[] listChar = string.split(" ");
        String result = "";
        if (listChar.length == 2) {
            result = listChar[0].toString() + "\n" + listChar[1].toString();
        }
        if (listChar.length > 2) {
            for (int i = 0; i < listChar.length; i++) {
                if (i == 1) {
                    result = result + listChar[i] + "\n";
                } else {
                    result = result + listChar[i] + " ";
                }
            }
        }
        return result;
    }

}
