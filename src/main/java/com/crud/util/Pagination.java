
package com.crud.util;

import java.util.ArrayList;
import java.util.List;

public class Pagination {
    private final static long beginPage = 1;
    private final static int itemsLimit = 10;
    private final static int offset = 2;
    
    public static List<Long> calcPages(int curPage, long itemsCount){
        long pageCount = (long)Math.round((itemsCount / itemsLimit)) + 1;
        if(itemsCount % itemsLimit == 0)
            pageCount--;

        List<Long> result = new ArrayList();
        result.add(beginPage);
        long left = curPage - offset <= beginPage ? beginPage : curPage - offset;
        long right = curPage + offset >= pageCount ? pageCount : curPage + offset;
        left = left - offset <= beginPage ? left + 1 : left;
        right = right + offset >= pageCount ? right - 1 : right;
        for(long i = left; i <= right; i++){
            result.add(i);
        }
        if(pageCount > 1)
            result.add(pageCount);
        return result;
    }
}
