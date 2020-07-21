package com.gxgeek;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GifTest {
    public static void main(String[] args) throws IOException {
        final URL url = new URL("https://mmbiz.qpic.cn/mmbiz_gif/qwxf4wHyyTEqj4b8VeF3X0YEPUaPlicb5m8boreNZH9EkL8M3VHRyrhsBG84nuImBqbhLhxFUj9oSvPmGIFxZzA/640?wx_fmt=gif");

        final BufferedImage read = ImageIO.read(url);
        System.out.println(read);
    }
}
