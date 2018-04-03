package com.getlikes.util

import org.junit.Assert
import org.junit.Test

class CipherUtilTest {

    @Test fun md5HexTest1() {
        val inputString = "123456"
        val expectedOutputString = "e10adc3949ba59abbe56e057f20f883e"

        val outputString = CipherUtil.md5Hex(inputString)

        Assert.assertEquals(expectedOutputString, outputString)
    }

    @Test fun md5HexTest2() {
        val inputString = "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
            "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd"
        val expectedOutputString = "90e2789a46475e07ecdf7fbea34ce92d"

        val outputString = CipherUtil.md5Hex(inputString)

        Assert.assertEquals(expectedOutputString, outputString)
    }

    @Test fun md5HexTestEmpty() {
        val inputString = ""
        val expectedOutputString = "d41d8cd98f00b204e9800998ecf8427e"

        val outputString = CipherUtil.md5Hex(inputString)

        Assert.assertEquals(expectedOutputString, outputString)
    }

}