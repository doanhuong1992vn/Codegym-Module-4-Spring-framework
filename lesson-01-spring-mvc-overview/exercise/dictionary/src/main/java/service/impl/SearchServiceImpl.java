package service.impl;

import service.ISearchService;

import java.lang.reflect.Array;
import java.util.Arrays;


public class SearchServiceImpl implements ISearchService {
    private static final String[] vietnamese = {"chuối", "sách", "máy tính"};
    private static final String[] english = {"banana", "book", "computer"};

    @Override
    public String search(String word) {
        for (int i = 0; i < english.length; i++) {
            if (english[i].equals(word)) {
                return vietnamese[i];
            }
        }
        return "Không tìm thấy";
    }
}
