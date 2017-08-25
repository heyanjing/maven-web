package com.he.spring.util;

import org.junit.Test;

/**
 * Created by heyanjing on 2017/7/3 16:41.
 */
public class FilesTest {
    @Test
    public void downloadFromUrl() throws Exception {

        Files.downloadFromUrl("http://download.cyberghostvpn.com/windows/CyberGhost_6.0.7.2738.exe","D:/");
    }

    @Test
    public void downloadFromUrl1() throws Exception {
    }

}