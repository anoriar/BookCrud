package com.crud.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PaginationTest {
    @Test
    public void calcPages() throws Exception {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(6L);
        assertEquals(list, Pagination.calcPages(2, 26));
    }

}