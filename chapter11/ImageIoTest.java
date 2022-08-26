package chapter11;

import javax.imageio.ImageIO;

public class ImageIoTest {
    public static void main(String[] args) {
        String[] readFormat = ImageIO.getReaderFormatNames();
        System.out.println("-----------Image能读的所有图形文件的格式---------");
        for(var tmp : readFormat){
            System.out.println(tmp);
        }

    }
}
