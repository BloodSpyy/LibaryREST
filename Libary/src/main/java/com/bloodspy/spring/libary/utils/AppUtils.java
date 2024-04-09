package com.bloodspy.spring.libary.utils;

import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchUrlException;

public class AppUtils {
    public static void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new NoSuchUrlException("Page number cannot be less then zero");
        }
        if(size < 0) {
            throw new NoSuchUrlException("Size number cannot be less then zero");
        }
        if(size > AppConstant.MAX_PAGE_SIZE) {
            throw new NoSuchUrlException("Size number must not be greater then "
                    + AppConstant.MAX_PAGE_SIZE
            );
        }
    }
}
