package de.fhro.inf.p3.uebung06;

import junit.framework.TestCase;

import java.util.logging.Logger;

/**
 * Created by felix on 11/6/13.
 */
public class TestFileSystem extends TestCase {

    private static Logger logger = Logger.getLogger(TestFileSystem.class.getName());

    public void testFilesAndFolders() {
        File f1, f2, f3, f4, f5, f6, f7, f8, f9, f10;
        Folder d1, d2, d3, d4, d5;

        // create files & folders
        f1 = new File("file_1", 10);
        f2 = new File("file_2", 15);
        f3 = new File("file_3", 20);
        f4 = new File("file_4", 25);
        f5 = new File("file_5", 30);
        f6 = new File("file_6", 35);
        f7 = new File("file_7", 40);
        f8 = new File("file_8", 45);
        f9 = new File("file_9", 50);
        f10 = new File("file_10", 55);

        d1 = new Folder("folder_1");
        d2 = new Folder("folder_2");
        d3 = new Folder("folder_3");
        d4 = new Folder("folder_4");
        d5 = new Folder("folder_5");


        // add files and folders to folders
        d1.add(f1);
        d1.add(f2);
        d1.add(f3);
        d1.add(f4);

        d2.add(f5);
        d2.add(f6);

        d1.add(d2);

        d2.add(d3);

        d3.add(f7);
        d3.add(f8);
        d3.add(d4);

        d4.add(f9);
        d4.add(f10);

        d2.add(d5);

        logger.info("files & folders created successfully!");


        assertEquals(f1.size(), new Integer(10));
        assertEquals(f2.size(), new Integer(15));
        assertEquals(f3.size(), new Integer(20));
        assertEquals(f4.size(), new Integer(25));
        assertEquals(f5.size(), new Integer(30));
        assertEquals(f6.size(), new Integer(35));
        assertEquals(f7.size(), new Integer(40));
        assertEquals(f8.size(), new Integer(45));
        assertEquals(f9.size(), new Integer(50));
        assertEquals(f10.size(), new Integer(55));

        assertEquals(d1.size(), new Integer(325));
        assertEquals(d2.size(), new Integer(255));
        assertEquals(d3.size(), new Integer(190));
        assertEquals(d4.size(), new Integer(105));
        assertEquals(d5.size(), new Integer(0));

        logger.info("files & folders sizes are correct!");


        try {
            f1.add(f2);
            fail();
        } catch (UnsupportedOperationException e) {
            logger.info("file throws correct exeption!");
        }
    }
}
